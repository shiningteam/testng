package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerMyAccountPage;
import allovercommerce.pages.customerpages.CustomerRegisterPage;
import allovercommerce.pages.customerpages.CustomerShippingAddressPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_04_TC_01 {

        @Test
        public void shippingAddressAddTest() {
        CustomerHomePage customerHomePage = new CustomerHomePage();

        //User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on the register icon
        customerHomePage.customerRegisterIcon.click();

        //Enter the username, email, password, select the privacy policy checkbox and click on the signup button
        Faker faker = new Faker();
        CustomerRegisterPage customerRegisterPage = new CustomerRegisterPage();
        customerRegisterPage.registerUsernameInput.sendKeys(faker.name().username());
        customerRegisterPage.registerEmailInput.sendKeys(faker.internet().emailAddress());
        customerRegisterPage.registerPasswordInput.sendKeys(faker.internet().password());
        customerRegisterPage.registerPolicyCheckbox.click();
        customerRegisterPage.signUpButton.click();

        //Scroll down the page
        JSUtils.scrollDownByJS();

        //Click on the "My Account" button
         ReusableMethods.waitFor(3);
         customerHomePage.myAccountButton.click();

        //Click on the "Addresses" button
         CustomerMyAccountPage customerMyAccountPage = new CustomerMyAccountPage();
         customerMyAccountPage.addressesIcon.click();

        //Go to the "Shipping Address" and click on the ADD button
        ReusableMethods.waitFor(3);
        customerMyAccountPage.addShippingAddressButton.click();

        //Enter the First name, Last name, Country/Region, Street address, Town / City, State and ZIP Code.
        CustomerShippingAddressPage customerShippingAddressPage = new CustomerShippingAddressPage();
        customerShippingAddressPage.shippingFirstnameInput.sendKeys(faker.name().firstName());
        customerShippingAddressPage.shippingLastnameInput.sendKeys(faker.name().lastName());
        customerShippingAddressPage.shippingCompany.sendKeys("Apple");

        Select select = new Select(customerShippingAddressPage.selectCountryDropdown);
        select.selectByVisibleText("United States (US)");

        customerShippingAddressPage.shippingStreetAddressInput.sendKeys(faker.address().fullAddress());
        customerShippingAddressPage.shippingCityInput.sendKeys(faker.address().city());

        Select select2 = new Select(customerShippingAddressPage.selectStateDropdown);
        select2.selectByVisibleText("California");

        customerShippingAddressPage.shippingZipCodeInput.sendKeys(faker.address().zipCode());

        //Click on the "Save Address" button
        ReusableMethods.waitFor(2);
        customerShippingAddressPage.saveAddressButton.submit();

        //Verify the Shipping Address be added successfully
        Assert.assertTrue(customerShippingAddressPage.successfulMessage.isDisplayed());

    }
}
