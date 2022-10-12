package api;

import base.BaseAPI;
import object.Project;
import contants.EndPoint;
import io.restassured.response.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import org.json.simple.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class ProjectAPI extends BaseAPI {
    public void createProject(String nameProject){
        JSONObject request = new JSONObject();
        request.put("name", nameProject);
        sendPost(EndPoint.URL_CREATE_PRO, request).then().statusCode(200).extract().response();
    }

    public void deleteProject(String id) {
        String link = String.format(EndPoint.URL_DELETE_PROJECT, id);
        sendDelete(link).then().statusCode(204).extract().response();
    }

    public List<Project> getProjectList() {
        Response response = sendGet(EndPoint.URL_GETALL_PROJECT);
        Type type = new TypeReference<List<Project>>() {
        }.getType();
        List<Project> projectList1 = response.getBody().as(type);
        return projectList1;
    }

    public String getProjectId(String projectName) {
        String id = "";
        List<Project> pls = getProjectList();
        for (Project p : pls) {
            if (p.getName().equals(projectName)) {
                id = p.getId();
            }
        }
        return id;
    }
}
