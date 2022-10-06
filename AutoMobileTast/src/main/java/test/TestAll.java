package test;

import api.ProjectAPI;
import api.TaskAPI;
import base.BaseSetUp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProjectPage;
import page.TaskPage;
import random.RandomNumber;

import java.net.MalformedURLException;

public class TestAll extends BaseSetUp {
    int random = RandomNumber.randomNumber();
    int random2 = RandomNumber.randomNumber();

    @BeforeClass
    public void OpenApp() throws MalformedURLException {
        LaunchApp();
    }

    @Test(priority = 0)
    public void CreateProject() throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(getAndroidDriver());
        projectPage.Login();
        ProjectAPI projectAPI = new ProjectAPI();
        projectAPI.CreateProject();
        projectPage.VerifyProject();
    }

    @Test(priority = 1)
    public void CreateTask() throws InterruptedException {
        TaskPage taskPage = new TaskPage(getAndroidDriver());
        taskPage.CreateTask(random);
        System.out.println("ramdom create task " + random);
    }

    @Test(priority = 2)
    public void VerifyTask() {
        TaskAPI taskAPI = new TaskAPI();
        taskAPI.VerifyTask(random);
        System.out.println("ramdom verify task " + random);
    }

    @Test(priority = 3)
    public void ReOpen() throws MalformedURLException, InterruptedException {
        LaunchApp();
        ProjectPage projectPage = new ProjectPage(getAndroidDriver());
        projectPage.Login();
        projectPage.OpenProject(random2);
    }
}
