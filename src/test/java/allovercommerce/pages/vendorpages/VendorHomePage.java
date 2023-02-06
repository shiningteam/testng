package allovercommerce.pages.vendorpages;
import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorHomePage {

    public VendorHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//*[.='Sign In'])[2]")
    public WebElement vendorSignInIcon;

    @FindBy(xpath = "(//*[.='Sign Out'])[1]")
    public WebElement signOutIcon;

    @FindBy(linkText = "Log out")
    public WebElement logOutIcon;


    @FindBy(linkText = "My Account")
    public WebElement myAcountIcon;


    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement VendorSignInButton;

    @FindBy(linkText="My Account")
    public WebElement myAccountButton;

    @FindBy(linkText="Addresses")
    public WebElement AddressesButton;

    @FindBy(xpath = "//a[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement AddressAddButton;


     // @FindBy(linkText="Sign In")
        //public WebElement VendorSignInIcon;










    @FindBy(linkText="Sign In")
    public WebElement VendorSignInIcon;


//    @FindBy(id="username")
//    public WebElement username;
//
//    @FindBy(id="password")
//    public WebElement password;
//
//    @FindBy(xpath = "//button[.='Sign In']")
//    public WebElement VendorSignInButton;
//
//    @FindBy(linkText="My Account")
//    public WebElement myAccountButton;




    @FindBy(linkText = "Register")
    public WebElement vendorRegisterButton;

    @FindBy(linkText = "Become a Vendor")
    public WebElement becomeAVendorButton;
}
