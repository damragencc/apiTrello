package services;

import config.TrelloConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BoardPluginService {
    
    public Response getEnabledPowerUps(String boardId) {
        return given()
                .spec(TrelloConfig.requestSpecification())
                .when()
                .get("/boards/" + boardId + "/boardPlugins")
                .then()
                .extract()
                .response();
    }

    public Response enablePowerUp(String boardId, String idPlugin) {
        return given()
                .spec(TrelloConfig.requestSpecification())
                .queryParam("idPlugin", idPlugin)
                .when()
                .post("/boards/" + boardId + "/boardPlugins")
                .then()
                .extract()
                .response();
    }

    public Response disablePowerUp(String boardId, String idPlugin) {
        return given()
                .spec(TrelloConfig.requestSpecification())
                .when()
                .delete("/boards/" + boardId + "/boardPlugins/" + idPlugin)
                .then()
                .extract()
                .response();
    }

    public Response getPowerUps(String boardId) {
        return given()
                .spec(TrelloConfig.requestSpecification())
                .when()
                .get("/boards/" + boardId + "/plugins")
                .then()
                .extract()
                .response();
    }
} 