package allovercommerce.tests;

import allovercommerce.pages.vendorpages.*;
import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerRegisterPage;
import allovercommerce.pages.customerpages.CustomerShoppingCartPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_21_TC_01 {
    VendorHomePage vendorHomePage=new VendorHomePage();
    VendorRegisterPage vendorRegisterPage=new VendorRegisterPage();
    VendorStoreManagerPage vendorStoreManagerPage=new VendorStoreManagerPage();
    VendorCouponsPage vendorCouponsPage=new VendorCouponsPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();
    CustomerRegisterPage customerRegisterPage=new CustomerRegisterPage();
    CustomerShoppingCartPage customerShoppingCartPage=new CustomerShoppingCartPage();
    VendorMyAccountPage vendorMyAccountPage=new VendorMyAccountPage();
    Faker faker=new Faker();
    @Test
    public void enterTheGeneratedCoupon() throws IOException {
        PageFactory.initElements(Driver.getDriver(), this);

        // The user goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        ReusableMethods.waitForPageToLoad(10);

        // Click "Sign in" button
        JSUtils.clickElementByJS(vendorHomePage.vendorSignInIcon);

        ReusableMethods.waitFor(3);

        //Enter username or email address
        vendorRegisterPage.vendorSignInUsernameInput.sendKeys(ConfigReader.getProperty("vendor_username"));

        //Enter password
        vendorRegisterPage.vendorSignInPasswordInput.sendKeys(ConfigReader.getProperty("vendor_password"));

        // Click the "sign in" button
        vendorRegisterPage.vendorSignInButton.click();

        ReusableMethods.waitFor(5);

        //Click the Sign Out button and go to my Account
        JSUtils.clickElementByJS(vendorHomePage.signOutIcon);

        // Click the "Store Manager" button
        JSUtils.clickElementByJS(vendorMyAccountPage.storeManagerIcon);

        //Click the Coupons button
        JSUtils.clickElementByJS(vendorStoreManagerPage.couponsButton);

        //Click the "Add New" button
        JSUtils.clickElementByJS(vendorCouponsPage.couponsAddNewIcon);
        ReusableMethods.waitFor(3);

        //Click the Code box
       ReusableMethods.waitForClickablility(vendorCouponsPage.codeBox, 10);

        //Enter the code value
        String code= faker.number().digits(4);
        vendorCouponsPage.codeBox.sendKeys(code);

        //Click the Description box
        ReusableMethods.waitForClickablility(vendorCouponsPage.descriptionBox, 10);

        //Enter the Description value
        vendorCouponsPage.descriptionBox.sendKeys(faker.internet().domainName());

        //Click the Discount Type dropdown and verify Percentage discount or Fixed Product Discount should be able to selected.
        Select select=new Select(vendorCouponsPage.discountTypeDropdown);
        ReusableMethods.getScreenshot();
        select.selectByVisibleText("Fixed Product Discount");

        //Click the Coupon Amount box
        ReusableMethods.waitForVisibility(vendorCouponsPage.couponAmountBox,10);

        //Enter the coupon amount
        vendorCouponsPage.couponAmountBox.clear();
        vendorCouponsPage.couponAmountBox.sendKeys(faker.number().digits(3));
        ReusableMethods.waitFor(4);

        //Click the Coupon expiration date box
       JSUtils.clickElementByJS(vendorCouponsPage.couponExpiryDateBox);

        //Enter the coupon expriy date
        Select selectMonth=new Select(vendorCouponsPage.monthDropdown);

        Select selectYear=new Select(vendorCouponsPage.yearDropdown);
        selectYear.selectByVisibleText("2023");
        selectMonth.selectByVisibleText("Dec");
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(vendorCouponsPage.decDay);

        // Allow free shipping', 'Show on store' should be capable of being selected
        Assert.assertTrue(vendorCouponsPage.allowFreeShippingCheckbox.isEnabled());
        Assert.assertTrue(vendorCouponsPage.showOnStoreCheckbox.isEnabled());

        //Click the submit button
        JSUtils.clickElementByJS(vendorCouponsPage.submitButton);
        ReusableMethods.getScreenshot();
        ReusableMethods.waitFor(3);


        // Click "Sign Out" button
//        vendorHomePage.signOutIcon.click();
//        vendorHomePage.logOutIcon.click();
//
//        //Enter username or email address
//        customerRegisterPage.signInUsernameInput.sendKeys(ConfigReader.getProperty("customer_username"));
//
//        //Enter password
//        customerRegisterPage.signInPasswordInput.sendKeys(ConfigReader.getProperty("customer_password"));
//        ReusableMethods.waitFor(3);
//
//        //Click the sign in button
//        ReusableMethods.waitForClickablility(customerRegisterPage.signInButton, 15);
//
//        //Click the men's clothing product add to cart button
//
//
//        //Click the Cart button
//
//
//        //Click the view cart button
//
//
//        //Click the enter code here box
//        customerShoppingCartPage.enterCouponBox.click();
//
//        //Enter the coupon
//        customerShoppingCartPage.enterCouponBox.sendKeys(code);
//
//        //Click the apply coupon button
//        customerShoppingCartPage.applyCouponButton.click();


//    Generated coupons should be visible.
//   The generated coupon should be entered by clicking ENTER YOUR CODE.

    }
}
