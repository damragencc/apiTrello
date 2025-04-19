package services;

import config.TrelloConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BoardService {
    
    public Response updateShowSidebar(String boardId, boolean value) {
        return given()
                .queryParam("value", value)
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .put("https://api.trello.com/1/boards/" + boardId + "/myPrefs/showSidebar");
    }
    
    public Response updateShowSidebarActivity(String boardId, boolean value) {
        return given()
                .queryParam("value", value)
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .put("https://api.trello.com/1/boards/" + boardId + "/myPrefs/showSidebarActivity");
    }
    
    public Response updateShowSidebarBoardActions(String boardId, boolean value) {
        return given()
                .queryParam("value", value)
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .put("https://api.trello.com/1/boards/" + boardId + "/myPrefs/showSidebarBoardActions");
    }
    
    public Response createBoard(String name, String desc, boolean defaultLabels, boolean defaultLists, String idOrganization, String idBoardSource, String keepFromSource) {
        return given()
                .queryParam("name", name)
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("defaultLabels", defaultLabels)
                .queryParam("defaultLists", defaultLists)
                .queryParam("desc", desc)
                .queryParam("idOrganization", idOrganization)
                .queryParam("idBoardSource", idBoardSource)
                .queryParam("keepFromSource", keepFromSource)
                .header("Content-Type", "application/json")
                .when()
                .post(TrelloConfig.BASE_URL + "/boards/")
                .then()
                .extract()
                .response();
    }
    
    public Response getCardsOnBoard(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/cards/")
                .then()
                .extract()
                .response();
    }

    public Response getCustomFieldsForBoard(String boardId) {
        return given()
                .header("Accept", "application/json")
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/customFields/")
                .then()
                .extract()
                .response();
    }

    public Response getFilteredCardsOnBoard(String boardId, String filter) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("filter", filter)
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/cards")
                .then()
                .extract()
                .response();
    }

    public Response boardUyelikleriGetir(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/memberships/")
                .then()
                .extract()
                .response();
    }

    public Response boardGuncelle(String boardId, String isim, String aciklama) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("name", isim)
                .queryParam("desc", aciklama)
                .header("Accept", "application/json")
                .when()
                .put(TrelloConfig.BASE_URL + "/boards/" + boardId + "/")
                .then()
                .extract()
                .response();
    }

    public Response boarduSil(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .delete(TrelloConfig.BASE_URL + "/boards/" + boardId + "/")
                .then()
                .extract()
                .response();
    }

    public Response boardAlaniniGetir(String boardId, String alanAdi) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/" + alanAdi + "/")
                .then()
                .extract()
                .response();
    }

    public Response boardAksiyonlariniGetir(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/actions/")
                .then()
                .extract()
                .response();
    }

    public Response boardKontrolListeleriniGetir(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/checklists/")
                .then()
                .extract()
                .response();
    }

    public Response boardYildizlariniGetir(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/boardStars/")
                .then()
                .extract()
                .response();
    }

    public Response boardEtiketleriniGetir(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/labels")
                .then()
                .extract()
                .response();
    }

    public Response boardListeleriniGetir(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/lists")
                .then()
                .extract()
                .response();
    }

    public Response etiketOlustur(String boardId, String Damra, String yesil) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("name", Damra)
                .queryParam("color", yesil)
                .header("Content-Type", "application/json")
                .when()
                .post(TrelloConfig.BASE_URL + "/boards/" + boardId + "/labels")
                .then()
                .extract()
                .response();
    }

    public Response listeOlustur(String boardId, String listeName) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("name", listeName)
                .header("Content-Type", "application/json")
                .when()
                .post(TrelloConfig.BASE_URL + "/boards/" + boardId + "/lists")
                .then()
                .extract()
                .response();
    }

    public Response inviteMemberToBoard(String boardId, String email, String fullName) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("email", email)
                .header("Content-Type", "application/json")
                .body(String.format("{\"%s\": \"%s\"}", "fullName", fullName))
                .when()
                .put(TrelloConfig.BASE_URL + "/boards/" + boardId + "/members")
                .then()
                .extract()
                .response();
    }

    public Response addMemberToBoard(String boardId, String idMember, String type) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("type", type)
                .when()
                .put(TrelloConfig.BASE_URL + "/boards/" + boardId + "/members/" + idMember)
                .then()
                .extract()
                .response();
    }

    public Response removeMemberFromBoard(String boardId, String idMember) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .when()
                .delete(TrelloConfig.BASE_URL + "/boards/" + boardId + "/members/" + idMember)
                .then()
                .extract()
                .response();
    }

    public Response updateMembershipOnBoard(String boardId, String memberId, String type) {
        return given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.API_TOKEN)
                .queryParam("type", type)
                .when()
                .put(TrelloConfig.BASE_URL + "/boards/" + boardId + "/members/" + memberId)
                .then()
                .extract()
                .response();
    }


public Response getMembershipsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/memberships/")
            .then()
            .extract()
            .response();
}


public Response getBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId)
            .then()
            .extract()
            .response();
}


public Response getCustomFieldsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/customFields/")
            .then()
            .extract()
            .response();
}


public Response getCardsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/cards")
            .then()
            .extract()
            .response();
}


public Response getActionsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/actions")
            .then()
            .extract()
            .response();
}


public Response getChecklistsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/checklists")
            .then()
            .extract()
            .response();
}


public Response getStarsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/boardStars")
            .then()
            .extract()
            .response();
}


public Response getLabelsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/labels")
            .then()
            .extract()
            .response();
}


public Response getListsOfBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Accept", "application/json")
            .when()
            .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/lists")
            .then()
            .extract()
            .response();
}


public Response createLabelForBoard(String boardId, String name, String color) {
    return given()
            .queryParam("name", name)
            .queryParam("color", color)
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Content-Type", "application/json")
            .when()
            .post(TrelloConfig.BASE_URL + "/boards/" + boardId + "/labels")
            .then()
            .extract()
            .response();
}


public Response createListForBoard(String boardId, String name) {
    return given()
            .queryParam("name", name)
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Content-Type", "application/json")
            .when()
            .post(TrelloConfig.BASE_URL + "/boards/" + boardId + "/lists")
            .then()
            .extract()
            .response();
}






public Response updateBoard(String boardId, String name, String desc) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .queryParam("name", name)
            .queryParam("desc", desc)
            .header("Accept", "application/json")
            .when()
            .put(TrelloConfig.BASE_URL + "/boards/" + boardId + "/")
            .then()
            .extract()
            .response();
}


public Response deleteBoard(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .when()
            .delete(TrelloConfig.BASE_URL + "/boards/" + boardId)
            .then()
            .extract()
            .response();
}


public Response createTagForBoard(String boardId, String tagName) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .queryParam("name", tagName)
            .header("Content-Type", "application/json")
            .when()
            .post(TrelloConfig.BASE_URL + "/boards/" + boardId + "/labels")
            .then()
            .extract()
            .response();
}

// 19. Mark Board as Viewed
public Response markBoardAsViewed(String boardId) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .header("Content-Type", "application/json")
            .when()
            .post(TrelloConfig.BASE_URL + "/boards/" + boardId + "/markAsViewed")
            .then()
            .extract()
            .response();
}


public Response updateEmailPositionPref(String boardId, String position) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .queryParam("value", position)
            .when()
            .put(TrelloConfig.BASE_URL + "/boards/" + boardId + "/myPrefs/emailPosition")
            .then()
            .extract()
            .response();
}


public Response updateIdEmailListPref(String boardId, String value) {
    return given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.API_TOKEN)
            .queryParam("value", value)
            .put(TrelloConfig.BASE_URL + "/boards/" + boardId + "/myPrefs/idEmailList");
}
}
