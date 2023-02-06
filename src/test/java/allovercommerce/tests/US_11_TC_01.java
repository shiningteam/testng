package allovercommerce.tests;
import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerRegisterPage;
import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorMyAccountPage;
import allovercommerce.pages.vendorpages.VendorRegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_11_TC_01 {

    /*
1- User navigates to "https:https:https://allovercommerce.com/"
2- User clicks "Sign In" icon.
3- User enters an existing e-mail address in the "Username or email address" field.
4- User enters password in the "Password" field.
5- User clicks "Sign In" button.
6- User should see "My account" as  a Vendor.
7- User should see  "Orders, Downloads, addresses, account details,whislist ve Logout " and verify it
8- User should see  "Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out"  in Dashboard  and verify it
     */

    VendorHomePage vendorHomePage = new VendorHomePage();
    VendorRegisterPage vendorRegisterPage = new VendorRegisterPage();
    CustomerHomePage customerHomePage = new CustomerHomePage();
    CustomerRegisterPage customerRegisterPage = new CustomerRegisterPage();
    VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();
    @Test
    public void test01() {
        //1- User navigates to "https:https:https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // 2- User clicks "Sign In" icon.
        vendorHomePage = new VendorHomePage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.vendorSignInIcon);

        //3- User enters an existing e-mail address in the "Username or email address" field.
        ReusableMethods.waitFor(2);
        customerHomePage.username.sendKeys(ConfigReader.getProperty("vendor_email"));

        // 4- User enters password in the "Password" field.
        ReusableMethods.waitFor(2);
        customerHomePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));


        //5- User clicks "Sign In" button.
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.vendorSignInButton);

        //6- User should see "My account" as  a Vendor.
        //BUG user couldn't see him/herself as a vendor
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorHomePage.myAcountIcon);

        //7- User should see  "Orders, Downloads, addresses, account details, whislist,
        // Logout " and verify them

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorOrdersIcon.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorDownloadsIcon.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorAddressesIcon.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorAccounDetailsIcon.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorWishListIcon.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorLogoutIcon.isDisplayed());

        //  8- User should see  "Store manager, orders, downloads, addresses , account details,
        //  wishlist, Support tickets, followings" ind Dashboard and verify them.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.storeManagerIcon.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorOrdersButton.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.vendorDownLoadsButton.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.VendorAddressesButton.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.VendorWishListButton.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.VendorSupportTicketButton.isDisplayed());

        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.VendorFollowingsButton.isDisplayed());
        ReusableMethods.waitFor(4);

    }

    @AfterMethod
    public void closeBrowser(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }

}


