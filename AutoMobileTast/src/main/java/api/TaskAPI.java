package api;

import base.BaseAPI;
import base.Content;
import contants.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskAPI extends BaseAPI {
    @Test
    public List<String> GetIdTask() {
        List<Content> content = new ArrayList<>();
        Response response = sendGetAll(Common.URL_GETALL_TASK);
        List<String> listContent = response.jsonPath().getList("content");
        return listContent;
    }

    @Test
    public void VerifyTask(int random) {
        List<String> ls = GetIdTask();

        for (String ct : ls) {
            try {
                Assert.assertEquals(ct, Common.TITLE_TASK + random);
                System.out.println("Verify task success");
            } catch (Exception e) {
                continue;
            }
        }
    }
}
