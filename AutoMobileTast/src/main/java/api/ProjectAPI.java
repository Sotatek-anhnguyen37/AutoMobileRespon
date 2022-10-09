package api;

import base.BaseAPI;
import com.google.gson.JsonObject;
import object.Project;
import contants.Link;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProjectAPI extends BaseAPI {
    public void CreateProject(String nameProject, String token) throws InterruptedException {
        sendPost(Link.URL_CREATE_PRO, nameProject, token);
    }
    public void DeleteProject(String id, String token){
        String link = getDynamicLink(Link.URL_DELETE_PROJECT, id);
        sendDelete(link, token);
    }
    public List<Project> GetProjectList(String token) {
        List<Project> projectList = new ArrayList<>();
        Response response = sendGetAll(Link.URL_GETALL_PROJECT, token);
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
    public String GetProjectId(String projectName, String token) {
        String id = "";
        List<Project> pls = GetProjectList(token);
        for (Project p : pls) {
            if (p.getName().equals(projectName)) {
                id = p.getId();
            }
        }
        return id;
    }
}
