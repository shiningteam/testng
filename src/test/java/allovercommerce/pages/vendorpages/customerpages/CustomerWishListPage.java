package allovercommerce.pages.vendorpages.customerpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerWishListPage {

    public CustomerWishListPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//h2[@class='page-title']")
    public WebElement wishlistPageTitle;

    @FindBy(id="product-13257")
    public WebElement backpackQuickViewPage;

    @FindBy(xpath="//button[@data-product='13257']")
    public WebElement backpackQuickViewButton;

    @FindBy(xpath="//button[@title='Close (Esc)']")
    public WebElement backpackQuickViewCloseButton;

    @FindBy(xpath ="//a[@data-product_id='13257']")
    public WebElement backpackAddToCartButton;

    @FindBy(linkText = "Cart")
    public WebElement CartButton;

    @FindBy(partialLinkText = "Comfortable Backpack")
    public WebElement backpackProduct;


}
