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

    @FindBy(id="account_first_name")
    public WebElement accountFirstName;

    @FindBy(xpath = "//a//img[@height='186']")
    public WebElement alloverCommerceButton;




}
