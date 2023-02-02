package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorCouponsPage {

    public VendorCouponsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Add New")
    public WebElement couponsAddNewIcon;

    @FindBy(id = "title")
    public WebElement codeBox;

    @FindBy(id = "description")
    public WebElement descriptionBox;

    @FindBy(id = "discount_type")
    public WebElement discountTypeDropdown;

    @FindBy(id = "coupon_amount")
    public WebElement couponAmountBox;

    @FindBy(id = "expiry_date")
    public WebElement couponExpiryDateBox;

    @FindBy(className = "ui-datepicker-month")
    public WebElement monthDropdown;

    @FindBy(className = "ui-datepicker-year")
    public WebElement yearDropdown;

    @FindBy(xpath = "(//tbody//tr//td[@class=' ui-datepicker-week-end '])[10]")
    public WebElement decDay;

    @FindBy(id = "free_shipping")
    public WebElement allowFreeShippingCheckbox;

    @FindBy(id = "show_on_store")
    public WebElement showOnStoreCheckbox;

    @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement submitButton;



}
