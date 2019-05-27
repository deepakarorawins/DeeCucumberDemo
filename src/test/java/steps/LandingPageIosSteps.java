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

public class LandingPageIosSteps {

    private AppiumDriver appiumDriver;

    @Given("I Launch the ios app")
    public void iLaunchTheIosApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "12.2");
        capabilities.setCapability("deviceName", "iPhone8");
        capabilities.setCapability("bundleId", "com.milwaukeetool.mymilwaukee");
        capabilities.setCapability("udid", "47e6fe1aa853fe09952ce33191caa82ed690f2e7");

        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);



    }

    @And("I click on SignIn ios")
    public void iClickOnSignInIos() {
        appiumDriver.findElement(By.id("SignInButton")).click();
        System.out.println("Clicked on Sign In");
    }

    @And("I enter username ios {string}")
    public void iEnterUsernameIos(String email) {
        appiumDriver.findElement(By.id("email_text_field")).sendKeys(email);
        System.out.println("Entered username");

    }

    @And("I enter password ios {string}")
    public void iEnterPasswordIos(String password) {
        appiumDriver.findElement(By.id("password_text_field")).sendKeys(password);
        System.out.println("Entered password");

    }

    @And("I click on SignIn Button ios")
    public void iClickOnSignInButtonIos() {
        appiumDriver.findElement(By.id("login_button")).click();
        System.out.println("Clicked on Sign In Button");

    }

    @Then("I see inventory screen ios {string}")
    public void iSeeInventoryScreenIos(String expected) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("Inventory screen is displayed", expected, appiumDriver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Inventory\"]")).getAttribute("name"));
        System.out.println("Verified Inventory screen by title");
    }
}
