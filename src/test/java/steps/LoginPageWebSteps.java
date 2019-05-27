package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginPageWebSteps {

    private AppiumDriver appiumDriver;

    @Given("I Launch the mobile web")
    public void iLaunchTheMobileWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "S7");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("appActivity", "com.milwaukeetool.mymilwaukee.activity.RouterActivity");

        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        appiumDriver.get("https://onekeystaging.milwaukeetool.com");
    }

    @And("I enter username web {string}")
    public void iEnterUsernameWeb(String email) {
        appiumDriver.findElement(By.name("email")).sendKeys(email);
        System.out.println("Entered username");
    }

    @And("I enter password web {string}")
    public void iEnterPasswordWeb(String password) {
        appiumDriver.findElement(By.name("password")).sendKeys(password);
        System.out.println("Entered password");

    }

    @And("I click on LogIn web")
    public void iClickOnLogInWeb() {
        appiumDriver.findElement(By.name("submit")).click();
        System.out.println("Clicked on Log In");

    }

    @Then("I see inventory screen  web")
    public void iSeeInventoryScreenWeb() throws InterruptedException {
        Thread.sleep(10*1000);
        Assert.assertTrue(appiumDriver.findElement(By.xpath("//a[@href='/add-place-options/']")).isDisplayed());
        System.out.println("Verified Inventory screen by title");
    }
}


/*Scenario: Login with correct username and password via web
        As a user I should be able to login successfully with valid username and password via web

        Given I Launch the mobile web
        And I enter username web "deemet@mailinator.com"
        And I enter password web "miP4cvma"
        And I click on LogIn web
        Then I see inventory screen  web*/
