package test;

import api.ProjectAPI;
import api.TaskAPI;
import base.BaseSetUp;
import contants.EndPoint;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProjectPage;
import page.TaskPage;
import random.RandomNumber;

import java.net.MalformedURLException;

public class TestAll extends BaseSetUp {
    public static final String TITLE_TASK = "Exercise";
    public static final String DESCRIPTION_TASK = "8 steps warmup";
    public static final String EMAIL = "01112000hda@gmail.com";
    public static final String PASSWORD = "Baymax2000";
    public static final String NAME_PROJECT = "Daily Routine";
    private String nameTask = TITLE_TASK + RandomNumber.createRandomNumber();
    private String description = DESCRIPTION_TASK + RandomNumber.createRandomNumber();
    private String nameTask2 = TITLE_TASK + RandomNumber.createRandomNumber();
    private String description2 = DESCRIPTION_TASK + RandomNumber.createRandomNumber();
    private String idTask2 = "";
    private String idProject = "";


    @BeforeClass
    public void openApp() throws MalformedURLException {
        launchApp();
    }

    @Test
    public void autoMobileTest() throws InterruptedException, MalformedURLException {
        ProjectAPI projectAPI = new ProjectAPI();
        ProjectPage projectPage = new ProjectPage(getAndroidDriver());
        TaskPage taskPage = new TaskPage(getAndroidDriver());
        TaskAPI taskAPI = new TaskAPI();
        LoginPage loginPage = new LoginPage(getAndroidDriver());

        projectAPI.createProject(NAME_PROJECT);
        loginPage.clickContinueEmailButton();
        loginPage.sendKeyEmailTextBox(EMAIL);
        loginPage.clickContinueWithEmailButton();
        loginPage.sendKeyTextPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectPage.clickMenuButton();
        projectPage.verifyProject(NAME_PROJECT);

        projectPage.clickOnProject();
        taskPage.clickQuickAddButton();
        taskPage.sendKeyTitleTask(nameTask);
        taskPage.sendKeyDescriptionTask(description);
        taskPage.clickSubmitTaskButton();
        taskAPI.verifyTask(nameTask);

        launchApp();
        loginPage.clickContinueEmailButton();
        loginPage.sendKeyEmailTextBox(EMAIL);
        loginPage.clickContinueWithEmailButton();
        loginPage.sendKeyTextPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectPage.clickMenuButton();

        projectPage.clickOnProject();
        taskPage.clickQuickAddButton();
        taskPage.sendKeyTitleTask(nameTask2);
        taskPage.sendKeyDescriptionTask(description2);
        taskPage.clickSubmitTaskButton();

        idTask2 = taskAPI.getTaskId(nameTask2);
        taskPage.clickOnTask();
        taskPage.completeTask(nameTask2);
        taskAPI.reopenTask(idTask2);
        taskPage.verifyTask(nameTask2);
    }

    @AfterClass
    public void after() {
        ProjectAPI projectAPI = new ProjectAPI();
        idProject = projectAPI.getProjectId(NAME_PROJECT);
        projectAPI.deleteProject(idProject);
        getAndroidDriver().quit();
    }
}
