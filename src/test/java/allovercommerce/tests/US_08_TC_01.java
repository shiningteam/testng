package allovercommerce.tests;

import allovercommerce.pages.customerpages.CustomerHomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US_08_TC_01 {

    @BeforeTest
    public void HomePage() {
        CustomerHomePage customerHomePage = new CustomerHomePage();
        //User goes to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        //Click on the signIn icon
        customerHomePage.signIn.click();
        //Enter the username, password and click signIn button
        customerHomePage.username.sendKeys(ConfigReader.getProperty("customer_username"));
        customerHomePage.password.sendKeys(ConfigReader.getProperty("customer_password"));
        customerHomePage.submit.click();
    }

        @Test
        public void TC_01_test() {
        //3-Go to the item that you want to add the wishlist
        //4-Click on the "heart" icon
        //5-Go to the top of the page and click on "Wishlist" button
        //6-Verify the item that added to the wishlist is displayed
    }

        @Test
        public void TC_02_test() {
        //5-click on "Wishlist" button
        //6-Verify the items that added to the wishlist is displayed
    }

        @Test
        public void TC_03_test() {
        //Click on "Wishlist" button
        //Verify the wishlist page is displayed expected
        //Click on "Quick View" button
        //Verify the attributes of the item on the Wishlist is displayed
        //Close the attributes of the item page
    }
        @Test
        public void TC_04_test() {

        //10-Click on the "Add to Cart" button
        //11-Click on the "Cart" button
        //12- Click on the "View Cart" button
        //13-Verify the item that added to the cart is displayed
        //14- Click on the "Proceed to Checkout" button
        //15-Verify the all required fields are filled
        //16-Click on "Place Order" button
        //17-Verify the order is completed successfully

    }
//    @AfterTest
//    public void closeBrowser(){
//        ReusableMethods.waitFor(3);
//        Driver.closeDriver();
//   }
}
