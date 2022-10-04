package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSetUp {
    private AndroidDriver driver;
    public void LaunchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.todoist");
        capabilities.setCapability("appActivity","com.todoist.activity.HomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    public AndroidDriver getAndroidDriver() {
        return this.driver;
    }

}
