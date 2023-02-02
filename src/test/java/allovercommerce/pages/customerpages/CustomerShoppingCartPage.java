package allovercommerce.pages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerShoppingCartPage {
   public CustomerShoppingCartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "coupon_code")
    public WebElement enterCouponBox;

   @FindBy(name = "apply_coupon")
    public WebElement applyCouponButton;
}
