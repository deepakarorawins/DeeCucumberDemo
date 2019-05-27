package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManufacturerPage extends BasePage {

    AppiumDriver appiumDriver;

    @FindBy(id="search_src_text")
    private WebElement txtSearch;

    @FindBy(id="element")
    private List<WebElement> tvFoundManufacturers;

    public ManufacturerPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void enterSearchText(String manufacturer){
        txtSearch.sendKeys(manufacturer);
    }

    public void selectManufacturer(String manufacturer) {
        enterSearchText(manufacturer);
        for(WebElement foundManufacturer: tvFoundManufacturers){
            if(foundManufacturer.getText().equals(manufacturer)){
                foundManufacturer.click();
                break;
            }
        }
    }

}
