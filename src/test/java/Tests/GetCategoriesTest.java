package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetCategoriesTest extends BaseTest {
    String categoriesURI = "/api/v2.1/categories";

    /*
    Test to verify if category count is 13
     */
    @Test()

    public void verifyCategoriesCount() {
        Response response = requestBuilder.getRequestResponse(httpRequest, categoriesURI);
        Assert.assertEquals(200, response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        List<String> categoryNames = jsonPath.getList("categories.categories");
        Assert.assertEquals(13, categoryNames.size());
    }

    /*
       Test to verify if category "Delivery is seen "
        */
    @Test()

    public void verifyRequiredCategoryIsSeen() {

        Response response = requestBuilder.getRequestResponse(httpRequest, categoriesURI);
        Assert.assertEquals(200, response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        List<String> categoryNames = jsonPath.getList("categories.categories.name");
        System.out.println(categoryNames);
        Assert.assertTrue(categoryNames.contains("Delivery"));

    }

    //TODO : Add more tests around location details
    @Test
    public void veerifyLocationDetails() {
//        Response response=httpRequest.get("")
    }
}
