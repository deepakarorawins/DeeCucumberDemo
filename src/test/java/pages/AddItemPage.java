package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddItemPage extends BasePage {

    AppiumDriver appiumDriver;

    @FindBy(xpath="(//*[contains(@resource-id,'tvItemDescriptionLabel')]//..//android.widget.EditText)[1]")
    private WebElement txtDescription;

    @FindBy(xpath="(//*[contains(@resource-id,'tvItemModelNumberLabel')]//..//android.widget.EditText)[2]")
    private WebElement txtModelNumber;

    @FindBy(id="addItemActionSave")
    private WebElement tvAddItemActionSave;


    public AddItemPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void enterDescription(String description){
        waitForElementToBeVisible(txtDescription);
        txtDescription.sendKeys(description);
    }

    public void enterModelNumber(String modelNumber){
        waitForElementToBeVisible(txtModelNumber);
        txtModelNumber.sendKeys(modelNumber);
    }

    public void clickOnTvSave(){
        waitForElementToBeVisible(tvAddItemActionSave);
        tvAddItemActionSave.click();
    }
}
