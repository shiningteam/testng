package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.pages.customerpages.CustomerMyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class US_05_TC_01 {
    @Test
    public void editAccountDetails(){
        CustomerHomePage customerHomePage = new CustomerHomePage();
        CustomerMyAccountPage customerMyAccountPage = new CustomerMyAccountPage();

//        1- The user goes to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//        2- Click "Sign in" button
        customerHomePage.signIn.click();
//        3- Enter username or email address
        customerHomePage.username.sendKeys("merve1991@gmail.com");
//        4- Enter password
        customerHomePage.password.sendKeys("mervemermer");
//        5- Click the "sign in" button
        customerHomePage.submit.click();
        ReusableMethods.waitFor(10);
//        6- Click "my account" button
        JSUtils.clickElementByJS(customerHomePage.myAccountButton);
//        7- Click "account details" button
        customerMyAccountPage.accountDetails.click();
        ReusableMethods.waitFor(10);
//        8- Edit firstname, lastname, displayname, emailadress
        customerMyAccountPage.accountFirstName.sendKeys();
//        9- Fill in the Biography section.
//        10- Change the password
//        11- Click the "save changes" button
//        12- Verify appears "Account details changed successfully."
    }

}
