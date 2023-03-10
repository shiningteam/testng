package allovercommerce.pages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerShoppingCartPage {
   public CustomerShoppingCartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='coupon_code']")
    public WebElement enterCouponBox;

    @FindBy(xpath = "//button[contains(text(),'Apply coupon')]")
    public WebElement applyCouponButton;

    @FindBy(linkText = "Comfortable Backpack")
    public WebElement backpackProduct;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;


}
