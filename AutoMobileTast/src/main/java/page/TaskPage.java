package page;

import base.BasePage;
import contants.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@text=\"Baymax\"]")
    private WebElement project;
    @FindBy(id = "com.todoist:id/fab")
    private WebElement plus;
    @FindBy(id = "android:id/message")
    private WebElement titleTask;
    @FindBy(id = "com.todoist:id/description")
    private WebElement descriptionTask;

    @FindBy(id = "android:id/button1")
    private WebElement submitTask;

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public void CreateTask(int radom) throws InterruptedException {
        Thread.sleep(3000);
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, Common.TITLE_TASK + radom);
        sendKeyElement(descriptionTask, Common.DESCRIPTION_TASK+radom);
        clickElement(submitTask);
    }
}
