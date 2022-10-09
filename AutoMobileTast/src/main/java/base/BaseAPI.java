package base;

import contants.Link;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BaseAPI {
    public String getDynamicLink(String link, String id) {
        link = String.format(link, id);
        return link;
    }

    public void sendPost(String link, String nameProject, String token) {
        JSONObject request = new JSONObject();
        request.put("name", nameProject );
        HashMap<String, Object> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Bearer " + token);
        given()
                .headers(header)
                .body(request)
                .when()
                .post(link)
                .then()
                .statusCode(200);
    }

    public Response sendGetAll(String link, String token) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);
        Response response = given()
                .headers(header)
                .when()
                .get(link)
                .then()
                .statusCode(200).extract().response();
        return response;
    }

    public void sendReOpen(String link, String token) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);
        given()
                .headers(header)
                .when()
                .post(link)
                .then()
                .statusCode(204).extract().response();
    }

    public void sendDelete(String link, String token) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);
        given()
                .headers(header)
                .when()
                .delete(link)
                .then()
                .statusCode(204).extract().response();
    }
}
