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

    @FindBy(id="billing_address_1")
    public WebElement billingStreetAddress;

    @FindBy (xpath = "//input[@id='billing_city']")
    public WebElement billingCity;

    @FindBy (id = "billing_state")
    public WebElement billingState;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement billingZipCode;

    @FindBy(xpath = "//input[@id='billing_phone']" )
    public WebElement billingPhone;

    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement billingEmail;

    @FindBy(id="billing_country")
    public WebElement selectCountryDropdown;

    @FindBy(id="billing_state")
    public WebElement selectStateDropdown;

    @FindBy(name="save_address")
    public WebElement saveAddressButton;

    @FindBy(xpath = "//a[.='Edit Your Billing Address']")
    public WebElement successfulMessage;

    @FindBy(partialLinkText = "alert")
     public WebElement firstnameAlertMessage;

    @FindBy(xpath = "//li[@data-id='billing_last_name']")
    public WebElement lastnameAlertMessage;

    @FindBy(xpath = "//li[@data-id='shipping_country']")
    public WebElement countryAlertMessage;

    @FindBy(xpath = "//li[@data-id='shipping_address_1']")
    public WebElement addressAlertMessage;

    @FindBy(xpath = "//li[@data-id='shipping_city']")
    public WebElement cityAlertMessage;

    @FindBy(xpath = "//li[@data-id='shipping_state']")
    public WebElement stateAlertMessage;

    @FindBy(xpath = "//li[@data-id='shipping_postcode']")
    public WebElement zipcodeAlertMessage;

    @FindBy(partialLinkText = "The following addresses")
    public WebElement registeredEmailAddress;
}



