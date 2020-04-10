package Tests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCategoriesTest extends BaseTest {
    String categoriesURI = "/api/v2.1/categories";

    /*
    Test to verify if category count is 13
     */
    @Test()

    public void verifyCategoriesCount() {
        Response response=requestBuilder.getRequestResponse(httpRequest,categoriesURI);
        Assert.assertEquals(200, response.getStatusCode());
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        JSONArray jsonArray = responseJSONObject.getJSONArray("categories");
        Assert.assertEquals(13, jsonArray.length());
    }

    /*
       Test to verify if category "Delivery is seen "
        */
    @Test()

    public void verifyRequiredCategoryIsSeen() {

        Response response = requestBuilder.getRequestResponse(httpRequest,categoriesURI);
        Assert.assertEquals(200, response.getStatusCode());
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        JSONArray jsonArray = responseJSONObject.getJSONArray("categories");
        Assert.assertTrue(jsonArray.toString().contains("Delivery"));

    }

    //TODO : Add more tests around location details
    @Test
    public void veerifyLocationDetails() {
//        Response response=httpRequest.get("")
    }
}
