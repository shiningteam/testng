package allovercommerce.tests;

import allovercommerce.pages.vendorpages.VendorHomePage;
import allovercommerce.pages.vendorpages.VendorRegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class US_09_TC_01 {

    /*
        1- User goes to "https:https:https://allovercommerce.com/"
        2- User clicks "Register" button.
        3- User clicks "Become a Vendor".
        4- User enters "E-mail" address.
        5- User enters the verification code in the "Verification Code" text box.
        6- User enters the "Password".
        7- User enters the password again in the "Confirm Password" field.
        8- User clicks "REGISTER" button.
        9- Verifies that Registration as a Vendor is completed by clicking on the Register button.
        10- Verifies that the message "This Email already exists. Please log in to the site and apply as vendor."
            will appear if the user tries to register using a registered email address.
     */

    VendorHomePage vendorHomePage;
    VendorRegisterPage vendorRegisterPage;

    @Test
    public void vendorRegistration(){
        // 1- User navigates to "https:https:https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        // 2-

        // 2- User clicks "Registration" button.
        vendorHomePage = new VendorHomePage();
        ReusableMethods.waitFor(2);
        vendorHomePage.vendorRegisterButton.click();

        // 3- User clicks "Become a Vendor".
        ReusableMethods.waitFor(2);
        vendorHomePage.becomeAVendorButton.click();

        // 4- User enters a valid "E-mail" address.
        vendorRegisterPage = new VendorRegisterPage();
        ReusableMethods.waitFor(2);
        Faker faker = new Faker();
        vendorRegisterPage.vendorUserEmail.sendKeys(faker.internet().emailAddress());

        // 5- User enters the verification code in the "Verification Code" text box.
        //ReusableMethods.waitFor(2);
        vendorRegisterPage.vendorVerificationCode.sendKeys("");

        // 6- User enters the "Password".
        ReusableMethods.waitFor(2);
        vendorRegisterPage.vendorPassword.sendKeys(faker.internet().password());

        // 7- User enters the password again in the "Confirm Password" field.
        //ReusableMethods.waitFor(2);
        //vendorRegisterPage.vendorConfirmPassword.;

        // 8- User clicks "REGISTER" button.
        ReusableMethods.waitFor(2);
        vendorRegisterPage.getVendorRegisterButton.click();

        // 9- Verifies that Registration as a Vendor is completed by clicking on the Register button.
        ReusableMethods.waitFor(2);

        // 10- Verifies that the message "This Email already exists. Please log in to the site and apply as vendor."
        //     will appear if the user tries to register using a registered email address.
        ReusableMethods.waitFor(2);




    }
}
