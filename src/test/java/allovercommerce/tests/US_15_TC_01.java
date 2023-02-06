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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v107.indexeddb.model.Key;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static allovercommerce.utilities.JSUtils.clickElementByJS;
import static allovercommerce.utilities.JSUtils.scrollIntoViewJS;
import static allovercommerce.utilities.ReusableMethods.verifyElementDisplayed;
import static allovercommerce.utilities.ReusableMethods.waitFor;


public class US_15_TC_01 {

    VendorInventoryPage VendorInventoryPage = new VendorInventoryPage();
    VendorHomePage VendorHomePage = new VendorHomePage();
    VendorStoreManagerPage VendorStoreManagerPage = new VendorStoreManagerPage();
    private WebDriver driver;

 //   @BeforeMethod
        @BeforeClass
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
       }


    @Test
    public void TC_01_VisibilityTest() {

//  Verifies that Inventory, Shipping, Attributes, Linked, Seo, Wholesale product display settings,Advanced menus are visible.
           //Scroll up the page
           scrollIntoViewJS(VendorInventoryPage.InventoryButton);
           ReusableMethods.waitFor(1);
           verifyElementDisplayed(VendorInventoryPage.InventoryButton);
           verifyElementDisplayed(VendorInventoryPage.ShippingButton);
           verifyElementDisplayed(VendorInventoryPage.AttributesButton);
           Assert.assertTrue(VendorInventoryPage.LinkedButton.isEnabled());
           verifyElementDisplayed(VendorInventoryPage.SEOButton);
           verifyElementDisplayed(VendorInventoryPage.ToptanUrunGostermeAyarlariButton);
           verifyElementDisplayed(VendorInventoryPage.AdvancedButton);
           ReusableMethods.waitFor(1);
       }

    @Test
    public void TC_02_InventoryTest() {
 //    As a vendor fills in the SKU, Manage Stock, Stock status, Sold Individually fields with valid data
        clickElementByJS(VendorInventoryPage.InventoryButton);
        VendorInventoryPage.InventorySKU.sendKeys("W23");
        Select select1 = new Select(VendorInventoryPage.StockStatusOptions);
        select1.selectByVisibleText("In stock");
        clickElementByJS(VendorInventoryPage.ManageStockBox);
        VendorInventoryPage.StockQty.sendKeys("36");
        Select select2 = new Select(VendorInventoryPage.AllowBackordersOptions);
        select2.selectByVisibleText("Allow");
        clickElementByJS(VendorInventoryPage.SoldIndividuallyCheckBox);
    }

    @Test
    public void TC_03_NegativInventoryTest() throws IOException {
//   As a vendor fills in the SKU, Manage Stock, Stock status, Sold Individually  fields with invalid data
        clickElementByJS(VendorInventoryPage.InventoryButton);
        ReusableMethods.waitFor(1);
        VendorInventoryPage.InventorySKU.clear();
        VendorInventoryPage.InventorySKU.sendKeys("---");
        Select select1 = new Select(VendorInventoryPage.StockStatusOptions);
        select1.selectByVisibleText("In stock");
        ReusableMethods.waitFor(1);
        clickElementByJS(VendorInventoryPage.ManageStockBox);
 //       VendorInventoryPage.StockQty.sendKeys("4");
        Select select2 = new Select(VendorInventoryPage.AllowBackordersOptions);
        select2.selectByVisibleText("Allow");
       clickElementByJS(VendorInventoryPage.SoldIndividuallyCheckBox);
        ReusableMethods.getScreenshot();
    }

        @Test
        public void TC_04_ShippinProcessTest() {
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
    public void TC_05_NegativeShippinProcessTest() throws IOException {
//       Click on the "Shipping" button
        VendorInventoryPage.ShippingButton.click();
//      As a vendor fills in the Weight, Dimensions, Shipping class, Processing Time fields with invalid data
        VendorInventoryPage.ProductWeight.sendKeys("-12");
        VendorInventoryPage.ProductLength.sendKeys("**30");
        VendorInventoryPage.ProductWidth.sendKeys("-15");
        VendorInventoryPage.ProductHeight.sendKeys("-10");
        Select select3 = new Select(VendorInventoryPage.ShippingClassOptions);
//        select3.selectByVisibleText("No Shipping Class");
        Select select4 = new Select(VendorInventoryPage.ProcessingTimeOptions);
        select4.selectByVisibleText("1-2 weeks");
        ReusableMethods.getScreenshot();
    }

    @Test
    public void TC_06_AttributesTest() {
//      Click on the "Attributes" button
        clickElementByJS(VendorInventoryPage.AttributesButton);

//      As a vendor fills in the Color and Size fields
      clickElementByJS(VendorInventoryPage.ColarAttributesVisibleCheckBox);
       ReusableMethods.waitFor(5);
        try {
            Driver.getDriver().switchTo().alert().sendKeys("orange");
        } catch (Exception ignored){

        }

        clickElementByJS(VendorInventoryPage.AttributesSizeActivationCheckBox);

        clickElementByJS(VendorInventoryPage.SizeAttributesVisibleCheckBox);
}



    @Test
    public void TC_07_LinkedTest() {


//        14-Click on the "Linked" button
        clickElementByJS(VendorInventoryPage.LinkedButton);

//       15-As a vendor fills in theUp-sells, Cross-sells fields
    }

    @Test
    public void TC_08_SEOTest() {

 // Click on the "Seo" button
    clickElementByJS(VendorInventoryPage.SEOButton);
//  As a vendor fills in the Enter a focus keyword, Meta description fields with valid data
        VendorInventoryPage.SEOFocusKeyWord.sendKeys("Confort");
        VendorInventoryPage.SEOMetaDescribtion.sendKeys("Security ve confort sağlar");
    }

    @Test
    public void TC_09_NegatifSEOTest() throws IOException {

        // Click on the "Seo" button
        clickElementByJS(VendorInventoryPage.SEOButton);
//  As a vendor fills in the Enter a focus keyword, Meta description fields with invalid data
        VendorInventoryPage.SEOFocusKeyWord.sendKeys("////");
        VendorInventoryPage.SEOMetaDescribtion.clear();
        VendorInventoryPage.SEOMetaDescribtion.sendKeys("-1234");
        ReusableMethods.getScreenshot();
    }

    @Test
    public void TC_10_WholesaleProductdisplaySettingTest() {

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
        VendorInventoryPage.UnitPerType.clear();
        VendorInventoryPage.UnitPerType.sendKeys("3");
        VendorInventoryPage.MinOrderQty.clear();
        VendorInventoryPage.MinOrderQty.sendKeys("15");
    }

    @Test
    public void TC_11_NegatifWholesaleProductdisplaySettingTest() throws IOException {

        // Click on the "Wholesale Product display settings" button
        clickElementByJS(VendorInventoryPage.ToptanUrunGostermeAyarlariButton);
        ReusableMethods.waitFor(2);
//  As a vendor fills in the Piece Type, Units Per Piece, Min Order Quantity fields with invalid data
        Select select7 = new Select(VendorInventoryPage.PieceTypeOptions);
        select7.selectByVisibleText("Kg");
        VendorInventoryPage.UnitPerType.sendKeys("-3");
        VendorInventoryPage.MinOrderQty.sendKeys("-15");
        Select select8 = new Select(VendorInventoryPage.PieceTypeOptions);
        select8.selectByVisibleText("Carton");
        VendorInventoryPage.UnitPerType.clear();
        VendorInventoryPage.UnitPerType.sendKeys("-0.3");
        VendorInventoryPage.MinOrderQty.clear();
        VendorInventoryPage.MinOrderQty.sendKeys("-1.5");
        Select select9 = new Select(VendorInventoryPage.PieceTypeOptions);
        select9.selectByVisibleText("Piece");
        VendorInventoryPage.UnitPerType.sendKeys("-0,3");
        VendorInventoryPage.MinOrderQty.sendKeys("-1.5");
        ReusableMethods.getScreenshot();
    }

    @Test
    public void TC_12_AdvancedSettingTest() {

  //      Click on the "Advanced " button
        scrollIntoViewJS(VendorInventoryPage.InventoryButton);
        JSUtils.clickElementByJS(VendorInventoryPage.AdvancedButton);
        ReusableMethods.waitFor(2);

        clickElementByJS(VendorInventoryPage.EnableReviewsCheckBox);
        ReusableMethods.waitFor(1);
//        As a vendor fills in the Menu Order, Purchase Note fields
        VendorInventoryPage.MenuOrder.clear();
        VendorInventoryPage.MenuOrder.sendKeys("4");
        VendorInventoryPage.PurchaseNote.sendKeys("10 Table is ready to ship");
    }

    @Test
    public void TC_13_NegatifAdvancedSettingTest() throws IOException {

//      Click on the "Advanced " button
        scrollIntoViewJS(VendorInventoryPage.InventoryButton);
        JSUtils.clickElementByJS(VendorInventoryPage.AdvancedButton);
        ReusableMethods.waitFor(2);
//        As a vendor fills in the Menu Order, Purchase Note fields with invalid data without activating review check box

//       clickElementByJS(VendorInventoryPage.EnableReviewsCheckBox);
        VendorInventoryPage.MenuOrder.sendKeys("-4");
        VendorInventoryPage.PurchaseNote.clear();
        VendorInventoryPage.PurchaseNote.sendKeys("-é00");
        ReusableMethods.getScreenshot();
    }

    @AfterClass
    public void closeBrowser(){
        ReusableMethods.waitFor(5);
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
