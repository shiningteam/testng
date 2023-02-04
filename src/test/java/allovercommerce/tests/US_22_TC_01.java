package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerRegisterPage;
import allovercommerce.pages.customerpages.CustomerShoppingCartPage;
import allovercommerce.pages.vendorpages.*;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static allovercommerce.utilities.JSUtils.clickElementByJS;

public class US_22_TC_01 {
    VendorHomePage vendorHomePage=new VendorHomePage();
    VendorCheckoutPage vendorCheckoutPage=new VendorCheckoutPage();
    VendorRegisterPage vendorRegisterPage=new VendorRegisterPage();
    VendorMyAccountPage vendorMyAccountPage=new VendorMyAccountPage();
    @Test
    public void couponTest() {
//        1- User goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitForPageToLoad(10);
//        2- Click "Sign in" button
        JSUtils.clickElementByJS(vendorHomePage.vendorSignInIcon);
        ReusableMethods.waitFor(3);
//        3- Enter username or email address
        vendorRegisterPage.vendorSignInUsernameInput.sendKeys(ConfigReader.getProperty("vendor_email2"));
//        4- Enter password
        vendorRegisterPage.vendorSignInPasswordInput.sendKeys(ConfigReader.getProperty("vendor_password2"));
//        5- Click the "sign in" button
        vendorRegisterPage.vendorSignInButton.click();
        ReusableMethods.waitFor(3);
//        6- Click on "My Account" button bottom of the page
        JSUtils.scrollDownByJS();
        ReusableMethods.waitFor(3);
        clickElementByJS(vendorHomePage.myAccountButton);
        ReusableMethods.waitFor(3);
//        7- Click on "Orders" button
        JSUtils.clickElementByJS(vendorMyAccountPage.orders);
        ReusableMethods.waitFor(3);
//        8- Click on "BROWSE PRODUCTS" botton
        JSUtils.clickElementByJS(vendorMyAccountPage.browseProducts);
        ReusableMethods.waitFor(3);
//        9- Click on a product
        JSUtils.clickElementByJS(vendorMyAccountPage.georgeOrwell);
        ReusableMethods.waitFor(3);
//        10- Add to cart it
        JSUtils.clickElementByJS(vendorMyAccountPage.addToCart);
        ReusableMethods.waitFor(3);
//        11- Go to cart and click on
        JSUtils.clickElementByJS(vendorMyAccountPage.cart);
        ReusableMethods.waitFor(3);
//        12- Click on checkout
        JSUtils.clickElementByJS(vendorMyAccountPage.checkout);
        ReusableMethods.waitFor(3);
//        13- Click on "ENTER YOUR CODE"
        JSUtils.clickElementByJS(vendorCheckoutPage.enterYourCode);
        ReusableMethods.waitFor(3);
//        14- Enter "Coupon code"
        vendorCheckoutPage.couponCode.sendKeys(ConfigReader.getProperty("couponcode"));
        ReusableMethods.waitFor(3);
//        15- Click on "APPLY COUPON" button
        JSUtils.clickElementByJS(vendorCheckoutPage.applyCoupon);
        ReusableMethods.waitFor(3);

        Assert.assertTrue(vendorCheckoutPage.alert.isDisplayed());
//        16- Enter the First name, Last name, Country/Region, Street address, Town / City, State , ZIP code,Phone number and e-mail address then
//        17- Click on "Ship to a different address?" as a last write anything on "order notes" part.
//        18- Verify if the total amount is exist on the page or not.
//        19- Verify if Wire transfer/EFT or Pay at the door are selectable or not.
//        20-Then click on PLACE ORDER
//        21- Verify if the shopping has been completed or not.
//        22- Go to "My Account" and click on Orders and verify if there is exist the details of user's shopping.

    }
}
