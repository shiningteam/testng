package allovercommerce.tests;
import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorRegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_10_TC_01 {

    /*
1- User navigates to "https://allovercommerce.com/"
2- User clicks "Register" button.
3- User clicks "Become a Vendor".
4- User enters the "short"  Password.
5- User should see the "Too Short" message on the console and verify it.
6- User enters a  "weak" Password.
7- User should see the "Weak" message on the console and verify it.
8- User enters a  "good" Password.
9- User should see the "Good" message on the console and verify it.
10- User enters a "strong" Password.
11- User should see the "Strong" message on the console and verify it.

     */
    VendorHomePage vendorHomePage = new VendorHomePage();
    VendorRegisterPage vendorRegisterPage = new VendorRegisterPage();


    @Test
    public void test01() {

        //1- User navigates to "https:https:https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // 2- User clicks "Registration" button.
        vendorHomePage = new VendorHomePage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.vendorRegisterButton);

        // 3- User clicks "Become a Vendor".
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.becomeAVendorButton);
        ReusableMethods.waitFor(2);

        // 4- User enters the "short"  Password.
        ReusableMethods.waitFor(2);
        vendorRegisterPage.vendorPassword.sendKeys(ConfigReader.getProperty("too_short_password"));

        // 5- User should see the "Too Short" message on the console and verify it.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorRegisterPage.tooShortPassword.isDisplayed());
        ReusableMethods.waitFor(2);

//        Driver.closeDriver();
    }
    @Test
    public void test02() {

        //1-User navigates to "https:https:https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // 2- User clicks "Registration" button.
        vendorHomePage = new VendorHomePage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.vendorRegisterButton);

        // 3- User clicks "Become a Vendor".
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.becomeAVendorButton);
        ReusableMethods.waitFor(5);

        // 6- User enters a  "weak" Password.
        ReusableMethods.waitFor(2);
        vendorRegisterPage.vendorPassword.sendKeys(ConfigReader.getProperty("weak_password"));

        // 7- User should see the "Weak" message on the console and verify it.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorRegisterPage.weakPassword.isDisplayed());
        ReusableMethods.waitFor(2);

//        Driver.closeDriver();

    }

    @Test
    public void test03() {

        // 1-User navigates to "https:https:https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // 2- User clicks "Registration" button.
        vendorHomePage = new VendorHomePage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.vendorRegisterButton);

        // 3- User clicks "Become a Vendor".
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.becomeAVendorButton);
        ReusableMethods.waitFor(5);

        // 8- User enters a  "good" Password.
        ReusableMethods.waitFor(2);
        vendorRegisterPage.vendorPassword.sendKeys(ConfigReader.getProperty("good_password"));

        // 9- User should see the "Good" message on the console and verify it.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorRegisterPage.goodPassword.isDisplayed());
        ReusableMethods.waitFor(2);
        //Driver.closeDriver();
    }
    @Test
    public void test04() {

        // 1-User navigates to "https:https:https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // 2- User clicks "Registration" button.
        vendorHomePage = new VendorHomePage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.vendorRegisterButton);

        // 3- User clicks "Become a Vendor".
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.becomeAVendorButton);
        ReusableMethods.waitFor(5);

        // 10- User enters a "strong" Password.
        ReusableMethods.waitFor(2);
        vendorRegisterPage.vendorPassword.sendKeys(ConfigReader.getProperty("strong_password"));

        // 11- User should see the "Strong" message on the console and verify it.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorRegisterPage.strongPassword.isDisplayed());
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
}
