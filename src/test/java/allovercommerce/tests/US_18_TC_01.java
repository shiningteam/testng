package allovercommerce.tests;

import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorRegisterPage;
import allovercommerce.pages.vendorpages.VendorStoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_18_TC_01 {

    @Test
    public void externalAffiliateOption() throws IOException {

        VendorHomePage vendorHomePage=new VendorHomePage();
        VendorRegisterPage vendorRegisterPage=new VendorRegisterPage();
        VendorStoreManagerPage vendorStoreManagerPage=new VendorStoreManagerPage();
        Faker faker=new Faker();

        // The user goes to ''https://allovercommerce.com/''
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // Click "Sign in" button
        vendorHomePage.vendorSignInIcon.click();

        ReusableMethods.waitFor(2);

        //Enter username or email address
        vendorRegisterPage.vendorSignInUsernameInput.sendKeys(ConfigReader.getProperty("vendor_username"));

       //Enter password
        vendorRegisterPage.vendorSignInPasswordInput.sendKeys(ConfigReader.getProperty("vendor_password"));

        // Click the "sign in" button
        vendorRegisterPage.vendorSignInButton.click();

        ReusableMethods.waitFor(3);

        //Click the Sign Out button and go to my Account
        vendorHomePage.signOutIcon.click();

        // Click the "Store Manager" button
        vendorHomePage.storeManagerIcon.click();

        ReusableMethods.waitFor(2);

        //Click the "Products" button
        vendorStoreManagerPage.productsIcon.click();

        ReusableMethods.waitFor(2);

        // Click the "Add New" button
        vendorStoreManagerPage.addNewIcon.click();

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

        //These values should be able to entered in the boxs
        ReusableMethods.getScreenshot();
}
}