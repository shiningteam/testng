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



//    @FindBy(xpath = "//a[.='Store Manager']")
//    public WebElement StoreManagerButton;
//
//    @FindBy(linkText="Products")
//    public WebElement ProductsButton;
//
//    @FindBy(xpath = "//span[.='Add New']")
//    public WebElement AddNewButton;


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

    @FindBy(xpath = "//select[@id='catalog_visibility']")
    public WebElement catalogOptions;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement imageButton;

    @FindBy(xpath = "//button[@id='menu-item-upload']")
    public WebElement upload;

    @FindBy(xpath = "//button[.='Select Files']")
    public WebElement selectFiles;

    @FindBy(xpath = "//button[.='Select']")
    public WebElement select;



    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement signOutIcon;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/'])[1]")
    public WebElement myAccountButton;



    @FindBy(xpath = "(//a[@class='wcfm_dashboard_item_title'])[1]")
    public WebElement firstCode;

    @FindBy(id= "is_virtual")
    public WebElement virtualCheckBox;

    @FindBy(id="is_downloadable")
    public WebElement downloadableCheckBox;



    @FindBy(id = "product_type")
    public WebElement productType;

    @FindBy(xpath = "(//div[.='Attributes'])[2]")
    public WebElement AttributesButton;

    @FindBy(id = "attributes_is_active_1")
    public WebElement attributesColarCheckBox;

    @FindBy(id = "attributes_is_active_2")
    public WebElement attributesSizeCheckBox;



    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement selectColorOptions;

    @FindBy(xpath="(//ul[@class='select2-selection__rendered'])[3]")
    public WebElement selectSize0ptions;

    @FindBy(xpath = "(//button[@type='button'])[39]")
    public  WebElement addButtonColor;

    @FindBy(xpath = "(//button[@type='button'])[42]")
    public  WebElement addButtonSize;


    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[6]")
    public  WebElement variationsButton;

    @FindBy(name = "default_attributes[attribute_pa_color]")
    public  WebElement anyColorDropdown;

    @FindBy(name = "default_attributes[attribute_pa_size]")
    public  WebElement anySizeDropdown;














}
