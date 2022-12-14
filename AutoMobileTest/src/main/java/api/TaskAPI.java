package api;

import base.BaseAPI;
import com.fasterxml.jackson.core.type.TypeReference;
import object.Task;
import contants.EndPoint;
import io.restassured.response.Response;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.List;

public class TaskAPI extends BaseAPI {

    public List<Task> getTaskList() {
        Response response = sendGet(EndPoint.URL_GET_ALL_TASK).then().statusCode(200).extract().response();
        Type type = new TypeReference<List<Task>>() {
        }.getType();
        List<Task> taskList1 = response.getBody().as(type);
        return taskList1;
    }

    public void verifyTask(String nameTask) {
        List<Task> ls = getTaskList();
        for (Task ct : ls) {
            Assert.assertEquals(ct.getContent(), nameTask);
            System.out.println("Verify task success");
        }
    }

    public String getTaskId(String taskName) {
        String id = "";
        List<Task> tls = getTaskList();
        for (Task t : tls) {
            if (t.getContent().equals(taskName)) {
                id = t.getId();
            }
        }
        return id;
    }

    public void reopenTask(String id) {
        String link = String.format(EndPoint.URL_REOPEN, id);
        sendPost(link).then().statusCode(204).extract().response();
    }
}
