package Tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetCitiesTest extends BaseTest {
        String citiesURI="/api/v2.1/cities?q=Bengaluru";

    /*
    Verify if Bengaluru  is seen in location suggestions
     */
    @Test
    public void verifyCities() {
        Response response = httpRequest.get(citiesURI);
        List<String> respin = response.jsonPath().getList("location_suggestions");
        System.out.println(respin.size());
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(response.toString());
        Assert.assertTrue(response.getBody().prettyPrint().contains("Bengaluru"));
    }

    // TODO: Add more tests around cities .
}
