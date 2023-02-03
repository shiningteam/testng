package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorStoreManagerPage {
    public VendorStoreManagerPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement productsIcon;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNewIcon;

    @FindBy(id = "product_type")
    public WebElement simpleProductDropdown;

    @FindBy(id = "product_url")
    public WebElement urlBox;

    @FindBy(id = "button_text")
    public WebElement buttonTextBox;

    @FindBy(id = "regular_price")
    public WebElement priceBox;

    @FindBy(id = "sale_price")
    public WebElement salePriceBox;

    @FindBy(id = "wcfm_products_simple_submit_button")
    public WebElement submitButton;

    @FindBy(className = "wcfm-message")
    public WebElement warningBox;

    @FindBy(linkText = "Coupons")
    public WebElement couponsButton;

    @FindBy( id="pro_title")
    public WebElement ProductTitle;

    @FindBy( id= "wcfm_products_simple_draft_button")
    public WebElement DraftButton;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement StoreManagerButton;
//
//    @FindBy(xpath = "//span[.='Products']")
//    public WebElement ProductsButton;

    @FindBy(linkText="Products")
    public WebElement ProductsButton;


    @FindBy(xpath = "//span[.='Add New']")
    public WebElement AddNewButton;



}
