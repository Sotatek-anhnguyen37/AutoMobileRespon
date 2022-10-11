package api;

import base.BaseAPI;
import io.restassured.response.ResponseBody;
import object.Project;
import object.Task;
import contants.EndPoint;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TaskAPI extends BaseAPI {

    public List<Task> getTaskList(String token) {
        List<Task> taskList = new ArrayList<>();
        Response response = sendGetAll(EndPoint.URL_GETALL_TASK, token);
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

    public void verifyTask(String nameTask, String token) {
        List<Task> ls = getTaskList(token);
        for (Task ct : ls) {
            try {
                Assert.assertEquals(ct.getContent(), nameTask);
                System.out.println("Verify task success");
            } catch (Exception e) {
                continue;
            }
        }
    }

    public String getTaskId(String taskName, String token) {
        String id = "";
        List<Task> tls = getTaskList(token);
        System.out.println("tls: "+tls);
        for (Task t : tls) {
            if (t.getContent().equals(taskName)) {
                id = t.getId();
            }
        }
        return id;
    }

    public void reOpenTask(String id, String token) {
        String link = String.format(EndPoint.URL_REOPEN, id);
        System.out.println("link reopen :" + link);
        sendReOpen(link, token);
    }
}
