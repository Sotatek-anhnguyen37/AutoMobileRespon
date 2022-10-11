package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Menu']")
    private WebElement menu;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.todoist:id/name\"])[last()]")
    private WebElement project;
    @FindBy(id = "com.todoist:id/btn_welcome_email")
    private WebElement continueEmail;
    @FindBy(id = "com.todoist:id/email_exists_input")
    private WebElement textBoxEmail;
    @FindBy(id = "com.todoist:id/btn_continue_with_email")
    private WebElement continueWithEmail;
    @FindBy(xpath = "//android.widget.EditText")
    private WebElement textBoxPassword;
    @FindBy(id = "com.todoist:id/btn_log_in")
    private WebElement logIn;

    public void login(String email, String passWord) throws InterruptedException {
        clickElement(continueEmail);
        sendKeyElement(textBoxEmail, email);
        clickElement(continueWithEmail);
        Thread.sleep(3000);
        sendKeyElement(textBoxPassword, passWord);
        clickElement(logIn);
        Thread.sleep(3000);
        clickElement(menu);
    }

    public void verifyProject(String nameProject) throws InterruptedException {
        Thread.sleep(3000);
        String nameProjectActual = project.getText();
        Assert.assertEquals(nameProjectActual, nameProject);
        System.out.println("Verify project success");
    }
}
