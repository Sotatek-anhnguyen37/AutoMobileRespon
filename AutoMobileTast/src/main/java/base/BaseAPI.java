package base;

import contants.Common;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.Response;
import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Objects;

public class BaseAPI {
    public String getDynamicLink(String link, String...values){
        return link;
    }
//    public Response sendPost(String link){
//        JSONObject request = new JSONObject();
//        request.put("name", "Baymax");
//        HashMap<String, Object> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        headers.put("Authorization", "Bearer " + Common.TOKEN);
//        Response response = (Response) given()
//                .headers(headers)
//                .body(request)
//                .when().post(link)
//                .then()
//                .statusCode(200).extract().response();
//        return response;
//    }
    public void sendPost(String link){
        JSONObject request = new JSONObject();
        request.put("name", "Baymax");
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + Common.TOKEN);
        given()
            .headers(headers)
            .body(request)
            .when()
                .post(link)
            .then()
                .statusCode(200);
    }
}
