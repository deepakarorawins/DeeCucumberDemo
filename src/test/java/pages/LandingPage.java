package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage  extends BasePage{
    AppiumDriver appiumDriver;

    @FindBy(id="btnGetStarted")
    private WebElement btnGetStarted;

    @FindBy(id="tvSignIn")
    private WebElement tvSignIn;

    public LandingPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver,this);
    }

    public void clickOnButtonGetStarted(){
        waitForElementToBeVisible(btnGetStarted);
        btnGetStarted.click();
    }

    public void clickOnTextViewSignIn(){
        waitForElementToBeVisible(tvSignIn);
        tvSignIn.click();
    }
}
