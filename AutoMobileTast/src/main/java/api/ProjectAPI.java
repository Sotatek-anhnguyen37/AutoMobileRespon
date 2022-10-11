package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import object.Project;
import contants.EndPoint;
import io.restassured.response.Response;
import com.fasterxml.jackson.core.type.TypeReference;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectAPI extends BaseAPI {
    public void createProject(String nameProject, String token) throws InterruptedException {
        sendPost(EndPoint.URL_CREATE_PRO, nameProject, token);
    }

    public void deleteProject(String id, String token) {
        String link = String.format(EndPoint.URL_DELETE_PROJECT, id);
        sendDelete(link, token);
    }

    public List<Project> getProjectList(String token) {
        Response response = sendGetAll(EndPoint.URL_GETALL_PROJECT, token);
        Type type = new TypeReference<List<Project>>() {
        }.getType();
        List<Project> projectList1 = response.getBody().as(type);
        return projectList1;
    }

    public String getProjectId(String projectName, String token) {
        String id = "";
        List<Project> pls = getProjectList(token);
        for (Project p : pls) {
            if (p.getName().equals(projectName)) {
                id = p.getId();
            }
        }
        return id;
    }
}
