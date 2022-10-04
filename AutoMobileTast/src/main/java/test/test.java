package test;

import org.json.simple.JSONObject;
import org.openqa.selenium.remote.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class test {
    @Test
    public void testapi(){
        HashMap<String, Object> headers = new HashMap<>();
        JSONObject request = new JSONObject();
        request.put("name","baymax2000");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + "4a39a859ac9f2b7d2e7a15be84f6045559c392e2");
        given()
            .headers(headers)
            .body(request)
            .when().post("https://api.todoist.com/rest/v2/projects")
                .then()
                .statusCode(200).extract().response();
    }
}
