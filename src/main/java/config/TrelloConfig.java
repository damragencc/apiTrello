package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TrelloConfig {
    private static final Properties properties = new Properties();
    public static final String BASE_URL = "https://api.trello.com/1";
    public static String API_KEY;
    public static String API_TOKEN;

    static {
        try {
            // Önce config.properties'i dene
            String configPath = "src/test/resources/config.properties";
            FileInputStream input = new FileInputStream(configPath);
            properties.load(input);
            
            API_KEY = properties.getProperty("trello.api.key");
            API_TOKEN = properties.getProperty("trello.api.token");
            
        } catch (IOException e) {
            System.out.println("Config file not found. Please create config.properties file from config.properties.example");
            e.printStackTrace();
        }
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addQueryParam("key", API_KEY)
                .addQueryParam("token", API_TOKEN)
                .build();
    }
}
