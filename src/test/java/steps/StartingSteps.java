package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StartingSteps extends BaseSteps{

    private AppiumDriverLocalService appiumService;

    @Before
    public void startAppiumServer() throws IOException {
        int port = 4723;
        String nodeJS_Path = "C:/Program Files/NodeJS/node.exe";
        String appiumJS_Path = "C:/Users/AppData/Roaming/npm/node_modules/appium/lib/appium.js";

        String osName = System.getProperty("os.name");

        if(osName.contains("Mac")) {


            appiumService = AppiumDriverLocalService.buildService(new
                    AppiumServiceBuilder()
                    .usingDriverExecutable(new File("/usr/local/bin/node"))
                    .withAppiumJS(new File("/usr/local/bin/appium"))
                    .withIPAddress("0.0.0.0")
                    .usingPort(port)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withLogFile(new File("build/appium.log"))
            );
        } else {
            appiumService = AppiumDriverLocalService.buildService(new
                    AppiumServiceBuilder()
                    .usingDriverExecutable(new File(nodeJS_Path))
                    .withAppiumJS(new File(appiumJS_Path))
                    .withIPAddress("0.0.0.0")
                    .usingPort(port)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withLogFile(new File("build/appium.log"))
            );
        }
        appiumService.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("deviceName", "S7");
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("noReset", false);
        /*capabilities.setCapability("fullReset", true);
        capabilities.setCapability("app", "/Users/darora/eclipse-workspace/HelloAppium/app/METOpenLink-naStage-internalRelease.apk");*/
        capabilities.setCapability("appPackage", "com.milwaukeetool.mymilwaukee_STAGE");
        capabilities.setCapability("appActivity", "com.milwaukeetool.mymilwaukee.activity.RouterActivity");

        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        // appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @After
    public  void stopAppiumServer(Scenario scenario){
        try {
            if (scenario.isFailed()) {
                final byte[] screenShot = appiumDriver.getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            }
            appiumDriver.quit();
            appiumService.stop();
        } catch (Exception e){
            System.out.println("Exception while running Tear down: " + e.getMessage());
        }
    }
}
