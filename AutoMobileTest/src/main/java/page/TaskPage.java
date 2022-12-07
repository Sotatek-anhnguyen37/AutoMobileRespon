package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage {
    private String xpathCheckBoxTask = "//android.widget.RelativeLayout//android.widget.TextView[@text=\"%s\"]/preceding-sibling::*";
    private String xpathNameTask = "//android.widget.TextView[@text='%s']";
    @FindBy(id = "com.todoist:id/fab")
    private WebElement quickAdd;
    @FindBy(id = "android:id/message")
    private WebElement titleTask;
    @FindBy(xpath = "//android.widget.EditText[last()]")
    private WebElement descriptionTask;
    @FindBy(id = "android:id/button1")
    private WebElement submitTask;
    @FindBy(xpath = "(//android.widget.RelativeLayout)[last()]")
    private WebElement task;

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public void clickQuickAddButton() {
        clickElement(quickAdd);
    }

    public void sendKeyTitleTask(String value) {
        sendKeyElement(titleTask, value);
    }

    public void sendKeyDescriptionTask(String value) {
        sendKeyElement(descriptionTask, value);
    }

    public void clickSubmitTaskButton() throws InterruptedException {
        clickElement(submitTask);
        Thread.sleep(3000);
    }

    public void clickOnTask() {
        clickElement(task);
    }

    public void completeTask(String nameTask2) throws InterruptedException {
        String xpathCheckBoxTask2 = String.format(xpathCheckBoxTask, nameTask2);
        clickElement(getDriver().findElement(By.xpath(xpathCheckBoxTask2)));
        Thread.sleep(5000);
    }

    public void verifyTask(String nameTask2) {
        String xpathNameTask2 = String.format(xpathNameTask, nameTask2);
        clickElement(getDriver().findElement(By.xpath(xpathNameTask2)));
        System.out.println("Verify task successful");
    }
}
