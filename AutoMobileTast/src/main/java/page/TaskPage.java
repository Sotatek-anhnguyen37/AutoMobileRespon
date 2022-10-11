package page;

import base.BasePage;
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

    public void clickPlus(){
        clickElement(plus);
    }
    public void sendKeyTitleTask(String value){
        sendKeyElement(titleTask, value);
    }
    public void sendKeyDescriptionTask(String value){
        sendKeyElement(descriptionTask, value);
    }
    public void clickSubmitTask() throws InterruptedException {
        clickElement(submitTask);
        Thread.sleep(5000);
    }
    public void createTask(String nameTask, String description) throws InterruptedException {
        clickElement(project);
        clickElement(plus);
        sendKeyElement(titleTask, nameTask);
        sendKeyElement(descriptionTask, description);
        clickElement(submitTask);
        Thread.sleep(5000);
    }

    public void clickExit(){
        clickElement(exit);
    }
    public void completeTask(String nameTask2) throws InterruptedException {
        String xpathCheckBoxTask1 = String.format(xpathCheckBoxTask, nameTask2);
        clickElement(getDriver().findElement(By.xpath(xpathCheckBoxTask1)));
        Thread.sleep(5000);
    }

    public void verifyTask2(String nameTask2) throws InterruptedException {
        clickElement(project);
        String xpathNameTask2 = String.format(xpathNameTask, nameTask2);
        WebElement taskNameActual = getDriver().findElement(By.xpath(xpathNameTask2));
        Assert.assertTrue(taskNameActual.isDisplayed(), "Verify task2 successful");
    }
}
