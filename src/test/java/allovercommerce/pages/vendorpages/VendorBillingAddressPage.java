package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorBillingAddressPage {

    public VendorBillingAddressPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



//    @FindBy(xpath = "//a[vendor_zip_code']")
//    public WebElement BillingAddressAddButton;

    @FindBy(id = "billing_first_name")
    public WebElement BillingFirstName;

    @FindBy(id = "billing_last_name")
    public WebElement BillingLastName;

    @FindBy(id = "billing_company")
    public WebElement BillingCompanyName;

    @FindBy(id = "billing_country")
    //@FindBy(xpath = "//span[@class='select2-selection__rendered']")
    public WebElement BillingCountryOptions;

    @FindBy(id = "billing_address_1")
    public WebElement BillingStreetName;

    @FindBy(id = "billing_city")
    public WebElement BillingCity;

    @FindBy(id="billing_state")
    public WebElement BillingStateOptions;

    @FindBy(id = "billing_postcode")
    public WebElement BillingPostCode;

    @FindBy(id = "billing_phone")
    public WebElement BillingPhone;

    @FindBy(id="billing_email")
    public WebElement BillingEmail;

    @FindBy(name="save_address")
    public WebElement SaveAddressButton;

    @FindBy(xpath = "//a[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement EditYourBillinAddress;

    @FindBy(xpath = "//a[.='Edit Your Shipping Address']")
    public WebElement successfulMessage;

}
