package page;

import base.BasePage;
import contants.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.annotation.concurrent.ThreadSafe;

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
    private WebElement passWord;
    @FindBy(id = "com.todoist:id/btn_log_in")
    private WebElement logIn;
    @FindBy(id = "com.todoist:id/fab")
    private WebElement plus;
    @FindBy(id = "android:id/message")
    private WebElement titleTask;
    @FindBy(xpath = "//android.widget.EditText[last()]")
    private WebElement descriptionTask;

    @FindBy(id = "android:id/button1")
    private WebElement submitTask;

    @FindBy(id = "com.todoist:id/quick_add_item_container")
    private WebElement exit;
    @FindBy(xpath = "")
    private WebElement task;

    @FindBy(id = "com.todoist:id/item_checkmark")
    private WebElement checkbox;

    public void Login() throws InterruptedException {
        Thread.sleep(5000);
        clickElement(continueEmail);
        sendKeyElement(textBoxEmail, Common.EMAIL);
        clickElement(continueWithEmail);
        Thread.sleep(5000);
        sendKeyElement(passWord, Common.PASSWORD);
        clickElement(logIn);
        Thread.sleep(10000);
        clickElement(menu);
    }

    public void VerifyProject() throws InterruptedException {
        String nameProjectActual = project.getText();
        Assert.assertEquals(nameProjectActual, "Baymax");
        System.out.println("Verify project success");
    }

    public void OpenProject(int random2) {
        String xpathTask = "//android.widget.RelativeLayout//android.widget.TextView[@text=\"%s\"]/preceding-sibling::*";
        String xpathTask2 = getDynamicLink(xpathTask,Common.TITLE_TASK+random2);
        clickElement(menu);
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, Common.TITLE_TASK + random2);
        sendKeyElement(descriptionTask, Common.DESCRIPTION_TASK + random2);
        clickElement(submitTask);
        clickElement(exit);
        clickElement(getDriver().findElement(By.xpath(xpathTask2)));
    }
}
