package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseItemTypePage extends BasePage {
    AppiumDriver appiumDriver;

    @FindBy(id="menuOptionChooseOtherItem")
    private WebElement llMenuOptionChooseOtherItem;



    public ChooseItemTypePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void clickOnLlMenuOptionChooseOtherItem(){
        waitForElementToBeVisible(llMenuOptionChooseOtherItem);
        llMenuOptionChooseOtherItem.click();
    }
}
