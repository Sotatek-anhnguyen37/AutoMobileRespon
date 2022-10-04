package test;

import api.ProjectAPI;
import base.BaseSetUp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProjectPage;

import java.net.MalformedURLException;

public class TestAll extends BaseSetUp {
    @BeforeClass
    public void OpenApp() throws MalformedURLException {
        LaunchApp();
    }
    @Test
    public void CreateProject() throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(getAndroidDriver());
        projectPage.OpenApp();
        ProjectAPI projectAPI = new ProjectAPI();
        projectAPI.CreateProject();
    }
}
