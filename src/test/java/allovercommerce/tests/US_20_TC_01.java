package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.vendorpages.VendorCouponsPage;
import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorMyAccountPage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_20_TC_01 {
    CustomerHomePage customerHomePage = new CustomerHomePage();
    VendorHomePage vendorHomePage = new VendorHomePage();
    VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();
    VendorStoreManagerPage vendorStoreManagerPage = new VendorStoreManagerPage();
    VendorCouponsPage vendorCouponsPage = new VendorCouponsPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void vendorPage() {
        //    Open the https://allovercommerce.com/ website.
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        //Sıgn in as a vendor
        customerHomePage.signIn.click();
        customerHomePage.username.sendKeys(ConfigReader.getProperty("vendor_username"));
        customerHomePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
        customerHomePage.submit.click();

        // Click on My Account
        ReusableMethods.waitFor(10);
        JSUtils.clickElementByJS(vendorHomePage.myAccountButton);

        // Click the "Store Manager" button
        JSUtils.clickElementByJS(vendorMyAccountPage.storeManagerIcon);

        //Click the Coupons button
        JSUtils.clickElementByJS(vendorStoreManagerPage.couponsButton);

        //Click the "Add New" button
        JSUtils.clickElementByJS(vendorCouponsPage.couponsAddNewIcon);
        ReusableMethods.waitFor(3);

        //Click the Code box
        ReusableMethods.waitForClickablility(vendorCouponsPage.codeBox, 10);








        //Click the Description box
        ReusableMethods.waitForClickablility(vendorCouponsPage.descriptionBox, 10);

        //Enter the Description value
        vendorCouponsPage.descriptionBox.sendKeys(faker.internet().domainName());

    }

    @Test
    public void testCase01() throws IOException {
        //Enter the code value
        String code = faker.number().digits(4);
        vendorCouponsPage.codeBox.sendKeys(code);
        ReusableMethods.waitFor(3);

        //Click the Discount Type dropdown and verify Percentage discount or Fixed Product Discount should be able to selected.
        Select select = new Select(vendorCouponsPage.discountTypeDropdown);
        select.selectByVisibleText("Percentage discount");

        //Click the Coupon Amount box
        ReusableMethods.waitForVisibility(vendorCouponsPage.couponAmountBox, 10);

        //Enter the coupon amount
        vendorCouponsPage.couponAmountBox.clear();
        vendorCouponsPage.couponAmountBox.sendKeys("10");

        ReusableMethods.waitFor(4);

        //Enter the coupon expriy date
        vendorCouponsPage.couponExpiryDateBox.sendKeys("2023-02-28");


        // Allow free shipping', 'Show on store' should be capable of being selected
        assertTrue(vendorCouponsPage.allowFreeShippingCheckbox.isEnabled());
        assertTrue(vendorCouponsPage.showOnStoreCheckbox.isEnabled());



        //Click the submit button
        JSUtils.clickElementByJS(vendorCouponsPage.submitButton);
        ReusableMethods.waitFor(3);
//    Verify that the generated coupon is visible on the coupons list page



        JSUtils.clickElementByJS(vendorStoreManagerPage.couponsButton);
       ReusableMethods.waitFor(3);

       String sameCode = vendorStoreManagerPage.firstCode.getText();
        System.out.println("sameCode = " + sameCode);
        assertEquals(code,sameCode);



    }


    @Test
    public void testCase2() {
        //Enter the code value
        String code = faker.number().digits(4);
        vendorCouponsPage.codeBox.sendKeys(code);
        ReusableMethods.waitFor(3);

        //Click the Discount Type dropdown and verify Percentage discount or Fixed Product Discount should be able to selected.
        Select select = new Select(vendorCouponsPage.discountTypeDropdown);
        select.selectByVisibleText("Fixed Product Discount");

        //Click the Coupon Amount box
        ReusableMethods.waitForVisibility(vendorCouponsPage.couponAmountBox, 10);

        //Enter the coupon amount
        vendorCouponsPage.couponAmountBox.clear();
        vendorCouponsPage.couponAmountBox.sendKeys("10");
        ReusableMethods.waitFor(4);


        //Enter the coupon expriy date
        vendorCouponsPage.couponExpiryDateBox.sendKeys("2023-02-28");

        // Allow free shipping', 'Show on store' should be capable of being selected
        assertTrue(vendorCouponsPage.allowFreeShippingCheckbox.isEnabled());
        assertTrue(vendorCouponsPage.showOnStoreCheckbox.isEnabled());

        //Click the submit button
        JSUtils.clickElementByJS(vendorCouponsPage.submitButton);
        ReusableMethods.waitFor(3);
//    Verify that the generated coupon is visible on the coupons list page



        JSUtils.clickElementByJS(vendorStoreManagerPage.couponsButton);
        ReusableMethods.waitFor(3);

        String sameCode = vendorStoreManagerPage.firstCode.getText();
        System.out.println("sameCode = " + sameCode);
        assertEquals(code,sameCode);

    }

    @AfterMethod
    public void tearDown() {
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
       }
}