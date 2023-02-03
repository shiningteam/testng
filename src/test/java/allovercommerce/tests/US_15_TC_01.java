package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerMyAccountPage;
import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorInventoryPage;
import allovercommerce.pages.vendorpages.VendorProductsPage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v107.indexeddb.model.Key;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static allovercommerce.utilities.JSUtils.clickElementByJS;
import static allovercommerce.utilities.JSUtils.scrollIntoViewJS;


public class US_15_TC_01 {

    VendorInventoryPage VendorInventoryPage = new VendorInventoryPage();
    VendorHomePage VendorHomePage = new VendorHomePage();
    VendorStoreManagerPage VendorStoreManagerPage = new VendorStoreManagerPage();

       @BeforeMethod
        public void shippingAddressPage() {

//        User goes to https://allovercommerce.com/
           Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
           ReusableMethods.waitFor(3);

//        Clicks on the sign in button as a vendor(Registered before as a vendor and username and
//        passwordwill be remembered due to ""remember me"" button function)"
           VendorHomePage.vendorSignInIcon.click();
           ReusableMethods.waitFor(3);

//    JSUtils.VendorHomePage.username;
           VendorHomePage.username.sendKeys(ConfigReader.getProperty("vendor_username"));
//     VendorHomePage.username.sendKeys("shiningteamvendor");
//       JSUtils.(VendorHomePage.password);
           VendorHomePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
//        VendorHomePage.password.sendKeys("1S9h2T8e5A3m*");
           VendorHomePage.VendorSignInButton.click();
           ReusableMethods.waitFor(5);
//        Clicks on the "My Account" button
           JSUtils.scrollDownByJS();
           clickElementByJS(VendorHomePage.myAccountButton);
           ReusableMethods.waitFor(5);
//        Clicks on the "Store Manager" button
           VendorStoreManagerPage.StoreManagerButton.click();
           ReusableMethods.waitFor(3);
//        Clicks on the " Product " button
           clickElementByJS(VendorStoreManagerPage.ProductsButton);
           ReusableMethods.waitFor(3);
//        Clicks on the " Add New" button
           VendorStoreManagerPage.addNewIcon.click();
           ReusableMethods.waitFor(3);
//          Vendor enters a new product title
           VendorStoreManagerPage.ProductTitle.sendKeys("Table");
//        Vendor clicks draft button
           scrollIntoViewJS(VendorStoreManagerPage.DraftButton);
           clickElementByJS(VendorStoreManagerPage.DraftButton);

//  Verifies that Inventory, Shipping, Attributes, Linked, Seo, Wholesale product display settings,Advanced menus are visible.
           //Scroll up the page
           scrollIntoViewJS(VendorInventoryPage.InventoryButton);
           ReusableMethods.waitFor(3);
           Assert.assertTrue(VendorInventoryPage.LinkedButton.isEnabled());
           ReusableMethods.waitFor(3);
       }

    @Test
    public void TC_01_InventoryTest() {
 //      9-As a vendor fills in the SKU, Manage Stock, Stock status, Sold Individually fields with valid data
        clickElementByJS(VendorInventoryPage.InventoryButton);
        VendorInventoryPage.InventorySKU.sendKeys("---");
        Select select1 = new Select(VendorInventoryPage.StockStatusOptions);
        select1.selectByVisibleText("In stock");
        clickElementByJS(VendorInventoryPage.ManageStockBox);
        VendorInventoryPage.StockQty.sendKeys("-0");
        Select select2 = new Select(VendorInventoryPage.AllowBackordersOptions);
        select2.selectByVisibleText("Allow");
        VendorInventoryPage.SoldIndividuallyCheckBox.click();
    }

    @Test
    public void TC_02_NegativInventoryTest() throws IOException {
//   As a vendor fills in the SKU, Manage Stock, Stock status, Sold Individually  fields with invalid data
        clickElementByJS(VendorInventoryPage.InventoryButton);
        VendorInventoryPage.InventorySKU.sendKeys("W23");
        Select select1 = new Select(VendorInventoryPage.StockStatusOptions);
        select1.selectByVisibleText("In stock");
        clickElementByJS(VendorInventoryPage.ManageStockBox);
        VendorInventoryPage.StockQty.sendKeys("36");
        Select select2 = new Select(VendorInventoryPage.AllowBackordersOptions);
        select2.selectByVisibleText("Allow");
        VendorInventoryPage.SoldIndividuallyCheckBox.click();
        ReusableMethods.getScreenshot();
    }

        @Test
        public void TC_03_ShippinProcessTest() {
//       Click on the "Shipping" button
        VendorInventoryPage.ShippingButton.click();
//      As a vendor fills in the Weight, Dimensions, Shipping class, Processing Time fields with valid data
         VendorInventoryPage.ProductWeight.sendKeys("12");
         VendorInventoryPage.ProductLength.sendKeys("30");
         VendorInventoryPage.ProductWeight.sendKeys("15");
         VendorInventoryPage.ProductHeight.sendKeys("10");
        Select select3 = new Select(VendorInventoryPage.ShippingClassOptions);
//        select3.selectByVisibleText("No Shipping Class");
        Select select4 = new Select(VendorInventoryPage.ProcessingTimeOptions);
        select4.selectByVisibleText("1-2 weeks");

        }

    @Test
    public void TC_04_NegativeShippinProcessTest() throws IOException {
//       Click on the "Shipping" button
        VendorInventoryPage.ShippingButton.click();
//      As a vendor fills in the Weight, Dimensions, Shipping class, Processing Time fields with invalid data
        VendorInventoryPage.ProductWeight.sendKeys("-12");
        VendorInventoryPage.ProductLength.sendKeys("**30");
        VendorInventoryPage.ProductWidth.sendKeys("**15");
        VendorInventoryPage.ProductHeight.sendKeys("-10");
        Select select3 = new Select(VendorInventoryPage.ShippingClassOptions);
//        select3.selectByVisibleText("No Shipping Class");
        Select select4 = new Select(VendorInventoryPage.ProcessingTimeOptions);
        select4.selectByVisibleText("1-2 weeks");
        ReusableMethods.getScreenshot();
    }

    @Test
    public void TC_05_AttributesTest() {
//      Click on the "Attributes" button
        clickElementByJS(VendorInventoryPage.AttributesButton);

//      As a vendor fills in the Color and Size fields
//       clickElementByJS(VendorInventoryPage.ColarAttributesVisibleCheckBox);
       ReusableMethods.waitFor(5);
//        VendorInventoryPage.Colar0ptions.sendKeys("Black");

      Select select5 = new Select(VendorInventoryPage.Colar0ptions);
        ReusableMethods.waitFor(5);
      select5.selectByValue("570");
     clickElementByJS(VendorInventoryPage.SizeAttributesVisibleCheckBox);
     Select select6 = new Select(VendorInventoryPage.Size0ptions);
     select6.selectByVisibleText("Large");
    }

    @Test
    public void TC_04_LinkedTest() {


//        14-Click on the "Linked" button
        clickElementByJS(VendorInventoryPage.LinkedButton);

//       15-As a vendor fills in theUp-sells, Cross-sells fields
    }

    @Test
    public void TC_06_SEOTest() {

 // Click on the "Seo" button
    clickElementByJS(VendorInventoryPage.SEOButton);
//  As a vendor fills in the Enter a focus keyword, Meta description fields with valid data
        VendorInventoryPage.SEOFocusKeyWord.sendKeys("Konfor");
        VendorInventoryPage.SEOMetaDescribtion.sendKeys("Güven ve konfor sağlar");
    }

    @Test
    public void TC_07_NegatifSEOTest() throws IOException {

        // Click on the "Seo" button
        clickElementByJS(VendorInventoryPage.SEOButton);
//  As a vendor fills in the Enter a focus keyword, Meta description fields with invalid data
        VendorInventoryPage.SEOFocusKeyWord.sendKeys("////");
        VendorInventoryPage.SEOMetaDescribtion.sendKeys("-1234");
        ReusableMethods.getScreenshot();
    }

    @Test
    public void TC_08_WholesaleProductdisplaySettingTest() {

 // Click on the "Wholesale Product display settings" button
    VendorInventoryPage.ToptanUrunGostermeAyarlariButton.click();
//  As a vendor fills in the Piece Type, Units Per Piece, Min Order Quantity fields with valid data
        Select select7 = new Select(VendorInventoryPage.PieceTypeOptions);
        select7.selectByVisibleText("Kg");
        VendorInventoryPage.UnitPerType.sendKeys("3");
        VendorInventoryPage.MinOrderQty.sendKeys("15");
        Select select8 = new Select(VendorInventoryPage.PieceTypeOptions);
        select8.selectByVisibleText("Carton");
        VendorInventoryPage.UnitPerType.sendKeys("3");
        VendorInventoryPage.MinOrderQty.sendKeys("15");
        Select select9 = new Select(VendorInventoryPage.PieceTypeOptions);
        select9.selectByVisibleText("Piece");
        VendorInventoryPage.UnitPerType.sendKeys("3");
        VendorInventoryPage.MinOrderQty.sendKeys("15");
    }

    @Test
    public void TC_09_NegatifWholesaleProductdisplaySettingTest() throws IOException {

        // Click on the "Wholesale Product display settings" button
        VendorInventoryPage.ToptanUrunGostermeAyarlariButton.click();
//  As a vendor fills in the Piece Type, Units Per Piece, Min Order Quantity fields with invalid data
        Select select7 = new Select(VendorInventoryPage.PieceTypeOptions);
        select7.selectByVisibleText("Kg");
        VendorInventoryPage.UnitPerType.sendKeys("-3");
        VendorInventoryPage.MinOrderQty.sendKeys("-15");
        Select select8 = new Select(VendorInventoryPage.PieceTypeOptions);
        select8.selectByVisibleText("Carton");
        VendorInventoryPage.UnitPerType.sendKeys("-0.3");
        VendorInventoryPage.MinOrderQty.sendKeys("-1.5");
        Select select9 = new Select(VendorInventoryPage.PieceTypeOptions);
        select9.selectByVisibleText("Piece");
        VendorInventoryPage.UnitPerType.sendKeys("-0,3");
        VendorInventoryPage.MinOrderQty.sendKeys("-1.5");
        ReusableMethods.getScreenshot();

    }

    @Test
    public void TC_10_AdvancedSettingTest() {

  //      Click on the "Advanced " button
        scrollIntoViewJS(VendorInventoryPage.InventoryButton);
        JSUtils.clickElementByJS(VendorInventoryPage.AdvancedButton);
        ReusableMethods.waitFor(5);

        clickElementByJS(VendorInventoryPage.EnableReviewsCheckBox);
        ReusableMethods.waitFor(5);
//        As a vendor fills in the Menu Order, Purchase Note fields
        VendorInventoryPage.MenuOrder.sendKeys("4");
        VendorInventoryPage.PurchaseNote.sendKeys("10 Table is ready to ship");
    }

    @Test
    public void TC_11_NegatifAdvancedSettingTest() throws IOException {

//      Click on the "Advanced " button
        scrollIntoViewJS(VendorInventoryPage.InventoryButton);
        JSUtils.clickElementByJS(VendorInventoryPage.AdvancedButton);
        ReusableMethods.waitFor(5);

        ReusableMethods.waitFor(5);
//        As a vendor fills in the Menu Order, Purchase Note fields with invalid data without activating review check box

//       clickElementByJS(VendorInventoryPage.EnableReviewsCheckBox);
        VendorInventoryPage.MenuOrder.sendKeys("-4");
        VendorInventoryPage.PurchaseNote.sendKeys("-é00");
        ReusableMethods.getScreenshot();
    }

    @AfterMethod
    public void closeBrowser(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}

    /*
 1-User goes to https:https:https://allovercommerce.com/
 2-Clicks on the sign in button as a vendor(Registered before as a vendor and username and
    passwordwill be remembered due to ""remember me"" button function)"
3-Clicks on the "My Account" button
4-Clicks on the "Store Manager" button
5-Clicks on the " Product " button
6-Clicks on the " Add New" button
7- Verifies that Inventory, Shipping, Attributes, Linked, Seo, Wholesale product display settings,
    Advanced menus are visible."
8-Click on the "Inventory" button
9-As a vendor fills in the SKU, Manage Stock, Stock status, Sold Individually fields
10-Click on the "Shipping" button
11-As a vendor fills in the Weight, Dimensions, Shipping class, Processing Time fields
12-Click on the "Attributes" button
13-As a vendor fills in the Color and Size fields
14-Click on the "Linked" button
15-As a vendor fills in theUp-sells, Cross-sells fields
16-Click on the "Seo" button
17-As a vendor fills in the Enter a focus keyword, Meta description fields
18-Click on the "Wholesale Product display settings" button
19-As a vendor fills in the Piece Type, Units Per Piece, Min Order Quantity fields
20-Click on the "Advanced " button
21-As a vendor fills in the Menu Order, Purchase Note fields
22-As a vendor verifyies that all fields are filled in Steps
*/
