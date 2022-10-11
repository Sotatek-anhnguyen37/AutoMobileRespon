package test;

import api.ProjectAPI;
import api.TaskAPI;
import base.BaseSetUp;
import contants.EndPoint;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    private String nameTask = TITLE_TASK + RandomNumber.randomNumber();
    private String description = DESCRIPTION_TASK + RandomNumber.randomNumber();
    private String nameTask2 = TITLE_TASK + RandomNumber.randomNumber();
    private String description2 = DESCRIPTION_TASK + RandomNumber.randomNumber();
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

        projectAPI.createProject(NAME_PROJECT, EndPoint.TOKEN);
        projectPage.login(EMAIL, PASSWORD);
        projectPage.verifyProject(NAME_PROJECT);

        taskPage.createTask(nameTask, description);
        taskAPI.verifyTask(nameTask, EndPoint.TOKEN);

        launchApp();
        projectPage.login(EMAIL, PASSWORD);
        taskPage.createTask(nameTask2, description2);
        idTask2 = taskAPI.getTaskId(nameTask2, EndPoint.TOKEN);
        taskPage.completeTask(nameTask2);
        taskAPI.reOpenTask(idTask2, EndPoint.TOKEN);

        ProjectPage projectPage2 = new ProjectPage(getAndroidDriver());
        TaskPage taskPage2 = new TaskPage(getAndroidDriver());
        launchApp();

        projectPage2.login(EMAIL, PASSWORD);
        taskPage2.verifyTask2(nameTask2);
    }

    @AfterClass
    public void after(){
        ProjectAPI projectAPI = new ProjectAPI();
        idProject  = projectAPI.getProjectId(NAME_PROJECT, EndPoint.TOKEN);
        projectAPI.deleteProject(idProject, EndPoint.TOKEN);
        getAndroidDriver().quit();
    }
}
