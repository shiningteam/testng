package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorMyAccountPage {
    public VendorMyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerIcon;



    @FindBy(linkText="Addresses")
    public WebElement AddressesButton;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    public WebElement addToCart;

    @FindBy(xpath = "//a[@class='cart-toggle']")
    public WebElement cart;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    public WebElement checkout;


    @FindBy(xpath = "//a[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement AddressAddButton;

    @FindBy(linkText = "Log out")
    public WebElement logOutIcon;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement orders;

    @FindBy(xpath = "//a[@class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public WebElement browseProducts;

    @FindBy(linkText = "1984 George Orwell")
    public WebElement georgeOrwell;

//    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
//    public WebElement addToCart;
//
//    @FindBy(xpath = "//a[@class='cart-toggle']")
//    public WebElement cart;
//
//    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
//    public WebElement checkout;






}
