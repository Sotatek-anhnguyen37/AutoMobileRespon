package api;

import base.BaseAPI;
import base.Task;
import contants.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskAPI extends BaseAPI {
    @Test
    public List<Task> GetTaskList() {
        List<Task> taskList = new ArrayList<>();
        Response response = sendGetAll(Common.URL_GETALL_TASK);
        List<String> listContent = response.jsonPath().getList("content");
        List<String> listId = response.jsonPath().getList("id");
        for (int i = 0; i < listId.size(); i++) {
            Task ct = new Task();
            ct.setContent(listContent.get(i));
            ct.setId(listId.get(i));
            taskList.add(ct);
        }
        return taskList;
    }

    @Test
    public void VerifyTask(int random) {
        List<Task> ls = GetTaskList();
        for (Task ct : ls) {
            try {
                Assert.assertEquals(ct.getContent(), Common.TITLE_TASK + random);
                System.out.println("Verify task success");
            } catch (Exception e) {
                continue;
            }
        }
    }

    public String GetTaskId(String taskName) {
        String id = null;
        List<Task> tls = GetTaskList();
        for (Task t : tls) {
            if (t.getContent() == taskName) {
                id = t.getId();
            }
        }
        return id;
    }

    public void ReOpenTask(String taskName) {
        String id = GetTaskId(taskName);
        String link = getDynamicLink(Common.URL_REOPEN, id);

    }
}
