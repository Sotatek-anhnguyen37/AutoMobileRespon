package page;

import base.BasePage;
import contants.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TaskPage extends BasePage {
    private String xpathCheckBoxTask = "//android.widget.RelativeLayout//android.widget.TextView[@text=\"%s\"]/preceding-sibling::*";
    private String xpathNameTask = "//android.widget.TextView[@text='%s']";
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Menu']")
    private WebElement menu;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.todoist:id/name\"])[last()]")
    private WebElement project;
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
    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private WebElement taskReopen;

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public void CreateTask(int radom) throws InterruptedException {
        Thread.sleep(3000);
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, Common.TITLE_TASK + radom);
        sendKeyElement(descriptionTask, Common.DESCRIPTION_TASK + radom);
        clickElement(submitTask);
        Thread.sleep(5000);
    }

    public void CreateTask2(int random2) throws InterruptedException {
        clickElement(menu);
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, Common.TITLE_TASK + random2);
        sendKeyElement(descriptionTask, Common.DESCRIPTION_TASK + random2);
        clickElement(submitTask);
        clickElement(exit);
        Thread.sleep(5000);
    }

    public void CompleteTask(int random2) throws InterruptedException {
        String xpathCheckBoxTask1 = getDynamicLink(xpathCheckBoxTask, Common.TITLE_TASK + random2);
        clickElement(getDriver().findElement(By.xpath(xpathCheckBoxTask1)));
        Thread.sleep(5000);
    }

    public void VerifyTask2(int random2) throws InterruptedException {
        clickElement(project);
        Thread.sleep(3000);
        String xpathNameTask2 = getDynamicLink(xpathNameTask, Common.TITLE_TASK + random2);
        WebElement taskNameActual = getDriver().findElement(By.xpath(xpathNameTask2));
        Assert.assertTrue(taskNameActual.isDisplayed(), "Verify task2 successful");
    }
}
