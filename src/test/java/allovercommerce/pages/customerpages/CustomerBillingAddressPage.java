package allovercommerce.pages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerBillingAddressPage {

    public CustomerBillingAddressPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingFirstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement billingLastName;

    @FindBy(xpath = "//input[@id='billing_company']")
    public WebElement billingCompany;

    @FindBy(id = "billing_country")
    public WebElement billingCountry;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement billingAdress;

    @FindBy (xpath = "//input[@id='billing_city']")
    public WebElement billingCity;

    @FindBy (id = "billing_state")
    public WebElement billingState;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement billingZipcode;

    @FindBy(xpath = "//input[@id='billing_phone']" )
    public WebElement billingPhone;

    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement billingEmail;


}