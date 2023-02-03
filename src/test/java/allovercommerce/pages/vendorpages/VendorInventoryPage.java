package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInventoryPage {


    public VendorInventoryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(xpath = "//div[.='Inventory']")
    public WebElement InventoryButton;
    @FindBy(id = "sku")
    public WebElement InventorySKU;
    @FindBy(id = "manage_stock")
    public WebElement ManageStockBox;
    @FindBy(id = "stock_qty")
    public WebElement StockQty;
    @FindBy(id = "backorders")
    public WebElement AllowBackordersOptions;
    @FindBy(id = "stock_status")
    public WebElement StockStatusOptions;
    @FindBy(id = "sold_individually")
    public WebElement SoldIndividuallyCheckBox;



    @FindBy(xpath = "//div[.='Shipping']")
    public WebElement ShippingButton;
    @FindBy(id = "weight")
    public WebElement ProductWeight;
    @FindBy(id = "length")
    public WebElement ProductLength;
    @FindBy(id = "widght")
    public WebElement ProductWidth;
    @FindBy(id = "height")
    public WebElement ProductHeight;
    @FindBy(id = "shipping_class")
    public WebElement ShippingClassOptions;
    @FindBy(id = "_wcfmmp_processing_time")
    public WebElement ProcessingTimeOptions;


    @FindBy(xpath = "//div[.='Attributes']")
    public WebElement AttributesButton;
    @FindBy(id = "attributes_is_active_1")
    public WebElement AttributesColarActivationCheckBox;
    @FindBy(xpath = "//span[@title='Toggle Block']")
    public WebElement Colar0ptionsArrow;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    //@FindBy(id="attributes_value_1")
    public WebElement Colar0ptions;
//    @FindBy(id = "attributes_is_visible_1")
//    public WebElement ColarAttributesVisibleCheckBox;


//    @FindBy(id = "attributes_is_active_2")
//    public WebElement AttributesSizeActivationCheckBox;
    @FindBy(id="attributes_value_2")
    public WebElement Size0ptions;
    @FindBy(id = "attributes_is_visible_2")
    public WebElement SizeAttributesVisibleCheckBox;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement AttributeAddButton;
    @FindBy(id = "attributes_is_active_3")
    public WebElement AttributeAddActivationCheckBox;
    @FindBy(id = "attributes_name_3")
    public WebElement AddedAttributeName;
    @FindBy(id = "attributes_value_3")
    public WebElement AddedAttributeValue;

    @FindBy(xpath = "//div[.='Linked']")
    public WebElement LinkedButton;
    @FindBy(xpath = "//Input[@class='select2-search__field']")
    public WebElement UpSellsOptions;
    @FindBy(xpath = "//Input[@class='select2-search__field']")
    public WebElement CrossSellsOptions;


    @FindBy(id="wcfm_products_manage_form_yoast_head")
    public WebElement SEOButton;
    @FindBy(id = "yoast_wpseo_focuskw_text_input")
    public WebElement SEOFocusKeyWord;
    @FindBy(id = "yoast_wpseo_metadesc")
    public WebElement SEOMetaDescribtion;


    @FindBy(xpath = "//div[.='Toptan Ürün Gösterme Ayarları']")
    public WebElement ToptanUrunGostermeAyarlariButton;
    @FindBy(id = "piecetype")
    public WebElement PieceTypeOptions;
    @FindBy(id = "unitpercart")
    public WebElement UnitPerType;
    @FindBy(id = "minorderqtytr")
    public WebElement MinOrderQty ;


    @FindBy(id="wcfm_products_manage_form_advanced_head")
    public WebElement AdvancedButton;
    @FindBy(id = "enable_reviews")
    public WebElement EnableReviewsCheckBox;
    @FindBy(id = "menu_order")
    public WebElement MenuOrder;
    @FindBy(id="purchase_note")
    public WebElement PurchaseNote;

}
