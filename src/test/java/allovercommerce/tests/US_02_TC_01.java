package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerRegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_02_TC_01 {

    CustomerHomePage customerHomePage=new CustomerHomePage();
    Faker faker=new Faker();
    CustomerRegisterPage customerRegisterPage=new CustomerRegisterPage();

    @Test
    public void registerWithAlreadyRegisteredEmail01() throws IOException {

        //User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //User click register icon
        customerHomePage.customerRegisterIcon.click();

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

        ReusableMethods.getScreenshot();

    }

    @Test
    public void registerWithAlreadyRegisteredEmail02() throws IOException {

        //User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //User click register icon
        customerHomePage.customerRegisterIcon.click();

        //User should enter unregistered username in the Username field
        customerRegisterPage.registerUsernameInput.sendKeys(faker.name().bloodGroup());

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

        ReusableMethods.getScreenshot();

    }

    @Test
    public void registerWithAlreadyRegisteredEmail03() throws IOException {

        //User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //User click register icon
        customerHomePage.customerRegisterIcon.click();

        //User should enter registered username in the Username field
        customerRegisterPage.registerUsernameInput.sendKeys(ConfigReader.getProperty("customer_username"));

        //User should enter registered e-mail address in the Email field
        customerRegisterPage.registerEmailInput.sendKeys(ConfigReader.getProperty("customer_email"));

        //User should enter wrong password in Password field
        customerRegisterPage.registerPasswordInput.sendKeys(faker.number().digits(6));

        //User must click on  "I agree to the privacy policy" checkbox
        customerRegisterPage.registerPolicyCheckbox.click();

        //User should click on Sign Up button
        customerRegisterPage.signUpButton.click();

        //User should get "An account is already registered with your email address." message.
        String actualMessage=customerRegisterPage.alreadyRegisteredMessage.getText();
        String expectedMessage="An account is already registered with your email address.";
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        ReusableMethods.getScreenshot();

    }

    @Test
    public void registerWithAlreadyRegisteredEmail04() throws IOException {

        //User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //User click register icon
        customerHomePage.customerRegisterIcon.click();

        //User should enter registered username in the Username field
        customerRegisterPage.registerUsernameInput.sendKeys(ConfigReader.getProperty("customer_username"));

        //User should enter registered e-mail address in the Email field
        customerRegisterPage.registerEmailInput.sendKeys(faker.internet().emailAddress());

        //User should enter registered password in Password field
        customerRegisterPage.registerPasswordInput.sendKeys(ConfigReader.getProperty("customer_password"));

        //User must click on  "I agree to the privacy policy" checkbox
        customerRegisterPage.registerPolicyCheckbox.click();

        //User should click on Sign Up button
        customerRegisterPage.signUpButton.click();

        //User should get "An account is already registered with your email address." message.
        String actualMessage=customerRegisterPage.alreadyRegisteredMessage.getText();
        String expectedMessage="An account is already registered with that username. Please choose another.";
        Assert.assertEquals(expectedMessage, actualMessage);

        ReusableMethods.getScreenshot();

    }
}
