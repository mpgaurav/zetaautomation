package Tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Categories.RequestBuilder;

public class BaseTest {

    //Fetch the server IP from config.properties file
    public String baseURI = "https://developers.zomato.com";
    private String authKey;
    public RequestSpecification httpRequest;
    public RequestBuilder requestBuilder = new RequestBuilder();

    /*
    Important Note : while running the tests system property key needs to be set
     */
    @BeforeClass(alwaysRun = true)
    public void testSetup() {
        authKey = System.getProperty("key");
        if (authKey.length() < 5) {
            System.out.println("Auth key entered is null or invalid Pls check the Auth  key !!!");
        }

        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("user-key", authKey);

    }

    @BeforeMethod
    public void beforeTest(ITestResult result){
        System.out.println("Starting test execution :" + result.getMethod().getMethodName());
    }

    @AfterMethod
    public void print(ITestResult result) {

        System.out.println("Finished test execution :" + result.getMethod().getMethodName());
    }
     /*
    Shut down http requests
    */

    @AfterSuite
    public void cleanUp(ITestContext iTestContext)
    {
        System.out.println("Successfully completed "+iTestContext.getSuite().getName()+" suite execution");
        httpRequest = null;
    }
}
