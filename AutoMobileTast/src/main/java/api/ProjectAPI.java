package api;

import base.BaseAPI;
import io.restassured.response.ResponseBody;
import object.Project;
import contants.EndPoint;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectAPI extends BaseAPI {
    public void createProject(String nameProject, String token) throws InterruptedException {
        sendPost(EndPoint.URL_CREATE_PRO, nameProject, token);
    }
    public void deleteProject(String id, String token){
        String link = String.format(EndPoint.URL_DELETE_PROJECT, id);
        sendDelete(link, token);
    }
    public List<Project> getProjectList(String token) {
        List<Project> projectList = new ArrayList<>();
        Response response = sendGetAll(EndPoint.URL_GETALL_PROJECT, token);
//        List<Project> projectList1 = Arrays.asList(response.getBody().as(Project[].class));
//        System.out.println(projectList1);
        List<String> listName = response.jsonPath().getList("name");
        List<String> listId = response.jsonPath().getList("id");
        for (int i = 0; i < listId.size(); i++) {
            Project pro = new Project();
            pro.setName(listName.get(i));
            pro.setId(listId.get(i));
            projectList.add(pro);
        }
        return projectList;
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
