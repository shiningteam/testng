package allovercommerce.tests;

import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static allovercommerce.utilities.JSUtils.clickElementByJS;
import static allovercommerce.utilities.JSUtils.scrollIntoViewJS;

public class US_14_TC_01 {
    VendorHomePage VendorHomePage = new VendorHomePage();
    VendorStoreManagerPage VendorStoreManagerPage = new VendorStoreManagerPage();
    Faker faker = new Faker();
    @BeforeMethod
    public void signIn() {
        //        1- User goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(3);
//        2- Click "Sign in" button
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
        ReusableMethods.waitFor(5);
        clickElementByJS(VendorHomePage.myAccountButton);
        ReusableMethods.waitFor(5);
//        7- Click on "Store Manager" button
        VendorStoreManagerPage.StoreManagerButton.click();
        ReusableMethods.waitFor(3);
//        8- Click on "Products" button
        clickElementByJS(VendorStoreManagerPage.ProductsButton);
        ReusableMethods.waitFor(3);
//        9- Click on "Add New" button
        VendorStoreManagerPage.AddNewButton.click();
        ReusableMethods.waitFor(3);
        scrollIntoViewJS(VendorStoreManagerPage.addProductText);
    }
    @Test
    public void optionsTest() {
//        10- Verify ""Simple Product, Variable Product, Grouped Product,External - Affiliate Product"" options is visible."
        System.out.println(ReusableMethods.getElementsText(VendorStoreManagerPage.productTypeOptions));
        List<String> productTypeOptions = new ArrayList<>(ReusableMethods.getElementsText(VendorStoreManagerPage.productTypeOptions));

        Assert.assertTrue(productTypeOptions.contains("Simple Product"));
        Assert.assertTrue(productTypeOptions.contains("Variable Product"));
        Assert.assertTrue(productTypeOptions.contains("Grouped Product"));
        Assert.assertTrue(productTypeOptions.contains("External/Affiliate Product"));
//        Select select = new Select(VendorStoreManagerPage.productType);
//        select.selectByIndex(3);
//        String externalAffiliateProduct = select.getFirstSelectedOption().getText();
//        Assert.assertEquals(externalAffiliateProduct, "External/Affiliate Product");
//        ReusableMethods.waitFor(3);
//
//
//        select.selectByIndex(2);
//        String groupedProduct = select.getFirstSelectedOption().getText();
//        Assert.assertEquals(groupedProduct, "Grouped Product");
//        ReusableMethods.waitFor(3);
//
//        select.selectByIndex(1);
//        String variableProduct = select.getFirstSelectedOption().getText();
//        Assert.assertEquals(variableProduct, "Variable Product");
//        ReusableMethods.waitFor(3);
//
//        select.selectByIndex(0);
//        String simpleProduct = select.getFirstSelectedOption().getText();
//        Assert.assertEquals(simpleProduct, "Simple Product");
//        ReusableMethods.waitFor(3);
    }
    @Test
    public void imageTest() throws IOException {
//        11- Click on "image" part
        JSUtils.clickElementByJS(VendorStoreManagerPage.imageButton);
        ReusableMethods.waitFor(3);
//        12- Click on "Upload files" button
        JSUtils.clickElementByJS(VendorStoreManagerPage.upload);
        ReusableMethods.waitFor(3);
//        13- Click on "SELECT FILES" button and upload the image
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "\\Desktop\\image.jpeg";
//        JSUtils.clickElementByJS(VendorStoreManagerPage.selectFiles);
        VendorStoreManagerPage.selectFiles.sendKeys(pathOfFile);
        ReusableMethods.waitFor(10);
//        14- Click on "SELECT" button
        JSUtils.clickElementByJS(VendorStoreManagerPage.select);
        ReusableMethods.waitFor(3);
//        15- Verify "photo" is uploaded by taking screenshot
//        URL url = new URL(ConfigReader.getProperty("imageUrl"));
//        InputStream is = url.openStream();
//        FileOutputStream fos = new FileOutputStream(ConfigReader.getProperty("localpath"));
//        byte[] buffer = new byte[4096];
//        int bytesRead = 0;
//        while ((bytesRead = is.read(buffer)) != -1) {
//            fos.write(buffer, 0, bytesRead);
    }
    @Test
    public void descriptionTest() {
//        16- Enter "Product Title"
        VendorStoreManagerPage.productTitle.sendKeys("Eyüp Sabri Tuncer");
        ReusableMethods.waitFor(3);

//        17- Enter "Short Description"
        Driver.getDriver().switchTo().frame(VendorStoreManagerPage.shortDescriptionFrame);
        VendorStoreManagerPage.description.sendKeys(ConfigReader.getProperty("short_description"));
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();

//        18- Enter " Description"
        Driver.getDriver().switchTo().frame(VendorStoreManagerPage.descriptionFrame);
        ReusableMethods.waitFor(3);
        VendorStoreManagerPage.description.sendKeys(ConfigReader.getProperty("description"));
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.waitFor(3);
    }

    @Test
    public void categoryTest() {
//        20- Verify "Categories" options are selectable
        scrollIntoViewJS(VendorStoreManagerPage.shortDescriptionText);
        clickElementByJS(VendorStoreManagerPage.checkboxCategory);
        Assert.assertTrue(VendorStoreManagerPage.checkboxCategory.isSelected());
        ReusableMethods.waitFor(3);
//        21- Click on "+Add new category" button
        clickElementByJS(VendorStoreManagerPage.addNewCategory);
        ReusableMethods.waitFor(3);
//        22- Enter "Category Name"
        VendorStoreManagerPage.categoryName.sendKeys(faker.name().firstName());
        ReusableMethods.waitFor(3);
//        23- Select "-Parent category-" from dropdown
        Select select1 = new Select(VendorStoreManagerPage.categoryParentName);
        select1.selectByIndex(3);
        ReusableMethods.waitFor(3);
//        24- Click "ADD" button
        clickElementByJS(VendorStoreManagerPage.addCategoryButton);
        ReusableMethods.waitFor(3);
//        25- Verify "Scarf" option has added
        List<WebElement> categoryList = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']//li"));
        List<String> categoryNameList = new ArrayList<>();
        for (WebElement w : categoryList) {
            categoryNameList.add(w.getText());
        }
        System.out.println(categoryNameList);
//        Assert.assertTrue(categoryNameList.contains(faker.name().firstName()));
        ReusableMethods.waitFor(3);
    }

    @Test
    public void productTest() {
//        26- Verify "Product brands" options are selectable.
        scrollIntoViewJS(VendorStoreManagerPage.shortDescriptionText);
        clickElementByJS(VendorStoreManagerPage.checkboxBrand);
        ReusableMethods.waitFor(3);
//            Assert.assertTrue(VendorStoreManagerPage.checkboxBrand.isSelected());
//        27- Click on "+Add new Product brands"
        clickElementByJS(VendorStoreManagerPage.addBrandName);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(VendorStoreManagerPage.checkboxBrand.isSelected());
//        28- Enter "Product brands Name"
        VendorStoreManagerPage.brandName.sendKeys(faker.company().name());
        ReusableMethods.waitFor(3);
//        23- Select "-Parent category-" from dropdown
        Select select2 = new Select(VendorStoreManagerPage.brandParentName);
        select2.selectByIndex(1);
        ReusableMethods.waitFor(3);
//        29- Click "ADD" button
        clickElementByJS(VendorStoreManagerPage.addBrandButton);
        ReusableMethods.waitFor(3);
//        30- Verify "Product brands" is added
        Assert.assertTrue(VendorStoreManagerPage.checkboxBrand.isSelected());
    }

    @Test
    public void tagsTest() {
//        31- Enter "Tags"
        scrollIntoViewJS(VendorStoreManagerPage.tagText);
        VendorStoreManagerPage.tagName.sendKeys("#women");
        ReusableMethods.waitFor(3);
    }

    @Test
    public void catalogVisibility() {
//       32- Verify "Catalog visibility" is selectable all options.
        scrollIntoViewJS(VendorStoreManagerPage.tagText);
        ReusableMethods.waitFor(3);

            Select select3 = new Select(VendorStoreManagerPage.catalogOptions);
            select3.selectByIndex(0);
            String shopAndSearchResults = select3.getFirstSelectedOption().getText();
            Assert.assertEquals(shopAndSearchResults, "Shop and search results");
            ReusableMethods.waitFor(3);

            select3.selectByIndex(1);
            String shopOnly = select3.getFirstSelectedOption().getText();
            Assert.assertEquals(shopOnly, "Shop only");
            ReusableMethods.waitFor(3);

            select3.selectByIndex(2);
            String searchResultsOnly = select3.getFirstSelectedOption().getText();
            Assert.assertEquals(searchResultsOnly, "Search results only");
            ReusableMethods.waitFor(3);

        select3.selectByIndex(3);
        String hidden = select3.getFirstSelectedOption().getText();
        Assert.assertEquals(hidden, "Hidden");
        ReusableMethods.waitFor(3);
    }
//    @AfterMethod
//    public void closeBrowser(){
//        ReusableMethods.waitFor(3);
//        Driver.closeDriver();
//    }
}
//         20- Verify "Categories" options are selectable
//            VendorStoreManagerPage.checkboxCategory.click();
////        List<WebElement> categoryUnderList = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']//li//span"));
////        for (WebElement w : categoryUnderList) {
////            w.click();
////            }
////        List<WebElement> categoryList = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']//li//input"));
////        System.out.println(categoryList.size());
////        for (WebElement x : categoryList) {
////            x.click();

//        26- Verify "Product brands" options are selectable.
//            List<WebElement> brandUnderList = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']//li//span"));
//            System.out.println(brandUnderList.size());
//            for (WebElement a : brandUnderList) {
//                a.click();
//            }
//            List<WebElement> brandList = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']//li//input"));
//            System.out.println(brandList.size());
//            for (WebElement b : brandList) {
//                b.click();


//        System.out.println(ReusableMethods.getElementsText(VendorStoreManagerPage.catalogVisibility));
//                List<String> catalogVisibilityOptions = new ArrayList<>(ReusableMethods.getElementsText(VendorStoreManagerPage.catalogVisibility));
//        Assert.assertTrue(catalogVisibilityOptions.contains("Shop and search results"));
//        Assert.assertTrue(catalogVisibilityOptions.contains("Shop only"));
//        Assert.assertTrue(catalogVisibilityOptions.contains("Search results only"));
//        Assert.assertTrue(catalogVisibilityOptions.contains("Hidden"));
