package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueEmail(){
        clickElement(continueEmail);
    }
    public void sendKeyEmailTextBox(String value){
        sendKeyElement(textBoxEmail, value);
    }
    public void clickContinueWithEmail() throws InterruptedException {
        clickElement(continueWithEmail);
        Thread.sleep(3000);
    }
    public void sendKeyTextPassWord(String value){
        sendKeyElement(textBoxPassword, value);
    }
    public void clickLogin() throws InterruptedException {
        clickElement(logIn);
        Thread.sleep(5000);
    }
}
