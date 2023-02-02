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







}
