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

    public void clickMenu(){
        clickElement(menu);
    }

    public void clickProject(){
        clickElement(project);
    }

    public void verifyProject(String nameProject) throws InterruptedException {
        Thread.sleep(3000);
        String nameProjectActual = project.getText();
        Assert.assertEquals(nameProjectActual, nameProject);
        System.out.println("Verify project success");
    }
}
