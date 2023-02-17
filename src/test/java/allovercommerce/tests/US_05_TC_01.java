package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerMyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_05_TC_01 {
    CustomerHomePage customerHomePage = new CustomerHomePage();
    CustomerMyAccountPage customerMyAccountPage = new CustomerMyAccountPage();
    @BeforeMethod
    public void signUp(){
        Faker faker=new Faker();
        String fakeUsername = faker.name().username();
        String fakeEmailAddress = faker.internet().emailAddress();
//        1- The user goes to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//        2- Click on the Register icon
        customerHomePage=new CustomerHomePage();
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(customerHomePage.customerRegisterIcon);
//        3- Enter "Username"
        ReusableMethods.waitFor(5);
        customerHomePage.registerUsername.sendKeys(fakeUsername);
//        4- Enter "Your Email address"
        ReusableMethods.waitFor(5);
        customerHomePage.registerEmail.sendKeys(fakeEmailAddress);
//        5- Enter "Password"
        ReusableMethods.waitFor(5);
        customerHomePage.registerPassword.sendKeys(ConfigReader.getProperty("customer_password"));
//        6- Select "I agree to the privacy policy" checkbox
        ReusableMethods.waitFor(5);
        customerHomePage.agreeCheckbox.click();
//        7- Click on "SIGN UP" button
        ReusableMethods.waitFor(3);
        customerHomePage.signUpButton.click();
        ReusableMethods.waitFor(10);
//        8- Click on the "My Account" at the bottom of the home page
        JSUtils.scrollDownByJS();
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(customerHomePage.myAccountButton);
    }
    @Test
    public void TC_01_editAccountDetailsTest(){
        Faker faker=new Faker();
//        9- Click on "Account details"
        customerMyAccountPage.accountDetails.click();
        ReusableMethods.waitFor(3);
//        10- Verify "Account Details" page be seen
        Assert.assertTrue(customerMyAccountPage.accountDetailsText.isDisplayed());
        ReusableMethods.waitFor(3);
//        8- Edit firstname, lastname, displayname, emailadress
        customerMyAccountPage.firstName.sendKeys(ConfigReader.getProperty("customer_firstname"));
        ReusableMethods.waitFor(3);
        customerMyAccountPage.lastName.sendKeys(ConfigReader.getProperty("customer_lastname"));
        ReusableMethods.waitFor(3);
        customerMyAccountPage.emailAddress.clear();
        String fakeEditEmailAddress = faker.internet().emailAddress();
        customerMyAccountPage.emailAddress.sendKeys(fakeEditEmailAddress);
        ReusableMethods.waitFor(3);
//        9- Fill in the Biography section.
        Driver.getDriver().switchTo().frame(customerMyAccountPage.iframe);
        ReusableMethods.waitFor(3);
        customerMyAccountPage.biography.sendKeys("Less is more");
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.waitFor(3);
//        10- Change the password
        customerMyAccountPage.currentPassword.sendKeys(ConfigReader.getProperty("customer_password"));
        ReusableMethods.waitFor(3);
        customerMyAccountPage.password1.sendKeys(ConfigReader.getProperty("customer_edit_password"));
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(customerMyAccountPage.password2);
        customerMyAccountPage.password2.sendKeys(ConfigReader.getProperty("customer_edit_password"));
        ReusableMethods.waitFor(3);
//        11- Click the "save changes" button
        JSUtils.scrollIntoViewJS(customerMyAccountPage.currentPassword);
        JSUtils.clickElementByJS(customerMyAccountPage.saveChanges);
//        12- Verify appears "Account details changed successfully."
        Assert.assertTrue(customerMyAccountPage.accountDetailsSaved.isDisplayed());
    }
    @Test
    public void TC_02_editNameTest() {
//        9- Click on "Account details"
        JSUtils.clickElementByJS(customerMyAccountPage.accountDetails);
        ReusableMethods.waitFor(3);
//        10- Verify "Account Details" page be seen
        Assert.assertTrue(customerMyAccountPage.accountDetailsText.isDisplayed());
        ReusableMethods.waitFor(3);
//        8- Edit firstname and lastname with invalid value
        customerMyAccountPage.firstName.sendKeys(ConfigReader.getProperty("customer_invalid_firstname"));
        customerMyAccountPage.lastName.sendKeys(ConfigReader.getProperty("customer_invalid_lastname"));
        ReusableMethods.waitFor(3);
//        11- Click the "save changes" button
        JSUtils.scrollIntoViewJS(customerMyAccountPage.currentPassword);
        JSUtils.clickElementByJS(customerMyAccountPage.saveChanges);
//        12- Verify appears "Account details changed successfully."
//        ------BUGGGG----TEST SHOULD NOT PASS, BUT IT PASSED.
        Assert.assertTrue(customerMyAccountPage.accountDetailsSaved.isDisplayed());
    }
    @Test
    public void TC_03_editDisplayNameTest() {
//        9- Click on "Account details"
        customerMyAccountPage.accountDetails.click();
        ReusableMethods.waitFor(3);
//        10- Verify "Account Details" page be seen
        Assert.assertTrue(customerMyAccountPage.accountDetailsText.isDisplayed());
        ReusableMethods.waitFor(3);
//        8- Edit firstname, lastname, displayname, emailadress
        customerMyAccountPage.firstName.sendKeys(ConfigReader.getProperty("customer_firstname"));
        ReusableMethods.waitFor(3);
        customerMyAccountPage.lastName.sendKeys(ConfigReader.getProperty("customer_lastname"));
        ReusableMethods.waitFor(3);
//        8- Edit "Display name" with invalid value
        customerMyAccountPage.displayName.clear();
        customerMyAccountPage.displayName.sendKeys(ConfigReader.getProperty("customer_invalid_username"));
        ReusableMethods.waitFor(3);
//        11- Click the "save changes" button
        JSUtils.scrollIntoViewJS(customerMyAccountPage.currentPassword);
        JSUtils.clickElementByJS(customerMyAccountPage.saveChanges);
//        12- Verify appears "Account details changed successfully."
//        ------BUGGGG
        Assert.assertTrue(customerMyAccountPage.accountDetailsSaved.isDisplayed());
    }
    @Test
    public void TC_04_editEmailTest() {
//        9- Click on "Account details"
        customerMyAccountPage.accountDetails.click();
        ReusableMethods.waitFor(1);
//        10- Verify "Account Details" page be seen
        Assert.assertTrue(customerMyAccountPage.accountDetailsText.isDisplayed());
        ReusableMethods.waitFor(1);
//        8- Edit firstname, lastname, displayname, emailadress
        customerMyAccountPage.firstName.sendKeys(ConfigReader.getProperty("customer_firstname"));
        ReusableMethods.waitFor(1);
        customerMyAccountPage.lastName.sendKeys(ConfigReader.getProperty("customer_lastname"));
        ReusableMethods.waitFor(1);
//        8- Edit "Email Address"  with invalid value
        customerMyAccountPage.emailAddress.clear();
        customerMyAccountPage.emailAddress.sendKeys(ConfigReader.getProperty("customer_invalid_email"));
        ReusableMethods.waitFor(1);
//        11- Click the "save changes" button
        JSUtils.scrollIntoViewJS(customerMyAccountPage.currentPassword);
        JSUtils.clickElementByJS(customerMyAccountPage.saveChanges);
    }
    @Test
    public void TC_05_passwordTest(){
//        9- Click on "Account details"
        customerMyAccountPage.accountDetails.click();
        ReusableMethods.waitFor(3);
//        10- Verify "Account Details" page be seen
        Assert.assertTrue(customerMyAccountPage.accountDetailsText.isDisplayed());
        ReusableMethods.waitFor(3);
//        8- Edit firstname, lastname, displayname, emailadress
        customerMyAccountPage.firstName.sendKeys(ConfigReader.getProperty("customer_firstname"));
        ReusableMethods.waitFor(3);
        customerMyAccountPage.lastName.sendKeys(ConfigReader.getProperty("customer_lastname"));
        ReusableMethods.waitFor(3);
//        10- Change the password by not confirm
        customerMyAccountPage.currentPassword.sendKeys(ConfigReader.getProperty("customer_password"));
        ReusableMethods.waitFor(3);
        customerMyAccountPage.password1.sendKeys(ConfigReader.getProperty("customer_edit_password"));
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(customerMyAccountPage.password2);
        customerMyAccountPage.password2.sendKeys(ConfigReader.getProperty("customer_edit_password2"));
        ReusableMethods.waitFor(3);
//        11- Click the "save changes" button
        JSUtils.scrollIntoViewJS(customerMyAccountPage.currentPassword);
        JSUtils.clickElementByJS(customerMyAccountPage.saveChanges);
//        21- Verify password not change
        Assert.assertTrue(customerMyAccountPage.noMatch.isDisplayed());
    }

//    @AfterMethod
//    public void closeBrowser(){
//        ReusableMethods.waitFor(3);
//        Driver.closeDriver();
//    }
}
