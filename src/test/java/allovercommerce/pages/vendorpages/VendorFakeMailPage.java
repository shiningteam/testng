package allovercommerce.pages.vendorpages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorFakeMailPage {

    public VendorFakeMailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='email']")
    public WebElement eMail;

    @FindBy(xpath = "//*[contains(text(), 'Email Verification Code')]")
    public WebElement verificationCodeText;
}
