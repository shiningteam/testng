package allovercommerce.tests;

import allovercommerce.pages.vendorpages.customerpages.CustomerHomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class US_03_TC_01 {

    /*
        1- User goes to "https:https:https://allovercommerce.com/"
        2- User clicks "Sign In" button.
        3- User enters "Username or email address".
        4- User enters "Password".
        5- User clicks "SIGN IN".
        6- User scrolls down the page.
        7- User clicks on the "My Account" button.
        8- User clicks on the "Addresses" button.
        9- User goes to the "Billing Address" and click on the ADD button.
        10- User enters the First name, Last name, Country/Region, Street address, Town / City, State and ZIP Code and Phone.
        11- User clicks on the "Save Address" button.
        12- User verifies the registered email address is filled in automatically.
        13- User verifies the "Billing Address" is added successfully.
     */

    CustomerHomePage customerHomePage;
    @Test
    public void billingAddress(){
        // 1- User goes to "https:https:https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // 2- User clicks "Sign In" button.
        customerHomePage = new CustomerHomePage();
        ReusableMethods.waitFor(2);
        customerHomePage.signIn.click();

        // 3- User enters "Username or email address".
        ReusableMethods.waitFor(2);
        Faker faker = new Faker();
        customerHomePage.customerEmail.sendKeys(faker.internet().emailAddress());

        // 4- User enters "Password".
        ReusableMethods.waitFor(2);
        customerHomePage.customerPassword.sendKeys(faker.internet().password());

        // 5- User clicks "SIGN IN".
        ReusableMethods.waitFor(2);
        customerHomePage.customerSignInButton.click();

        // 6- User scrolls down the page.
        // 7- User clicks on the "My Account" button.
        // 8- User clicks on the "Addresses" button.
        // 9- User goes to the "Billing Address" and click on the ADD button.
        // 10- User enters the First name, Last name, Country/Region, Street address, Town / City, State and ZIP Code and Phone.
        // 11- User clicks on the "Save Address" button.
        // 12- User verifies the registered email address is filled in automatically.
        // 13- User verifies the "Billing Address" is added successfully.
    }
}
