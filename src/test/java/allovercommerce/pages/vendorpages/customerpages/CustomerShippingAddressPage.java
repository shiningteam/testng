package allovercommerce.pages.vendorpages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerShippingAddressPage {

    public CustomerShippingAddressPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="shipping_first_name")
    public WebElement shippingFirstnameInput;

    @FindBy(id="shipping_last_name")
    public WebElement shippingLastnameInput;

    @FindBy(id="shipping_company")
    public WebElement shippingCompany;

    @FindBy(id="shipping_country")
    public WebElement selectCountryDropdown;

    @FindBy(id="shipping_address_1")
    public WebElement shippingStreetAddressInput;

    @FindBy(id="shipping_city")
    public WebElement shippingCityInput;

    @FindBy(id="shipping_state")
    public WebElement selectStateDropdown;

    @FindBy(id="shipping_postcode")
    public WebElement shippingZipCodeInput;

    @FindBy(name="save_address")
    public WebElement saveAddressButton;

    @FindBy(xpath = "//a[.='Edit Your Shipping Address']")
    public WebElement successfulMessage;

    //Alert Messages
    @FindBy(xpath = "//li[@data-id='shipping_first_name']")
    public WebElement firstnameAlertMessage;

    @FindBy(xpath = "//li[@data-id='shipping_last_name']")
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

}
