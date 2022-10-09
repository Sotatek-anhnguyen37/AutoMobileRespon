package page;

import base.BasePage;
import contants.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TaskPage extends BasePage {
    private String xpathCheckBoxTask = "//android.widget.RelativeLayout//android.widget.TextView[@text=\"%s\"]/preceding-sibling::*";
    private String xpathNameTask = "//android.widget.TextView[@text='%s']";
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

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public void createTask(String nameTask, String description) throws InterruptedException {
        Thread.sleep(3000);
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, nameTask);
        sendKeyElement(descriptionTask, description);
        clickElement(submitTask);
        Thread.sleep(5000);
    }

    public void completeTask(String nameTask2) throws InterruptedException {
        clickElement(exit);
        Thread.sleep(5000);
        String xpathCheckBoxTask1 = getDynamicLink(xpathCheckBoxTask, nameTask2);
        clickElement(getDriver().findElement(By.xpath(xpathCheckBoxTask1)));
        Thread.sleep(5000);
    }

    public void verifyTask2(String nameTask2) throws InterruptedException {
        clickElement(project);
        Thread.sleep(1000);
        String xpathNameTask2 = getDynamicLink(xpathNameTask, nameTask2);
        WebElement taskNameActual = getDriver().findElement(By.xpath(xpathNameTask2));
        Assert.assertTrue(taskNameActual.isDisplayed(), "Verify task2 successful");
    }
}
