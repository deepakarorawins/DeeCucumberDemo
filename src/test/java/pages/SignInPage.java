package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

    AppiumDriver appiumDriver;
    @FindBy(id="inputEmail")
    private WebElement txtEmail;

    @FindBy(id="inputPassword")
    private WebElement txtPassword;

    @FindBy(id="signInButton")
    private WebElement btnSignIn;


    public SignInPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void enterUserId(String userId){
        txtEmail.sendKeys(userId);
    }

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickOnButtonSignIn(){
        waitForElementToBeVisible(btnSignIn);
        btnSignIn.click();
    }
}
