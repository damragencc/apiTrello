package pages;

import io.restassured.http.ContentType;

public class TrelloPage extends BasePage {
    
    public TrelloPage() {
        super();
    }

    public void createBoard(String boardName) {
        response = getRequest()
                .contentType(ContentType.JSON)
                .queryParam("name", boardName)
                .when()
                .post(BASE_URL + "/boards");
    }

    public void deleteBoard(String boardId) {
        response = getRequest()
                .when()
                .delete(BASE_URL + "/boards/" + boardId);
    }

    public void createList(String listName, String boardId) {
        response = getRequest()
                .contentType(ContentType.JSON)
                .queryParam("name", listName)
                .queryParam("idBoard", boardId)
                .when()
                .post(BASE_URL + "/lists");
    }

    public void createCard(String cardName, String listId) {
        response = getRequest()
                .contentType(ContentType.JSON)
                .queryParam("name", cardName)
                .queryParam("idList", listId)
                .when()
                .post(BASE_URL + "/cards");
    }

    public void updateCard(String cardId, String newName) {
        response = getRequest()
                .contentType(ContentType.JSON)
                .queryParam("name", newName)
                .when()
                .put(BASE_URL + "/cards/" + cardId);
    }

    public void deleteCard(String cardId) {
        response = getRequest()
                .when()
                .delete(BASE_URL + "/cards/" + cardId);
    }
} 