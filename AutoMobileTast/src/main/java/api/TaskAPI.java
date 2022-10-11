package api;

import base.BaseAPI;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.response.ResponseBody;
import object.Project;
import object.Task;
import contants.EndPoint;
import io.restassured.response.Response;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskAPI extends BaseAPI {

    public List<Task> getTaskList(String token) {
        Response response = sendGetAll(EndPoint.URL_GETALL_TASK, token);
        Type type = new TypeReference<List<Task>>(){}.getType();
        List<Task> taskList1 = response.getBody().as(type);
        return taskList1;
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
        for (Task t : tls) {
            if (t.getContent().equals(taskName)) {
                id = t.getId();
            }
        }
        return id;
    }

    public void reOpenTask(String id, String token) {
        String link = String.format(EndPoint.URL_REOPEN, id);
        sendReOpen(link, token);
    }
}
