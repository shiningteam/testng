package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorCheckoutPage {
    public VendorCheckoutPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Enter your code')]")
    public WebElement enterYourCode;

    @FindBy(id = "coupon_code")
    public  WebElement couponCode;

    @FindBy(xpath = "//button[contains(text(),'Apply coupon')]")
    public  WebElement applyCoupon;

    @FindBy(xpath = "//li[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public  WebElement alert;

}
