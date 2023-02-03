package allovercommerce.pages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerHomePage {

    public CustomerHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText="Register")
    public WebElement customerRegisterIcon;

    @FindBy(linkText="My Account")
    public WebElement myAccountButton;


    @FindBy(xpath="//a[@class='login inline-type']")
    public WebElement signIn;

    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="rememberme")
    public WebElement rememberMe;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement submit;

    @FindBy(id = "reg_username")
    public WebElement registerUsername;

    @FindBy(id = "reg_email")
    public WebElement registerEmail;

    @FindBy(id = "reg_password")
    public WebElement registerPassword;

    @FindBy(id = "register-policy")
    public WebElement agreeCheckbox;

    @FindBy(name = "register")
    public WebElement signUpButton;

    @FindBy(linkText = "Sign Out")
    public WebElement signOutButton;

    @FindBy(linkText = "Wishlist")
    public WebElement WishlistButton;

    @FindBy(xpath = "(//p[@class='submit-status'])[2]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@aria-live='polite']")
    public WebElement weakPasswordMessage;

    @FindBy(className = "single_add_to_cart_button button alt")
    public WebElement mensClothingAddToCartButton;

    @FindBy(xpath = "//div[@data-id='fbb1175']")
    public WebElement cartIcon;

    @FindBy(linkText = "View cart")
    public WebElement viewCartButton;



}
