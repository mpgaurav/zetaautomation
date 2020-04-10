package Tests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCuisinesTest extends BaseTest {

    String cuisineURI = "api/v2.1/cuisines?city_id=4";

    /*
   Verify if Bengaluru city has hotels with 107 different  cuisines
    */
    @Test
    public void verifyCuisinesInACityTest() {
        Response response = requestBuilder.getRequestResponse(httpRequest,cuisineURI);
        Assert.assertEquals(200, response.getStatusCode());
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        JSONArray jsonArray1 = responseJSONObject.getJSONArray("cuisines");
        Assert.assertEquals(107, jsonArray1.length());
    }


    /*
    Verify if Bengaluru city has hotels with Mangalorean cuisines
     */

    @Test
    public void voidTest2() {
        Response response =requestBuilder.getRequestResponse(httpRequest,cuisineURI);
        Assert.assertEquals(200, response.getStatusCode());
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        JSONArray jsonArray1 = responseJSONObject.getJSONArray("cuisines");
        Assert.assertTrue(jsonArray1.toString().contains("Mangalorean"));
    }
}
