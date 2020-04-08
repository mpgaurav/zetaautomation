package Tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public String baseURI = "https://developers.zomato.com";
    private String authKey;
    public RequestSpecification httpRequest;

    /*
    Important Note : while running the tests system property key needs to be set
     */
    @BeforeClass(alwaysRun = true)
    public void testSetup() {
        authKey = System.getProperty("key");
        // authKey = "4bd8b592e55054458e37c284ae9459f1";
        RestAssured.baseURI = baseURI;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("user-key", authKey);

    }


    @AfterMethod
    public void print(ITestResult result){
        System.out.println("Finished test execution :"+result.getMethod().getMethodName());
    }
     /*
    Shut down http requests
    */

    @AfterSuite
    public void cleanUp() {
        httpRequest = null;
    }
}
