package base;

import contants.Common;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Objects;

public class BaseAPI {
//    public String getDynamicLink(String link, String... id){
//        link = String.format(link, (Object[]) id);
//        return link;
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
    public Response sendGetAll(String link){
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer " + Common.TOKEN);
        Response response = given()
                .headers(header)
                .when()
                    .get(link)
                .then()
                    .statusCode(200).extract().response();
        return response;
    }
}
