import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetCategoriesTest extends BaseTest {


    /*
    Test to verify if category count is 13
     */
    @Test()

    public void verifyCategoriesCount() {

        Response response = httpRequest.get("/api/v2.1/categories");
        Assert.assertEquals(200, response.getStatusCode());
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        JSONArray jsonArray1 = responseJSONObject.getJSONArray("categories");
        System.out.println(jsonArray1.length());


    }

    /*
       Test to verify if category "Delivery is seen "
        */
    @Test()

    public void verifyRequiredCategoryIsSeen() {

        Response response = httpRequest.get("/api/v2.1/categories");
        Assert.assertEquals(200, response.getStatusCode());
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        JSONArray jsonArray1 = responseJSONObject.getJSONArray("categories");
        Assert.assertTrue(jsonArray1.toString().contains("Delivery"));

    }


    @Test
    public void veerifyLocationDetails() {
//        Response response=httpRequest.get("")
    }
}
