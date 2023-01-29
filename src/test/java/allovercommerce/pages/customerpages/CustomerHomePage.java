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


}
