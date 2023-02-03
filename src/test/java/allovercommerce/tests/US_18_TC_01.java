package allovercommerce.tests;

import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorMyAccountPage;
import allovercommerce.pages.vendorpages.VendorRegisterPage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_18_TC_01 {

    VendorHomePage vendorHomePage=new VendorHomePage();
    VendorRegisterPage vendorRegisterPage=new VendorRegisterPage();
    VendorStoreManagerPage vendorStoreManagerPage=new VendorStoreManagerPage();
    VendorMyAccountPage vendorMyAccountPage=new VendorMyAccountPage();
    Faker faker=new Faker();
    Actions actions=new Actions(Driver.getDriver());

    @BeforeMethod
    public void externalAffiliateOption() throws IOException {
        // The user goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
    }
    @Test
    public void TC_01_Test01() throws IOException {

        // Click "Sign in" button
        vendorHomePage.vendorSignInIcon.click();
        ReusableMethods.waitFor(2);

        //Enter username or email address
        vendorRegisterPage.vendorSignInUsernameInput.sendKeys(ConfigReader.getProperty("vendor_username"));

        //Enter password
        vendorRegisterPage.vendorSignInPasswordInput.sendKeys(ConfigReader.getProperty("vendor_password"));

        // Click the "sign in" button
        vendorRegisterPage.vendorSignInButton.click();

        //Click the my account button and go to my Account
        JSUtils.clickElementByJS(vendorHomePage.myAcountIcon);

        // Click the "Store Manager" button
        JSUtils.clickElementByJS(vendorMyAccountPage.storeManagerIcon);

        //Click the "Products" button
        JSUtils.clickElementByJS(vendorStoreManagerPage.productsIcon);

        // Click the "Add New" button
        JSUtils.clickElementByJS(vendorStoreManagerPage.addNewIcon);
        ReusableMethods.waitFor(2);

        //Click the "Simple Product" dropbox
        Select select=new Select(vendorStoreManagerPage.simpleProductDropdown);

        //Verify Simple Product dropbox is selectable
        Assert.assertTrue(vendorStoreManagerPage.simpleProductDropdown.isEnabled());
        ReusableMethods.getScreenshot();

        //Choose "External/Affiliate Product" option
        select.selectByVisibleText("External/Affiliate Product");
        ReusableMethods.waitFor(2);

        //Verify External/Affiliate Product option is selectable"
        Assert.assertTrue(vendorStoreManagerPage.simpleProductDropdown.isEnabled());
        ReusableMethods.getScreenshot();

        //Click the "URL" box
        vendorStoreManagerPage.urlBox.click();

       //Enter the URL value
        vendorStoreManagerPage.urlBox.sendKeys(faker.internet().url());

        //Click the "Button Text" box
        vendorStoreManagerPage.buttonTextBox.click();

        //Enter the Button Text value
        vendorStoreManagerPage.buttonTextBox.sendKeys(faker.company().buzzword());

        //Click the "Price" box
        vendorStoreManagerPage.priceBox.click();

        //Enter the Price value
        vendorStoreManagerPage.priceBox.sendKeys(faker.number().digits(3));

        //Click the "Sale Price" box
        vendorStoreManagerPage.salePriceBox.click();

        //Enter the Sale Price value
        vendorStoreManagerPage.salePriceBox.sendKeys(faker.number().digits(2));
        ReusableMethods.waitFor(2);

        //These values should be able to entered in the boxs
        ReusableMethods.getScreenshot();

    }

    @Test
    public void TC_01_Test02() throws IOException {
        // The user goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(3);

        //Click the My Account button and go to my account
        JSUtils.clickElementByJS(vendorHomePage.myAcountIcon);

        // Click the "Store Manager" button
        JSUtils.clickElementByJS(vendorMyAccountPage.storeManagerIcon);

        //Click the "Products" button
        JSUtils.clickElementByJS(vendorStoreManagerPage.productsIcon);

        // Click the "Add New" button
        JSUtils.clickElementByJS(vendorStoreManagerPage.addNewIcon);
        ReusableMethods.waitFor(2);

        //Click the "Simple Product" dropbox
        Select select=new Select(vendorStoreManagerPage.simpleProductDropdown);

        //Verify Simple Product dropbox is selectable
        Assert.assertTrue(vendorStoreManagerPage.simpleProductDropdown.isEnabled());
        ReusableMethods.getScreenshot();

        //Choose "External/Affiliate Product" option
        select.selectByVisibleText("External/Affiliate Product");
        ReusableMethods.waitFor(2);

        //Verify External/Affiliate Product option is selectable"
        Assert.assertTrue(vendorStoreManagerPage.simpleProductDropdown.isEnabled());
        ReusableMethods.getScreenshot();

        //Click the "URL" box
        vendorStoreManagerPage.urlBox.click();

        //Enter the URL value consisting of numbers
        vendorStoreManagerPage.urlBox.sendKeys(faker.number().digits(5));

        //Click the "Button Text" box
        vendorStoreManagerPage.buttonTextBox.click();

        //Enter the Button Text value
        vendorStoreManagerPage.buttonTextBox.sendKeys(faker.company().buzzword());

        //Click the "Price" box
        vendorStoreManagerPage.priceBox.click();

        //Enter the Price value
        vendorStoreManagerPage.priceBox.sendKeys(faker.number().digits(3));

        //Click the "Sale Price" box
        vendorStoreManagerPage.salePriceBox.click();

        //Enter the Sale Price value
        vendorStoreManagerPage.salePriceBox.sendKeys(faker.number().digits(2));
        ReusableMethods.waitFor(2);

        //These values should be able to entered in the boxs
        ReusableMethods.getScreenshot();

        //When click the Summit button there is no warning about url
        JSUtils.clickElementByJS(vendorStoreManagerPage.submitButton);
        ReusableMethods.waitFor(2);

        Assert.assertFalse(vendorStoreManagerPage.warningBox.getText().contains("url"));
        ReusableMethods.getScreenshot();
    }

    @Test
    public void TC_01_Test03() throws IOException {
        // The user goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(3);

        //Click the My Account button and go to my account
        JSUtils.clickElementByJS(vendorHomePage.myAcountIcon);
        ReusableMethods.waitFor(2);

        // Click the "Store Manager" button
        JSUtils.clickElementByJS(vendorMyAccountPage.storeManagerIcon);

        //Click the "Products" button
        JSUtils.clickElementByJS(vendorStoreManagerPage.productsIcon);

        // Click the "Add New" button
        JSUtils.clickElementByJS(vendorStoreManagerPage.addNewIcon);
        ReusableMethods.waitFor(2);

        //Click the "Simple Product" dropbox
        Select select=new Select(vendorStoreManagerPage.simpleProductDropdown);

        //Verify Simple Product dropbox is selectable
        Assert.assertTrue(vendorStoreManagerPage.simpleProductDropdown.isEnabled());
        ReusableMethods.getScreenshot();

        //Choose "External/Affiliate Product" option
        select.selectByVisibleText("External/Affiliate Product");
        ReusableMethods.waitFor(2);

        //Verify External/Affiliate Product option is selectable"
        Assert.assertTrue(vendorStoreManagerPage.simpleProductDropdown.isEnabled());
        ReusableMethods.getScreenshot();

        //Click the "URL" box
        vendorStoreManagerPage.urlBox.click();

        //Enter the URL value
        vendorStoreManagerPage.urlBox.sendKeys(faker.internet().url());

        //Click the "Button Text" box
        vendorStoreManagerPage.buttonTextBox.click();

        //Enter the Button Text value
        vendorStoreManagerPage.buttonTextBox.sendKeys(faker.company().buzzword());

        //Click the "Price" box
        vendorStoreManagerPage.priceBox.click();

        //Enter the negative Price value
        vendorStoreManagerPage.priceBox.sendKeys("-50");

        //Click the "Sale Price" box
        vendorStoreManagerPage.salePriceBox.click();

        //Enter the negative Sale Price value
        vendorStoreManagerPage.salePriceBox.sendKeys("-30");

        //Verify negative Price and Sale Price values should be able to entered as positive in the boxs
        ReusableMethods.getScreenshot();
    }
    @AfterMethod
    public void closeBrowser(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}