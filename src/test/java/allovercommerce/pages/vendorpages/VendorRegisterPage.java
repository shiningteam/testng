package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorRegisterPage {
     public VendorRegisterPage(){
         PageFactory.initElements(Driver.getDriver(), this);
     }
    @FindBy(id ="username")
    public WebElement vendorSignInUsernameInput;

     @FindBy(id = "password")
    public WebElement vendorSignInPasswordInput;

     @FindBy(name = "login")
    public WebElement vendorSignInButton;

    @FindBy(id = "user_email")
    public WebElement vendorUserEmail;

    @FindBy(linkText = "Verification Code")
    public WebElement vendorVerificationCode;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement vendorPassword;

    @FindBy(id = "confirm_pwd")
    public WebElement vendorConfirmPassword;

    @FindBy(xpath = "value='Register'")
    public WebElement getVendorRegisterButton;

    @FindBy(xpath = "//div[@class='short']")
    public WebElement tooShortPassword;

    @FindBy(xpath = "//div[@class='weak']")
    public WebElement weakPassword;

    @FindBy(xpath = "//div[@class='good']")
    public WebElement goodPassword;

    @FindBy(xpath = "//div[@class='strong']")
    public WebElement strongPassword;

}
