package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerMyAccountPage;
import allovercommerce.pages.customerpages.CustomerShippingAddressPage;
import allovercommerce.pages.vendorpages.VendorBillingAddressPage;
import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorMyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static allovercommerce.utilities.JSUtils.clickElementByJS;
import static allovercommerce.utilities.JSUtils.scrollIntoViewJS;

public class US_12_TC_01 {

//    1-User goes to https://allovercommerce.com/
//    "2-Clicks on the sign in button as a vendor(Registered before as a vendor and username and
//    password will be remembered due to ""remember me"" button function)"
//    3-Clicks on the "My Account" button
//    4-Clicks on the "Adresses" button
//    5- Goes to the "Billing Address" and click on the ADD button
//    6-Enters the First name, Last name, Country/Region, Street address, Town / City, State and
//    ZIP Code."
//   7-Verifies the registered email address is filled in automatically
//   8-Clicks on the "Save Address" button
//   9-Verifies the Billing Address be added successfull

    @BeforeClass
    public void billingAddressPage() {

//        User navigates to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(3);

//        2-Clicks on the sign in button as a vendor(Registered before as a vendor and username and
//        password will be remembered due to ""remember me"" button function)"
        VendorHomePage VendorHomePage = new VendorHomePage();
        VendorHomePage.vendorSignInIcon.click();
        ReusableMethods.waitFor(3);
        VendorHomePage.username.sendKeys(ConfigReader.getProperty("vendor_username"));
        VendorHomePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
//     VendorHomePage.password.sendKeys("1S9h2T8e5A3m*");
        VendorHomePage.VendorSignInButton.click();
        ReusableMethods.waitFor(5);

//     Clicks on the "My Account" button
        JSUtils.scrollIntoViewJS(VendorHomePage.myAccountButton);
        clickElementByJS(VendorHomePage.myAccountButton);
        ReusableMethods.waitFor(3);

//    Clicks on the "Adresses" button
        VendorMyAccountPage VendorMyAccountPage = new VendorMyAccountPage();
        clickElementByJS(VendorMyAccountPage.AddressesButton);

 //    Goes to the "Billing Address" and click on the ADD button
        clickElementByJS(VendorMyAccountPage.AddressAddButton);
        ReusableMethods.waitFor(3);
    }

        @Test
        public void TC_01_Test() {
        VendorBillingAddressPage VendorBillingAddressPage = new VendorBillingAddressPage();
//    6-Enters the First name, Lwast name, Country/Region, Street address, Town / City, State and   ZIP Code with valid data
       VendorBillingAddressPage.BillingCompanyName.clear();
       VendorBillingAddressPage.BillingCompanyName.sendKeys("Google");
        scrollIntoViewJS(VendorBillingAddressPage.BillingCity);
        ReusableMethods.waitFor(3);
        Select select = new Select(VendorBillingAddressPage.BillingCountryOptions);
        select.selectByVisibleText("United States (US)");
        VendorBillingAddressPage.BillingStreetName.clear();
        VendorBillingAddressPage.BillingStreetName.sendKeys(ConfigReader.getProperty("vendor_street_address"));
        VendorBillingAddressPage.BillingCity.clear();
        VendorBillingAddressPage.BillingCity.sendKeys(ConfigReader.getProperty("vendor_city"));
        Select select2 = new Select(VendorBillingAddressPage.BillingStateOptions);
        select2.selectByVisibleText("California");
        VendorBillingAddressPage.BillingPostCode.clear();
        VendorBillingAddressPage.BillingPostCode.sendKeys(ConfigReader.getProperty("vendor_zip_code"));
        VendorBillingAddressPage.BillingPhone.clear();
        VendorBillingAddressPage.BillingPhone.sendKeys(ConfigReader.getProperty("vendor_phone_number"));

//   7-Verifies the registered email address is filled in automatically
        Boolean emailDisplayed = VendorBillingAddressPage.BillingEmail.isDisplayed();
        Assert.assertTrue(emailDisplayed);

//   8-Clicks on the "Save Address" button
       clickElementByJS(VendorBillingAddressPage.SaveAddressButton);
//   9-Verifies the Billing Address is added successfull
        ReusableMethods.waitFor(3);

        clickElementByJS(VendorBillingAddressPage.SaveAddressButton);
        ReusableMethods.waitFor(3);

//        VendorBillingAddressPage.EditYourBillinAddress.isDisplayed();
        }

//    @Test
//    public void TC_02_NegatifTest() throws IOException {
//        VendorBillingAddressPage VendorBillingAddressPage = new VendorBillingAddressPage();
////    6-Enters the First name, Last name, Country/Region, Street address, Town / City, State and   ZIP Code with invslid data
//        VendorBillingAddressPage.BillingCompanyName.sendKeys("-----");
//        scrollIntoViewJS(VendorBillingAddressPage.BillingCity);
//        ReusableMethods.waitFor(3);
//        Select select = new Select(VendorBillingAddressPage.BillingCountryOptions);
//        select.selectByVisibleText("Canada");
//        VendorBillingAddressPage.BillingStreetName.sendKeys("0000");
//        VendorBillingAddressPage.BillingCity.sendKeys("qw123");
//        Select select2 = new Select(VendorBillingAddressPage.BillingStateOptions);
//        select2.selectByVisibleText("Quebec");
//        VendorBillingAddressPage.BillingPostCode.clear();
//        VendorBillingAddressPage.BillingPostCode.sendKeys(("11111"));
//        VendorBillingAddressPage.BillingPhone.clear();
//        VendorBillingAddressPage.BillingPhone.sendKeys("0000000000");
//
////   7-Verifies the registered email address is filled in automatically
//        Boolean emailDisplayed = VendorBillingAddressPage.BillingEmail.isDisplayed();
//        Assert.assertTrue(emailDisplayed);
//        ReusableMethods.getScreenshot();
////   8-Clicks on the "Save Address" button
//        clickElementByJS(VendorBillingAddressPage.SaveAddressButton);
////   9-Verifies the Billing Address is added successfull
//        ReusableMethods.waitFor(3);
//
//        clickElementByJS(VendorBillingAddressPage.SaveAddressButton);
//        ReusableMethods.waitFor(3);
//
// //       VendorBillingAddressPage.EditYourBillinAddress.isDisplayed();
  //  }

    @AfterClass
       public void closeBrowser(){
       ReusableMethods.waitFor(3);
       Driver.closeDriver();
    }
}

