package allovercommerce.tests;


import allovercommerce.pages.vendorpages.*;
import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerMyAccountPage;
import allovercommerce.pages.customerpages.CustomerRegisterPage;
import allovercommerce.pages.customerpages.CustomerShoppingCartPage;

import allovercommerce.pages.customerpages.*;
import allovercommerce.pages.vendorpages.*;

import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class US_21_TC_01 {
    VendorHomePage vendorHomePage = new VendorHomePage();
    VendorRegisterPage vendorRegisterPage = new VendorRegisterPage();
    VendorStoreManagerPage vendorStoreManagerPage = new VendorStoreManagerPage();
    VendorCouponsPage vendorCouponsPage = new VendorCouponsPage();
    CustomerRegisterPage customerRegisterPage = new CustomerRegisterPage();
    CustomerShoppingCartPage customerShoppingCartPage = new CustomerShoppingCartPage();
    VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();
    CustomerMyAccountPage customerMyAccountPage = new CustomerMyAccountPage();
    CustomerHomePage customerHomePage = new CustomerHomePage();
    CustomerProductsPage customerProductsPage = new CustomerProductsPage();


    Faker faker = new Faker();

    @Test
    public void enterTheGeneratedCoupon() throws IOException {

        // The user goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(2);

        // Click "Sign in" button
        JSUtils.clickElementByJS(vendorHomePage.vendorSignInIcon);
        ReusableMethods.waitFor(3);

        //Enter username or email address
        vendorRegisterPage.vendorSignInUsernameInput.sendKeys(ConfigReader.getProperty("vendor_username"));

        //Enter password
        vendorRegisterPage.vendorSignInPasswordInput.sendKeys(ConfigReader.getProperty("vendor_password"));

        // Click the "sign in" button
        vendorRegisterPage.vendorSignInButton.click();
        ReusableMethods.waitFor(3);

        //Click the Sign Out button and go to my Account
        JSUtils.clickElementByJS(vendorHomePage.myAcountIcon);
        ReusableMethods.waitFor(2);

        // Click the "Store Manager" button
        JSUtils.clickElementByJS(vendorMyAccountPage.storeManagerIcon);
        ReusableMethods.waitFor(1);

        //Click the Coupons button
        JSUtils.clickElementByJS(vendorStoreManagerPage.couponsButton);
        ReusableMethods.waitFor(2);

        //Click the "Add New" button
        JSUtils.clickElementByJS(vendorCouponsPage.couponsAddNewIcon);
        ReusableMethods.waitFor(3);

        //Click the Code box
        ReusableMethods.waitForClickablility(vendorCouponsPage.codeBox, 10);

        //Enter the code value
        String code = faker.number().digits(4);
        vendorCouponsPage.codeBox.sendKeys(code);

        //Click the Description box
        ReusableMethods.waitForClickablility(vendorCouponsPage.descriptionBox, 10);

        //Enter the Description value
        vendorCouponsPage.descriptionBox.sendKeys(faker.internet().domainName());

        //Click the Discount Type dropdown and verify Percentage discount or Fixed Product Discount should be able to selected.
        Select select = new Select(vendorCouponsPage.discountTypeDropdown);
        ReusableMethods.getScreenshot();
        select.selectByVisibleText("Fixed Product Discount");

        //Click the Coupon Amount box
        ReusableMethods.waitForVisibility(vendorCouponsPage.couponAmountBox, 10);

        //Enter the coupon amount
        vendorCouponsPage.couponAmountBox.clear();
        vendorCouponsPage.couponAmountBox.sendKeys("10");
        ReusableMethods.waitFor(4);

        //Click the Coupon expiration date box send the exprity date
        JSUtils.clickElementByJS(vendorCouponsPage.couponExpiryDateBox);
        vendorCouponsPage.couponExpiryDateBox.sendKeys("2023-12-31");
        ReusableMethods.waitFor(2);

        // Allow free shipping', 'Show on store' should be capable of being selected
        Assert.assertTrue(vendorCouponsPage.allowFreeShippingCheckbox.isEnabled());
        Assert.assertTrue(vendorCouponsPage.showOnStoreCheckbox.isEnabled());

        //Click the submit button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorCouponsPage.submitButton);
        ReusableMethods.getScreenshot();

        ReusableMethods.waitFor(4);

        //Click the coupons link and verify generated coupons should be visible.
        JSUtils.clickElementByJS(vendorStoreManagerPage.couponsButton);
        ReusableMethods.waitFor(2);
        List<WebElement> codeList = Driver.getDriver().findElements(By.xpath("//tbody//tr//td"));
        List<String> codeList2 = new ArrayList<>();
        for (WebElement w : codeList) {
            codeList2.add(w.getText());
        }
        System.out.println(codeList2);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(codeList2.contains(code));

        // Click "Sign Out" button
        JSUtils.clickElementByJS(vendorStoreManagerPage.signOutIcon);
        ReusableMethods.waitFor(4);
        JSUtils.clickElementByJS(vendorMyAccountPage.logOutIcon);

        //Enter username or email address
        customerRegisterPage.signInUsernameInput.sendKeys(ConfigReader.getProperty("customer_username"));

        //Enter password
        customerRegisterPage.signInPasswordInput.sendKeys(ConfigReader.getProperty("customer_password"));
        ReusableMethods.waitFor(2);

        //Click the sign in button
        JSUtils.clickElementByJS(customerRegisterPage.signInButton);
        ReusableMethods.waitFor(2);

        JSUtils.clickElementByJS(customerMyAccountPage.alloverCommerceButton);
        ReusableMethods.waitFor(4);

        //Click the search button and search Chess
        //SUtils.clickElementByJS(customerHomePage.searchIcon);
        ReusableMethods.waitForVisibility(customerHomePage.searchBar, 10);
        customerHomePage.searchBar.sendKeys("Chess" + Keys.ENTER);

        ReusableMethods.waitFor(3);

//         //Click the add to cart button
        JSUtils.clickElementByJS(customerProductsPage.chessAddToCartButton);
        ReusableMethods.waitFor(4);

        //Click the view cart button
        JSUtils.clickElementByJS(customerProductsPage.viewCartButton);
        ReusableMethods.waitFor(3);

        //Click the enter code here box
        JSUtils.clickElementByJS(customerShoppingCartPage.enterCouponBox);
        ReusableMethods.waitFor(3);
//      Enter the coupon
        customerShoppingCartPage.enterCouponBox.sendKeys(code);
        ReusableMethods.waitFor(2);

//    Click the apply coupon button, The generated coupon should be entered by clicking ENTER YOUR CODE.
        JSUtils.clickElementByJS(customerShoppingCartPage.applyCouponButton);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot();

    }
}
