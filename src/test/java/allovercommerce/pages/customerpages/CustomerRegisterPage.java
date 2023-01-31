package allovercommerce.pages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegisterPage {

    public CustomerRegisterPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="reg_username")
    public WebElement registerUsernameInput;

    @FindBy(id="reg_email")
    public WebElement registerEmailInput;

    @FindBy(id="reg_password")
    public WebElement registerPasswordInput;

    @FindBy(id="register-policy")
    public WebElement registerPolicyCheckbox;

    @FindBy(name="register")
    public WebElement signUpButton;

    @FindBy(xpath = "(//p[@class='submit-status'])[2]")
    public WebElement alreadyRegisteredMessage;










}
