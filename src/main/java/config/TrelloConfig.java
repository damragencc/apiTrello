package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TrelloConfig {
    public static final String API_TOKEN = "ATTA45c9255c624fc7247656544bb8830c9b9d90e0d8f4de069540d5ee1cbc400768525AF322";
    public static final String API_KEY = "a95297bf035bd7b70171a607f1c7486b";
    public static final String BASE_URL = "https://api.trello.com/1";

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addQueryParam("key", API_KEY)
                .addQueryParam("token", API_TOKEN)
                .build();
    }
}
