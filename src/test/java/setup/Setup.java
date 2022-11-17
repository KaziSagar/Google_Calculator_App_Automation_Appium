package setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setup {
    public static final String PACKAGE_ID = "com.google.android.calculator";
    public AndroidDriver driver;

    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "MyDevice");
        caps.setCapability("platformName", "Android");
        caps.setCapability("uuid", "ZY3227PBBN");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/calculator.apk");
        caps.setCapability("autoGrantPermissions", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                Utils utility=new Utils();
                utility.takeScreenShot(driver);
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }

        }

    }
    @AfterTest
    public void quitApp(){
        driver.quit();
    }


}