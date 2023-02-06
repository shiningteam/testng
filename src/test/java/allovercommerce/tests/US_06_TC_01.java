package allovercommerce.tests;

import allovercommerce.pages.customerpages.*;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class US_06_TC_01 {


    @Test
    public void testCase_6 () throws InterruptedException {
        //1- The user goes to ''https://allovercommerce.com/''
                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //2- The user Clicks ''Blue Ski Boots''
        CustomerHomePage homePage= new CustomerHomePage();
        ReusableMethods.waitFor(2);

        //3-The User adds ''Blue Ski Boots''  to the Cart
        homePage.searchBar.sendKeys("Blue Ski Boots");
        ReusableMethods.waitFor(3);
        homePage.searchIcon.click();
        ReusableMethods.waitFor(3);

        //4-The user updates the quantity as 2
        CustomerProductsPage productsPage=new CustomerProductsPage();
        productsPage.plusIcon.click();
        ReusableMethods.waitFor(3);

        Assert.assertTrue(productsPage.plusIcon.isDisplayed());
        //5-The user clicks the update the cart button
        productsPage.addToCartButton.click();
        ReusableMethods.waitFor(3);

        //6- The user clicks the cartIcon
        productsPage.cartIcon.click();
        ReusableMethods.waitFor(6);

        //7- The user clicks the checkout button
        CustomerCheckoutPage checkoutPage=new CustomerCheckoutPage();
        checkoutPage.checkOutButton.click();
        ReusableMethods.waitFor(4);

        //8-The user enters the billing first name
        CustomerBillingAddressPage addressPage=new CustomerBillingAddressPage();
        addressPage.billingFirstName.sendKeys(ConfigReader.getProperty("customer_firstname"));
        ReusableMethods.waitFor(3);

        //9-The user enters the billing last name
        addressPage.billingLastName.sendKeys(ConfigReader.getProperty("customer_lastname"));
        ReusableMethods.waitFor(2);

        //10-The user enters billing company name
        addressPage.billingCompany.sendKeys("EyupSabriTuncer");
        ReusableMethods.waitFor(5);

        //11-The user clicks the Country dropdown and select the billing country
        Select selectDropdown = new Select(addressPage.billingCountry);
        ReusableMethods.waitFor(1);
        selectDropdown.selectByVisibleText("United States (US)");
        ReusableMethods.waitFor(2);

        //12-The user enters the first name last name,country, address,city,state,zip code,email,phone
        addressPage.billingAdress.sendKeys(ConfigReader.getProperty("customer_street_address"));
        ReusableMethods.waitFor(3);

        addressPage.billingCity.sendKeys(ConfigReader.getProperty("customer_city"));
        ReusableMethods.waitFor(2);

        Select select2 = new Select(addressPage.billingState);
        select2.selectByVisibleText("California");
        ReusableMethods.waitFor(3);

        addressPage.billingZipCode.sendKeys(ConfigReader.getProperty("customer_zip_code"));
        ReusableMethods.waitFor(3);

        addressPage.billingPhone.sendKeys(ConfigReader.getProperty("customer_phone_number"));
        ReusableMethods.waitFor(3);

        addressPage.billingEmail.sendKeys(ConfigReader.getProperty("customer_email"));
        ReusableMethods.waitFor(3);

        //13- User clicks Wire transfer/EFT radio button

        checkoutPage.wireTransferButton.click();
        ReusableMethods.waitFor(3);

        //14-User clicks Place Order button

        checkoutPage.placeOrderButton.click();
        ReusableMethods.waitFor(3);

        //15- Verify that Thank-you. Your order has been received.

        Assert.assertTrue(checkoutPage.orderSuccessMessage.isDisplayed());

    }

}
