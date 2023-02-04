package allovercommerce.tests;

import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import static allovercommerce.utilities.JSUtils.clickElementByJS;

public class US_16_TC_01 {

@Test public void us_16 (){


//      1- User goes to ''https://allovercommerce.com/''
    Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
 ReusableMethods.waitFor(5);
//        2- Click "Sign in" button
 VendorHomePage VendorHomePage = new VendorHomePage();
 VendorHomePage.VendorSignInIcon.click();
 ReusableMethods.waitFor(3);
//        3- Enter username or email address
 VendorHomePage.username.sendKeys(ConfigReader.getProperty("vendor_username"));
    ReusableMethods.waitFor(3);

//        4- Enter password
 VendorHomePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
    ReusableMethods.waitFor(3);
//        5- Click the "sign in" button
 VendorHomePage.VendorSignInButton.click();
 ReusableMethods.waitFor(5);
//        6- Click on "My Account" button at bottom of the page
 JSUtils.scrollDownByJS();
 clickElementByJS(VendorHomePage.myAccountButton);
 ReusableMethods.waitFor(5);
//        7- Click on "Store Manager" button
 VendorStoreManagerPage VendorStoreManagerPage  = new VendorStoreManagerPage();
 VendorStoreManagerPage.StoreManagerButton.click();
 ReusableMethods.waitFor(3);
//        8- Click on "Products" button
 clickElementByJS(VendorStoreManagerPage.ProductsButton);
 ReusableMethods.waitFor(3);

//     1-The vendor Clicks Add Product button
 VendorStoreManagerPage.AddNewButton.click();
 ReusableMethods.waitFor(3);

   // 2-Verify the Simple Product is the default

    Assert.assertTrue(VendorStoreManagerPage.simpleProductDropdown.isDisplayed());
    ReusableMethods.waitFor(3);

    // 3-The vendor clicks virtual option and Downloadable option

    VendorStoreManagerPage.virtualCheckBox.click();
    ReusableMethods.waitFor(3);
    Assert.assertTrue(VendorStoreManagerPage.downloadableCheckBox.isDisplayed());

    VendorStoreManagerPage.downloadableCheckBox.click();
    ReusableMethods.waitFor(3);
    Assert.assertTrue(VendorStoreManagerPage.downloadableCheckBox.isDisplayed());

    //4- The vendor types the  price for the products

    VendorStoreManagerPage.priceBox.sendKeys("$350");
    ReusableMethods.waitFor(3);

    VendorStoreManagerPage.salePriceBox.sendKeys("$700");
    ReusableMethods.waitFor(3);

  }

}
