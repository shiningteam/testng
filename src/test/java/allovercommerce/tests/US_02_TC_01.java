package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerRegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_02_TC_01 {
    CustomerHomePage customerHomePage=new CustomerHomePage();
    Faker faker=new Faker();
    CustomerRegisterPage customerRegisterPage=new CustomerRegisterPage();
    Actions actions=new Actions(Driver.getDriver());
    @BeforeMethod
    public void registerWithAlreadyRegisteredEmail(){
        //User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        ReusableMethods.waitFor(1);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);

        //User click register icon
        JSUtils.clickElementByJS(customerHomePage.customerRegisterIcon);
        ReusableMethods.waitFor(2);
    }
    @Test
    public void TC_01_Test01() throws IOException {

        //User should enter registered username in the Username field
        customerRegisterPage.registerUsernameInput.sendKeys(ConfigReader.getProperty("customer_username"));

        //User should enter registered e-mail address in the Email field
        customerRegisterPage.registerEmailInput.sendKeys(ConfigReader.getProperty("customer_email"));

        //User should enter registered password in Password field
        customerRegisterPage.registerPasswordInput.sendKeys(ConfigReader.getProperty("customer_password"));

        //User must click on  "I agree to the privacy policy" checkbox
        customerRegisterPage.registerPolicyCheckbox.click();

        //User should click on Sign Up button
        customerRegisterPage.signUpButton.click();

        //User should get "An account is already registered with your email address." message.
        String actualMessage=customerRegisterPage.alreadyRegisteredMessage.getText();
        String expectedMessage="An account is already registered with your email address.";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        ReusableMethods.waitFor(2);

        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.getScreenshot();
    }
    @Test
    public void TC_01_Test02() throws IOException {

        //User should enter unregistered username in the Username field
        customerRegisterPage.registerUsernameInput.sendKeys(faker.name().bloodGroup());

        //User should enter registered e-mail address in the Email field
        customerRegisterPage.registerEmailInput.sendKeys(ConfigReader.getProperty("customer_email"));

        //User should enter registered password in Password field
        customerRegisterPage.registerPasswordInput.sendKeys(ConfigReader.getProperty("customer_password"));
        ReusableMethods.waitFor(3);

        //User must click on  "I agree to the privacy policy" checkbox
        customerRegisterPage.registerPolicyCheckbox.click();
        ReusableMethods.waitFor(1);

        //User should click on Sign Up button
        customerRegisterPage.signUpButton.click();

        //User should get "An account is already registered with your email address." message.
        String actualMessage=customerRegisterPage.alreadyRegisteredMessage.getText();
        String expectedMessage="An account is already registered with your email address.";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.getScreenshot();
    }
    @Test
    public void TC_01_Test03() throws IOException {

        //User should enter registered username in the Username field
        customerRegisterPage.registerUsernameInput.sendKeys(ConfigReader.getProperty("customer_username"));
        ReusableMethods.waitFor(1);

        //User should enter registered e-mail address in the Email field
        customerRegisterPage.registerEmailInput.sendKeys(ConfigReader.getProperty("customer_email"));

        //User should enter wrong password in Password field
        customerRegisterPage.registerPasswordInput.sendKeys(faker.number().digits(6));
        ReusableMethods.waitFor(1);

        //User must click on  "I agree to the privacy policy" checkbox
        customerRegisterPage.registerPolicyCheckbox.click();
        ReusableMethods.waitFor(1);

        //User should click on Sign Up button
        customerRegisterPage.signUpButton.click();

        //User should get "An account is already registered with your email address." message.
        String actualMessage=customerRegisterPage.alreadyRegisteredMessage.getText();
        String expectedMessage="An account is already registered with your email address.";
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.getScreenshot();
    }
    @Test
    public void TC_01_Test04() throws IOException {

        //User should enter registered username in the Username field
        customerRegisterPage.registerUsernameInput.sendKeys(ConfigReader.getProperty("customer_username"));

        //User should enter registered e-mail address in the Email field
        customerRegisterPage.registerEmailInput.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(1);

        //User should enter registered password in Password field
        customerRegisterPage.registerPasswordInput.sendKeys(ConfigReader.getProperty("customer_password"));
        ReusableMethods.waitFor(1);

        //User must click on  "I agree to the privacy policy" checkbox
        customerRegisterPage.registerPolicyCheckbox.click();
        ReusableMethods.waitFor(1);

        //User should click on Sign Up button
        customerRegisterPage.signUpButton.click();
        ReusableMethods.waitFor(2);

        //User should get "An account is already registered with your email address." message.
        String actualMessage=customerRegisterPage.alreadyRegisteredMessage.getText();
        String expectedMessage="An account is already registered with that username. Please choose another.";


        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.getScreenshot();
    }
//    @AfterMethod
//    public void closeBrowser(){
//        ReusableMethods.waitFor(5);
//        Driver.closeDriver();
//    }
}
