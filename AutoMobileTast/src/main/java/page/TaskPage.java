package page;

import base.BasePage;
import contants.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.TableHeaderUI;

public class TaskPage extends BasePage {

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
    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public int Radom(){
        int radom = (int) Math.floor((Math.random() * 9 )) + 1;
        return radom;
    }

    public void CreateTask() throws InterruptedException {
        int radom = setRandom(Radom());
        String titleTask_Random = Common.TITLE_TASK + radom;
        Thread.sleep(3000);
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, titleTask_Random);
        sendKeyElement(descriptionTask, Common.DESCRIPTION_TASK);
        clickElement(submitTask);
    }
}
