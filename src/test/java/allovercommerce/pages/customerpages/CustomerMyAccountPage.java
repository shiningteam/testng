package allovercommerce.pages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerMyAccountPage {

    public CustomerMyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText="Addresses")
    public WebElement addressesIcon;

    @FindBy(xpath="(//a[.='Add'])[2]")
    public WebElement addShippingAddressButton;

    @FindBy(linkText = "Account details")
    public WebElement accountDetails;

    @FindBy(xpath = "//h4[contains(text(),'Account Details')]")
    public WebElement accountDetailsText;

    @FindBy(xpath = "//input[@id='account_display_name']")
    public WebElement displayName;

    @FindBy(xpath = "//input[@id='account_first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='account_last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='account_email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//iframe[@id='user_description_ifr']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@data-id='user_description']//p")
    public WebElement biography;

    @FindBy(xpath = "//input[@id='password_current']")
    public WebElement currentPassword;

    @FindBy(xpath = "//input[@id='password_1']")
    public WebElement password1;

    @FindBy(id = "password_2")
    public WebElement password2;

    @FindBy(xpath = "//button[contains(text(),'Save changes')]")
    public WebElement saveChanges;

    @FindBy(xpath = "//div[@class ='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement accountDetailsSaved;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement signOut;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    public WebElement logOut;

    @FindBy(xpath = "//li[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement noMatch;





    @FindBy(xpath = "//a//img[@height='186']")
    public WebElement alloverCommerceButton;




}
