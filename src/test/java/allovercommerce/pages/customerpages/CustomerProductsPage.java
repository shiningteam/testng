package allovercommerce.pages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerProductsPage {

    public CustomerProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//a[@data-product-id='13257']")
    public WebElement backpackHeartButton;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement plusIcon;

    @FindBy(xpath = "//button[@value='13232']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@data-id='fbb1175']")
    public WebElement cartIcon;










}
