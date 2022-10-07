package test;

import api.ProjectAPI;
import api.TaskAPI;
import base.BaseSetUp;
import contants.Common;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProjectPage;
import page.TaskPage;
import random.RandomNumber;

import java.net.MalformedURLException;

public class TestAll extends BaseSetUp {
    private int random = RandomNumber.randomNumber();
    private int random2 = RandomNumber.randomNumber();
    private String id = "";

    @BeforeClass
    public void OpenApp() throws MalformedURLException {
        LaunchApp();
    }

    @Test(priority = 0)
    public void CreateProject() throws InterruptedException {
        ProjectAPI projectAPI = new ProjectAPI();
        ProjectPage projectPage = new ProjectPage(getAndroidDriver());

        projectAPI.CreateProject();
        projectPage.Login();
    }
    @Test(priority = 1)
    public void VerifyProject() throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(getAndroidDriver());
        projectPage.VerifyProject();
    }

    @Test(priority = 2)
    public void CreateTask() throws InterruptedException {
        TaskPage taskPage = new TaskPage(getAndroidDriver());
        taskPage.CreateTask(random);
    }

    @Test(priority = 3)
    public void VerifyTask() {
        TaskAPI taskAPI = new TaskAPI();
        taskAPI.VerifyTask(random);
    }

    @Test(priority = 4)
    public void ReOpen() throws MalformedURLException, InterruptedException {
        LaunchApp();
        ProjectPage projectPage = new ProjectPage(getAndroidDriver());
        TaskPage taskPage = new TaskPage(getAndroidDriver());
        TaskAPI taskAPI = new TaskAPI();

        projectPage.Login();
        taskPage.CreateTask2(random2);
        id = taskAPI.GetTaskId(Common.TITLE_TASK + random2);
        taskPage.CompleteTask(random2);
        taskAPI.ReOpenTask(id);
        LaunchApp();
        projectPage.Login();
        taskPage.VerifyTask2(random2);
    }
    @AfterClass
    public void After(){

    }
}
