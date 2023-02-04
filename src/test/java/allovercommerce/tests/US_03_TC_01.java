package allovercommerce.tests;

import allovercommerce.pages.customerpages.*;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_03_TC_01 {

    CustomerHomePage customerHomePage;
    @BeforeMethod
    public void billingAddress(){
        CustomerHomePage customerHomePage = new CustomerHomePage();

        // User navigates to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // User clicks on the register icon.
        customerHomePage.customerRegisterIcon.click();

        // User enters the username, email, password, select the privacy policy checkbox and click on the signup button.
        Faker faker = new Faker();
        CustomerRegisterPage customerRegisterPage = new CustomerRegisterPage();
        customerRegisterPage.registerUsernameInput.sendKeys(faker.name().username());
        customerRegisterPage.registerEmailInput.sendKeys(faker.internet().emailAddress());
        customerRegisterPage.registerPasswordInput.sendKeys(faker.internet().password());
        customerRegisterPage.registerPolicyCheckbox.click();
        customerRegisterPage.signUpButton.click();

        // User scrolls down the page.
        JSUtils.scrollDownByJS();

        // User clicks on the "My Account" button.
        ReusableMethods.waitFor(3);
        customerHomePage.myAccountButton.click();

        // User clicks on the "Addresses" button.
        CustomerMyAccountPage customerMyAccountPage = new CustomerMyAccountPage();
        customerMyAccountPage.addressesIcon.click();

        // User goes to the "Billing Address" and click on the ADD button.
        ReusableMethods.waitFor(3);
        JSUtils.scrollIntoViewJS(customerMyAccountPage.addBillingAddressButton);
        JSUtils.clickElementByJS(customerMyAccountPage.addBillingAddressButton);
        //customerMyAccountPage.addBillingAddressButton.click();
    }

        @Test
        public void TC_01_test() {

            // User enters the First name, Last name, Country/Region, Street address, Town / City, State ZIP Code and Phone.
            Faker faker = new Faker();
            CustomerBillingAddressPage customerBillingAddressPage = new CustomerBillingAddressPage();
            customerBillingAddressPage.billingFirstnameInput.sendKeys(faker.name().firstName());
            customerBillingAddressPage.billingLastnameInput.sendKeys(faker.name().lastName());
            customerBillingAddressPage.billingCompany.sendKeys("Apple");

            Select select = new Select(customerBillingAddressPage.selectCountryDropdown);
            select.selectByVisibleText("United States (US)");

            customerBillingAddressPage.billingStreetAddressInput.sendKeys(faker.address().fullAddress());
            customerBillingAddressPage.billingCityInput.sendKeys(faker.address().city());

            Select select2 = new Select(customerBillingAddressPage.selectStateDropdown);
            select2.selectByVisibleText("California");

            customerBillingAddressPage.billingZipCodeInput.sendKeys(faker.address().zipCode());

            customerBillingAddressPage.billingPhone.sendKeys(faker.phoneNumber().cellPhone());

            // User verifies the registered email address is filled in automatically.
            customerBillingAddressPage.billingEmail.isDisplayed();

            // User clicks on the "Save Address" button.
            ReusableMethods.waitFor(2);
            customerBillingAddressPage.saveAddressButton.submit();

            // User verifies the "Billing Address" is added successfully.
            Assert.assertTrue(customerBillingAddressPage.successfulMessage.isDisplayed());
        }

    @Test
    public void TC_02_test() {
        CustomerBillingAddressPage customerBillingAddressPage = new CustomerBillingAddressPage();
        ReusableMethods.waitFor(2);
        //Click on the "Save Address" button
        customerBillingAddressPage.saveAddressButton.submit();

        //Verify the user receive a warning message
        Assert.assertTrue(customerBillingAddressPage.firstnameAlertMessage.isDisplayed());
    //    Assert.assertTrue(customerBillingAddressPage.lastnameAlertMessage.isDisplayed());
    //    Assert.assertTrue(customerBillingAddressPage.countryAlertMessage.isDisplayed());
    //    Assert.assertTrue(customerBillingAddressPage.addressAlertMessage.isDisplayed());
    //    Assert.assertTrue(customerBillingAddressPage.cityAlertMessage.isDisplayed());
    //    Assert.assertTrue(customerBillingAddressPage.stateAlertMessage.isDisplayed());
    //    Assert.assertTrue(customerBillingAddressPage.zipcodeAlertMessage.isDisplayed());
    }

//    @AfterMethod
//    public void closeBrowser(){
//        ReusableMethods.waitFor(3);
//        Driver.closeDriver();
//    }
}
