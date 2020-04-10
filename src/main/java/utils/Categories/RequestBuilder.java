package utils.Categories;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {
    RequestSpecification httpRequest;

    public io.restassured.response.Response getRequestResponse(RequestSpecification requestSpecification, String uRI){
        Response response=requestSpecification.get(uRI);
        return response;


    }
}
