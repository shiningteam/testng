package allovercommerce.tests;

import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static allovercommerce.utilities.JSUtils.clickElementByJS;
import static allovercommerce.utilities.JSUtils.scrollIntoViewJS;

public class US_14_TC_01 {
    @Test
    public void seeTheOptionsToAddItemTest(){
//        1- User goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(3);
//        2- Click "Sign in" button
        VendorHomePage VendorHomePage = new VendorHomePage();
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
//        10- Verify ""Simple Product, Variable Product, Grouped Product,
//            External - Affiliate Product"" options is visible."
        Select select = new Select(VendorStoreManagerPage.productType);
        select.selectByIndex(3);
        String externalAffiliateProduct = select.getFirstSelectedOption().getText();
        Assert.assertEquals(externalAffiliateProduct,"External/Affiliate Product");

        select.selectByIndex(2);
        String groupedProduct = select.getFirstSelectedOption().getText();
        Assert.assertEquals(groupedProduct,"Grouped Product");

        select.selectByIndex(1);
        String variableProduct = select.getFirstSelectedOption().getText();
        Assert.assertEquals(variableProduct,"Variable Product");

        select.selectByIndex(0);
        String simpleProduct = select.getFirstSelectedOption().getText();
        Assert.assertEquals(simpleProduct,"Simple Product");



//        11- Click on "image" part
//        12- Click on "Upload files" button
//        13- Click on "SELECT FILES" button and upload the image
//        14- Click on "SELECT" button
//        15- Verify "photo" is uploaded by taking screenshot
//        16- Enter "Product Title"
//        17- Enter "Short Description"
//        18- Enter " Description"
//        19- Verify Product Title, Short Description and Description are entered
//        20- Verify "Categories" options are selectable
//        21- Click on "+Add new category" button
//        22- Enter "Category Name"
//        23- Select "-Parent category-" from dropdown
//        24- Click "ADD" button
//        25- Verify "Scarf" option has added under For Women
//        26- Verify "Product brands" options are selectable.
//        27- Click on "+Add new Product brands"
//        28- Enter "Product brands Name"
//        29- Click "ADD" button
//        30- Verify "Product brands" is added
//        31- Enter "Tags"
//        32- Verify "Catalog visibility" is selectable all options.
//        33-  Click on "DRAFT" button


    }
}
