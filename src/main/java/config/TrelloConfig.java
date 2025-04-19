package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TrelloConfig {
    // Test amaçlı kullanılacak dummy değerler
    public static final String API_TOKEN = "your-api-token";
    public static final String API_KEY = "your-api-key";
    public static final String BOARD_ID = "your-board-id";
    public static final String BASE_URL = "https://api.trello.com/1";

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addQueryParam("key", API_KEY)
                .addQueryParam("token", API_TOKEN)
                .build();
    }
}
