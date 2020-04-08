import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    public String baseURI="https://developers.zomato.com";
    private String authKey="";
    public RequestSpecification httpRequest;
    /*
    Important Note : while running the tests system property key needs to be set
     */
    @BeforeTest(alwaysRun = true)
    public void testSetup(){
      //  authKey=System.getProperty("key");
        authKey="4bd8b592e55054458e37c284ae9459f1";
        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("user-key", authKey);

    }



}
