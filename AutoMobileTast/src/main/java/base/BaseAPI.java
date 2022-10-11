package base;

import contants.EndPoint;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BaseAPI {
    public Response sendPost(String link, JSONObject request) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Bearer " + EndPoint.TOKEN);
        Response response = given()
                .headers(header)
                .body(request)
                .when()
                .post(link);
        return response;
    }
    public Response sendPost(String link) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Bearer " + EndPoint.TOKEN);
        Response response = given()
                .headers(header)
                .when()
                .post(link);
        return response;
    }

    public Response sendGet(String link) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer " + EndPoint.TOKEN);
        Response response = given()
                .headers(header)
                .when()
                .get(link);
        return response;
    }


    public Response sendDelete(String link) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer " + EndPoint.TOKEN);
        Response response = given()
                .headers(header)
                .when()
                .delete(link);

        return response;
    }
}
