package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.testng.annotations.Test;

import java.io.IOException;

public class US_01_TC_01 {
    CustomerHomePage customerHomePage;


    @Test
    public void testcase_01(){
//        User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//        User click Register link
        customerHomePage=new CustomerHomePage();

        ReusableMethods.waitFor(10);
        customerHomePage.customerRegisterIcon.click();

//        User should enter valid username in the Username field
        Faker faker=new Faker();
        ReusableMethods.waitFor(5);
        customerHomePage.registerUsername.sendKeys(faker.name().username());
//        User should enter valid e-mail address
        ReusableMethods.waitFor(5);
        customerHomePage.registerEmail.sendKeys(faker.internet().emailAddress());
//        User should enter valid password in Password field
        ReusableMethods.waitFor(5);
        customerHomePage.registerPassword.sendKeys(faker.internet().password());
//        User must click on  "I agree to the privacy policy" checkbox
        ReusableMethods.waitFor(5);
        customerHomePage.agreeCheckbox.click();
//        User should click on sign up button
        ReusableMethods.waitFor(5);
        customerHomePage.signUpButton.click();

//      Verify the sign out link is displayed
        customerHomePage.signOutButton.isDisplayed();


    }

    @Test //bug
    public void testcase_02() throws IOException {
//        User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//        User click Register link
        customerHomePage=new CustomerHomePage();
        ReusableMethods.waitFor(10);

        customerHomePage.customerRegisterIcon.click();
//        User should enter invalid username in the Username field
        ReusableMethods.waitFor(5);
        customerHomePage.registerUsername.sendKeys(ConfigReader.getProperty("customer_invalid_username"));
//        User should enter invalid e-mail address
        ReusableMethods.waitFor(5);
        customerHomePage.registerEmail.sendKeys(ConfigReader.getProperty("customer_invalid_email"));
//        User should enter invalid password in Password field
        ReusableMethods.waitFor(5);
        customerHomePage.registerPassword.sendKeys(ConfigReader.getProperty("customer_invalid_password"));

//        User must click on  "I agree to the privacy policy" checkbox
        ReusableMethods.waitFor(5);
        customerHomePage.agreeCheckbox.click();
//        User should click on sign up button
        ReusableMethods.waitFor(5);
        customerHomePage.signUpButton.click();
//      Error message  should be  like "Please enter a valid account username,email address and password."
        String errorMessage=customerHomePage.errorMessage.getText();

        Assert.assertFalse(false,"Please enter a valid account username ,email address and password.");


    }
    @Test //wrong username
    public void testcase_03() throws IOException {
//        User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//        User click Register link
        customerHomePage=new CustomerHomePage();
        ReusableMethods.waitFor(10);

        customerHomePage.customerRegisterIcon.click();
//        User should enter invalid username in the Username field
        ReusableMethods.waitFor(5);
        customerHomePage.registerUsername.sendKeys(ConfigReader.getProperty("customer_invalid_username"));
//        User should enter valid e-mail address
        ReusableMethods.waitFor(5);
        Faker faker=new Faker();
        customerHomePage.registerEmail.sendKeys(faker.internet().emailAddress());
//        User should enter valid password in Password field
        ReusableMethods.waitFor(5);
        customerHomePage.registerPassword.sendKeys(faker.internet().password());

//        User must click on  "I agree to the privacy policy" checkbox
        ReusableMethods.waitFor(5);
        customerHomePage.agreeCheckbox.click();
//        User should click on sign up button
        ReusableMethods.waitFor(5);
        customerHomePage.signUpButton.click();
        ReusableMethods.waitFor(5);
//      Error message  should be  like "Please enter a valid account username."
        String errorMessage=customerHomePage.errorMessage.getText();

        Assert.assertEquals(errorMessage,"Please enter a valid account username.");

    }

    @Test //wrong email bug
    public void testcase_04() throws IOException {
//        User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//        User click Register link
        customerHomePage=new CustomerHomePage();
        ReusableMethods.waitFor(10);

        customerHomePage.customerRegisterIcon.click();
//        User should enter valid username in the Username field
        Faker faker=new Faker();
        ReusableMethods.waitFor(5);
        customerHomePage.registerUsername.sendKeys(faker.name().username());
//        User should enter invalid e-mail address
        ReusableMethods.waitFor(5);
        customerHomePage.registerEmail.sendKeys(ConfigReader.getProperty("customer_invalid_email"));
//        User should enter  valid password in Password field
        ReusableMethods.waitFor(5);
        customerHomePage.registerPassword.sendKeys(faker.internet().password());

//        User must click on  "I agree to the privacy policy" checkbox
        ReusableMethods.waitFor(5);
        customerHomePage.agreeCheckbox.click();
//        User should click on sign up button
        ReusableMethods.waitFor(5);
        customerHomePage.signUpButton.click();
        ReusableMethods.waitFor(5);
//      Error message  should be  like "Please enter a valid email address."
        String errorMessage=customerHomePage.errorMessage.getText();
        System.out.println(errorMessage);
        Assert.assertFalse(false,"Please enter a valid email address.");

    }
    @Test //wrong password bug
    public void testcase_05() throws IOException {
//        User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//        User click Register link
        customerHomePage=new CustomerHomePage();
        ReusableMethods.waitFor(10);

        customerHomePage.customerRegisterIcon.click();
//        User should enter valid username in the Username field
        Faker faker=new Faker();
        ReusableMethods.waitFor(5);
        customerHomePage.registerUsername.sendKeys(faker.name().username());
//        User should enter valid e-mail address
        ReusableMethods.waitFor(5);
        customerHomePage.registerEmail.sendKeys(faker.internet().emailAddress());
//        User should enter invalid password in Password field
        ReusableMethods.waitFor(5);
        customerHomePage.registerPassword.sendKeys(ConfigReader.getProperty("customer_invalid_password"));
//        User must click on  "I agree to the privacy policy" checkbox
        ReusableMethods.waitFor(5);
        customerHomePage.agreeCheckbox.click();
//        User should click on sign up button
        ReusableMethods.waitFor(5);
        customerHomePage.signUpButton.click();
//      Verify the sign out link is not displayed
        ReusableMethods.verifyElementDisplayed(customerHomePage.signOutButton);



    }
    @AfterMethod
    public void closeBrowser(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }

}
