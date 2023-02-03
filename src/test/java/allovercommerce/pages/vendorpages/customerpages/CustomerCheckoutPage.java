package allovercommerce.pages.vendorpages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerCheckoutPage {

    public CustomerCheckoutPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="place_order")
    public WebElement placeOrderButton;

    @FindBy(xpath="//*[.='Thank you. Your order has been received.']")
    public WebElement orderSuccessMessage;
}
