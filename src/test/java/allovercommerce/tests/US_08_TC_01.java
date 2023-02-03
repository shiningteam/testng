package allovercommerce.tests;

import allovercommerce.pages.customerpages.*;
import allovercommerce.pages.vendorpages.customerpages.*;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.*;

public class US_08_TC_01 {

    @BeforeMethod
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
        //Go to the item that you want to add the wishlist and click on the "heart" icon
        CustomerProductsPage customerProductsPage = new CustomerProductsPage();
        JSUtils.scrollDownByJS();
        JSUtils.clickElementByJS(customerProductsPage.backpackHeartButton);

        //Click on "Wishlist" button
        CustomerHomePage customerHomePage = new CustomerHomePage();
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(customerHomePage.WishlistButton);

        //Verify the item that added to the wishlist is displayed
        CustomerWishListPage customerWishListPage = new CustomerWishListPage();
        ReusableMethods.verifyElementDisplayed(customerWishListPage.backpackProduct);

    }
        @Test
        public void TC_02_test() {
        //Click on "Wishlist" button
        CustomerHomePage customerHomePage = new CustomerHomePage();
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(customerHomePage.WishlistButton);

        //Verify the wishlist page is displayed properly
        CustomerWishListPage customerWishListPage = new CustomerWishListPage();
        Assert.assertTrue(customerWishListPage.wishlistPageTitle.isDisplayed());
        Assert.assertEquals("Wishlist", customerWishListPage.wishlistPageTitle.getText());

        //Click on "Quick View" button
        JSUtils.clickElementByJS(customerWishListPage.backpackQuickViewButton);

        //Verify the attributes of the item on the Wishlist is displayed
        Assert.assertTrue(customerWishListPage.backpackQuickViewPage.isDisplayed());

        //Close the attributes of the item page
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(customerWishListPage.backpackQuickViewCloseButton);
    }
        @Test
        public void TC_03_test() {

        CustomerProductsPage customerProductsPage = new CustomerProductsPage();
        JSUtils.scrollDownByJS();
        JSUtils.clickElementByJS(customerProductsPage.backpackHeartButton);

        //Click on "Wishlist" button
        CustomerHomePage customerHomePage = new CustomerHomePage();
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(customerHomePage.WishlistButton);

        //Click on the "Add to Cart" button
        CustomerWishListPage customerWishListPage = new CustomerWishListPage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(customerWishListPage.backpackAddToCartButton);

        //Click on the "Cart" button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(customerWishListPage.CartButton);

        //Verify the item that added to the cart is displayed
        CustomerShoppingCartPage customerShoppingCartPage = new CustomerShoppingCartPage();
        Assert.assertTrue(customerShoppingCartPage.backpackProduct.isDisplayed());

        //Click on the "Proceed to Checkout" button
        JSUtils.clickElementByJS(customerShoppingCartPage.proceedToCheckoutButton);

        //Click on "Place Order" button
        CustomerCheckoutPage customerCheckoutPage = new CustomerCheckoutPage();
        JSUtils.clickElementByJS(customerCheckoutPage.placeOrderButton);

        //Verify the order is completed successfully
        Assert.assertTrue(customerCheckoutPage.orderSuccessMessage.isDisplayed());
    }
        @AfterMethod
        public void closeBrowser(){
            ReusableMethods.waitFor(3);
            Driver.closeDriver();
       }
}
