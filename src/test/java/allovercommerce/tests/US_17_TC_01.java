package allovercommerce.tests;

import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static allovercommerce.utilities.JSUtils.*;

public class US_17_TC_01 {
    @Test
    public void testcase01() {
        //        1- User goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(3);
        //        2- Click "Sign in" button
        allovercommerce.pages.vendorpages.VendorHomePage VendorHomePage = new VendorHomePage();
        VendorHomePage.VendorSignInIcon.click();
        ReusableMethods.waitFor(3);
//        3- Enter username or email address
        VendorHomePage.username.sendKeys(ConfigReader.getProperty("vendor_username"));
//        4- Enter password
        VendorHomePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
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
//        9- Click on "Add New" button
        VendorStoreManagerPage.AddNewButton.click();
        ReusableMethods.waitFor(3);
        scrollIntoViewJS(VendorStoreManagerPage.addProductText);
//       10-Select  "Variable Product"
        Select select = new Select(VendorStoreManagerPage.productType);
        select.selectByIndex(1);
//       11-Verify  that variable product is selectable
        ReusableMethods.waitFor(3);
        String selectresult=select.getFirstSelectedOption().getText();
        System.out.println("selectresult = " + selectresult);
        Assert.assertEquals(selectresult,"Variable Product");

//       12-Click on attributes button
        scrollIntoViewJS(VendorStoreManagerPage.AttributesButton);
        JSUtils.clickElementByJS(VendorStoreManagerPage.AttributesButton);

//       13-Color and size checkboxes should click and verify that checkboxes are  selectable
        JSUtils.clickElementByJS(VendorStoreManagerPage.attributesColarCheckBox);
        JSUtils.clickElementByJS(VendorStoreManagerPage.attributesSizeCheckBox);
        Assert.assertTrue(VendorStoreManagerPage.attributesColarCheckBox.isSelected());
        Assert.assertTrue(VendorStoreManagerPage.attributesSizeCheckBox.isSelected());
////17-Click on "Add New" button for color
//        Faker faker=new Faker();
//        JSUtils.clickElementByJS(VendorStoreManagerPage.addButtonColor);
//        ReusableMethods.waitFor(3);
//        try {
//           String color= faker.name().firstName();
//            Driver.getDriver().switchTo().alert().sendKeys(color);
//            Driver.getDriver().switchTo().alert().accept();
//        } catch (Exception ignored){
//
//        }
//
////18-Click on "Add New" button for size
//        ReusableMethods.waitFor(2);
//        JSUtils.clickElementByJS(VendorStoreManagerPage.addButtonSize);
//        try {
//            String size=faker.address().zipCode();
//            Driver.getDriver().switchTo().alert().sendKeys(size);
//            ReusableMethods.waitFor(2);
//            Driver.getDriver().switchTo().alert().accept();
//        } catch (Exception ignored){
//
//        }
      //

        //19- Click "Variations" button
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(VendorStoreManagerPage.variationsButton);
        //20-Verify that attributes are visible
//        Select select3=new Select(VendorStoreManagerPage.anyColorDropdown);
//        select3.selectByValue("lightblue");
//        System.out.println("select3 = " + select3);
//        Select select4=new Select(VendorStoreManagerPage.anySizeDropdown);
//        select4.selectByIndex(0);

        // select3.selectByIndex(2);
        //            String searchResultsOnly = select3.getFirstSelectedOption().getText();
        //            Assert.assertEquals(searchResultsOnly, "Search results only");
        //            ReusableMethods.waitFor(3);




}
}