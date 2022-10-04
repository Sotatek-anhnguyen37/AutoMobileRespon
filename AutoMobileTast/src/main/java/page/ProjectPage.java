package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allow;
    @FindBy(id = "com.todoist:id/btn_google")
    private WebElement continueEmail;
    @FindBy(id = "com.google.android.gms:id/account_name")
    private WebElement email;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Menu']")
    private WebElement menu;

    @FindBy(xpath = "//android.widget.RelativeLayout[last()]")
    private WebElement project;

    public void OpenApp() throws InterruptedException {
        clickElement(allow);
        clickElement(continueEmail);
        clickElement(email);
        Thread.sleep(3000);
        clickElement(menu);
    }
}
