package api;

import base.BaseAPI;
import contants.Common;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import contants.Common;

public class ProjectAPI extends BaseAPI {
    public void CreateProject() throws InterruptedException {
        sendPost(Common.URL_CREATE_PRO);
        Thread.sleep(7000);
    }
}
