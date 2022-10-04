package page;

import base.BasePage;
import contants.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage {

    public TaskPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.widget.RelativeLayout[last()]")
    private WebElement project;

    @FindBy(id = "com.todoist:id/fab")
    private WebElement plus;
    @FindBy(id = "android:id/message")
    private WebElement titleTask;
    @FindBy(id = "com.todoist:id/description")
    private WebElement descriptionTask;

    @FindBy(id = "android:id/button1")
    private WebElement submitTask;

    @FindBy(id = "com.todoist:id/empty_content")
    private WebElement exit;

    public void CreateTask(){
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, Common.TITLE_TASK);
        sendKeyElement(descriptionTask, Common.DESCRIPTION_TASK);
        clickElement(submitTask);
        clickElement(exit);
    }
}
