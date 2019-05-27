package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage{
    AppiumDriver appiumDriver;

    @FindBy(xpath="//android.widget.TextView[@text='Inventory']")
    private WebElement txtTitle;

    @FindBy(id="actionAdd")
    private WebElement tvAdd;

    @FindBy(id="actionSearch")
    private WebElement tvSearch;




    public InventoryPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void clickOnTvAdd(){
        waitForElementToBeVisible(tvAdd);
        tvAdd.click();
    }

    public void clickOnTvSearch(){
        waitForElementToBeVisible(tvSearch);
        tvSearch.click();
    }

    public void verifyToolAdded(String searchInput) {
        clickOnTvSearch();
        new SearchInventoryPage(appiumDriver).enterSearchText(searchInput);
        new SearchInventoryPage(appiumDriver).verifySearchResult(searchInput);
    }
}
