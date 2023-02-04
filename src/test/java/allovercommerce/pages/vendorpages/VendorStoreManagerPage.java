package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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



    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement StoreManagerButton;

    @FindBy(linkText="Products")
    public WebElement ProductsButton;

    @FindBy(xpath = "//span[.='Add New']")
    public WebElement AddNewButton;

    @FindBy(xpath= "//button[@id='insert-media-button']")
    public WebElement addMedia;
    @FindBy(xpath= "//h2[contains(text(),'Add Product')]")
    public WebElement addProductText;

    @FindBy(xpath="//img[@id='featured_img_display']")
    public WebElement addImage;

    @FindBy(xpath = "//select[@id='product_type']//option")
    public List<WebElement> productTypeOptions;

    @FindBy(xpath = "//input[@id='pro_title']")
    public  WebElement productTitle;

    @FindBy(id = "excerpt_ifr")
    public WebElement shortDescriptionFrame;

    @FindBy(xpath = "//strong[contains(text(),'Short Description')]")
    public WebElement shortDescriptionText;

    @FindBy(xpath = "(//p[.='Description'])[1]")
    public WebElement descriptionText;

    @FindBy(id = "description_ifr")
    public WebElement descriptionFrame;

    @FindBy(xpath = "//body[@id='tinymce']//p")
    public WebElement description;

    @FindBy(xpath = "//input[@value='229']")
    public WebElement checkboxCategory;

    @FindBy(xpath = "//p[contains(text(),'+Add new category')]")
    public WebElement addNewCategory;

    @FindBy(xpath = "//input[@id='wcfm_new_cat']")
    public WebElement categoryName;

    @FindBy(id = "wcfm_new_parent_cat")
    public WebElement categoryParentName;

    @FindBy(xpath = "//button[@data-taxonomy='product_cat']")
    public WebElement addCategoryButton;

    @FindBy(xpath = "//input[@id='wcfm_new_product_brand']")
    public WebElement brandName;

    @FindBy(xpath = "//select[@id='wcfm_new_parent_product_brand']")
    public WebElement brandParentName;

    @FindBy(xpath = "//input[@value='335']")
    public WebElement checkboxBrand;

    @FindBy(xpath = "//p[contains(text(),'+Add new Product brands')]")
    public WebElement addBrandName;

    @FindBy(xpath = "//button[@data-taxonomy='product_brand']")
    public WebElement addBrandButton;

    @FindBy(xpath = "//textarea[@id='product_tags']")
    public WebElement tagName;

    @FindBy(xpath = "//strong[contains(text(),'Tags')]")
    public WebElement tagText;

    @FindBy(xpath = "//select[@id='catalog_visibility']//option")
    public List<WebElement> catalogVisibility;




    @FindBy(xpath = "//*[*='Sign Out']")
    public WebElement signOutIcon;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/'])[1]")
    public WebElement myAccountButton;












}
