package pages;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BasePage {
    protected RequestSpecification request;
    protected Response response;
    protected final String BASE_URL = "https://api.trello.com/1";
    protected final String API_KEY = System.getenv("TRELLO_API_KEY");
    protected final String API_TOKEN = System.getenv("TRELLO_API_TOKEN");

    public BasePage() {
        request = given()
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN);
    }

    protected Response getResponse() {
        return response;
    }

    protected RequestSpecification getRequest() {
        return request;
    }
} 