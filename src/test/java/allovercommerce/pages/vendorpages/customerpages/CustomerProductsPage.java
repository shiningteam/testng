package allovercommerce.pages.vendorpages.customerpages;

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









}
