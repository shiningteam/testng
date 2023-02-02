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
}
