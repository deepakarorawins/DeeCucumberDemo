package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private AppiumDriver appiumDriver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.appiumDriver = driver;
        wait = new WebDriverWait(this.appiumDriver, 30);
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
