package base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private static final int TIME_OUT = 10;

    protected WebDriver driver = null;
    private WebDriverWait wait;
    private Actions action;

    private int radom;
    private static AndroidDriver<?> driver1;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public WebDriverWait getExplicitWait() {
        return wait;
    }

    public Actions getAction() {
        return action;
    }

    public WebDriver getDriver() {
        return driver;
    }
    public int setRandom(int ramdom){return radom;}

    public void clickElement(WebElement e) {
        getExplicitWait().until(ExpectedConditions.visibilityOfAllElements(e));
        e.click();
    }
    public void sendKeyElement(WebElement e, String key) {
        getExplicitWait().until(ExpectedConditions.visibilityOfAllElements(e));
        e.sendKeys(key);
    }
    public void tapToPosition(int x, int y){
        TouchAction action = new TouchAction(driver1);
        action.tap(TapOptions.tapOptions().withPosition(PointOption.point(x,y))).perform();
    }
}
