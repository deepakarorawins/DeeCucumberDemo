package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LandingPageSteps extends BaseSteps {

    @Given("I Launch the app")
    public void iLaunchTheApp() throws MalformedURLException {
        appiumDriver.findElement(By.id("tvSignIn")).isDisplayed();
    }

    @And("I click on SignIn")
    public void iClickOnSignIn() {
       new LandingPage(appiumDriver).clickOnTextViewSignIn();

    }


    @Then("I see sign in screen with email and password field {string}")
    public void iSeeSignInScreenWithEmailAndPasswordField(String expected) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("Email Address or Guest Username field is displayed", expected, appiumDriver.findElement(By.id("tvSignIn")).getText());
        System.out.println("Sign in screen is displayed");
    }


    @And("I enter username {string}")
    public void iEnterUsername(String userId) {
        new SignInPage(appiumDriver).enterUserId(userId);


    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        new SignInPage(appiumDriver).enterPassword(password);
    }

    @And("I click on SignIn Button")
    public void iClickOnSignInButton() {
        new SignInPage(appiumDriver).clickOnButtonSignIn();

    }

    @And("I navigateBack")
    public void iNavigateBack() throws InterruptedException {
       /* WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")));*/
        Thread.sleep(5*1000);
        Wait wait = new FluentWait(appiumDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")));

        appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
        System.out.println("Clicked on Sign In Button");
    }

    @Then("I see inventory screen {string}")
    public void iSeeInventoryScreen(String expected) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("Inventory screen is displayed", expected, appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Inventory']")).getText());
        System.out.println("Verified Inventory screen by title");
    }

    @And("I click on Add Item")
    public void iClickOnAddItem() {
        new InventoryPage(appiumDriver).clickOnTvAdd();

    }

    @And("I click on Other Items")
    public void iClickOnOtherItems() {
        new ChooseItemTypePage(appiumDriver).clickOnLlMenuOptionChooseOtherItem();
    }

    @And("I choose as manufacturer {string}")
    public void iChooseAsManufacturer(String manufacturer) {
       new ManufacturerPage(appiumDriver).selectManufacturer(manufacturer);
    }

    @And("I enter description {string}")
    public void iEnterDescription(String description) {
        new AddItemPage(appiumDriver).enterDescription(description);

    }

    @And("I enter model numbber {string}")
    public void iEnterModelNumbber(String modelNumber) {
       new AddItemPage(appiumDriver).enterModelNumber(modelNumber);
    }

    @And("I click on save")
    public void iClickOnSave() {
        new AddItemPage(appiumDriver).clickOnTvSave();
    }

    @Then("I should see tool added to inventory {string}")
    public void iShouldSeeToolAddedToInventory(String searchInput) {
        new InventoryPage(appiumDriver).verifyToolAdded(searchInput);
    }

    /*@And("I click on turn on location")
    public void iClickOnTurnOnLocation() {
        appiumDriver.findElement(By.id("btnEnableLocationAccess")).click();
    }

    @And("I click on allow")
    public void iClickOnAllow() {
        appiumDriver.findElement(By.id("permission_allow_button")).click();
    }*/
}
