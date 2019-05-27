package pages;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchInventoryPage  extends BasePage{
    AppiumDriver appiumDriver;

    @FindBy(xpath="//android.widget.TextView[@text='Search Inventory']")
    private WebElement txtTitle;

    @FindBy(id="search_src_text")
    private WebElement txtSearch;

    @FindBy(id="tvModelNumber")
    private WebElement tvModelNumber;

    @FindBy(id="tvModelNumber")
    private List<WebElement> tvModelNumbers;

    public SearchInventoryPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void enterSearchText(String searhInput){
        txtSearch.sendKeys(searhInput);
    }

    public void verifySearchResult(String searhInput){
        for (WebElement result:tvModelNumbers){
            Assert.assertTrue(result.getText().equals(searhInput));
        }
    }
}
