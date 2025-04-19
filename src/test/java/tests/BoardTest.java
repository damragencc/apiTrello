package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import services.BoardService;
import static org.testng.Assert.assertEquals;

public class BoardTest {
    private BoardService boardService;
    

    private String testBoardId;

    @BeforeClass
    public void setup() {
        boardService = new BoardService();
        // Create a test board with minimal parameters
        Response createResponse = boardService.createBoard("Test Board", "", true, true, "", "", "");
        assertEquals(createResponse.getStatusCode(), 200);
        testBoardId = createResponse.jsonPath().getString("id");
        System.out.println("Created test board with ID: " + testBoardId);
    }
    //3
    @Test
    public void testBoardGuncelle() {
        Response response = boardService.boardGuncelle(testBoardId, "Güncellenmiş Board", "Test açıklaması");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board güncelleme response: " + response.asPrettyString());
    }
    //5
    @Test
    public void testBoardAlaniniGetir() {
        Response response = boardService.boardAlaniniGetir(testBoardId, "name");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board alanı response: " + response.asPrettyString());
    }
    //6
    @Test
    public void testBoardAksiyonlariniGetir() {
        Response response = boardService.boardAksiyonlariniGetir(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board aksiyonları response: " + response.asPrettyString());
    }

    //7
    @Test
    public void testBoardYildizlariniGetir() {
        Response response = boardService.boardYildizlariniGetir(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board yıldızları response: " + response.asPrettyString());
    }

    //8
    @Test
    public void testBoardKontrolListeleriniGetir() {
        Response response = boardService.boardKontrolListeleriniGetir(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board kontrol listeleri response: " + response.asPrettyString());
    }
       //9
    @Test
    public void testGetCardsOnBoard() {
        Response response = boardService.getCardsOnBoard(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Cards on board response: " + response.asPrettyString());
    }

  //10
    @Test
    public void testGetFilteredCardsOnBoard() {
        Response response = boardService.getFilteredCardsOnBoard(testBoardId, "open");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Filtered cards response: " + response.asPrettyString());
    }

    //11
    @Test
    public void testGetCustomFieldsForBoard() {
        Response response = boardService.getCustomFieldsForBoard(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Custom fields response: " + response.asPrettyString());
    }
   //12
    @Test
    public void testBoardEtiketleriGetir() {
        Response response = boardService.boardEtiketleriniGetir(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board etiketleri response: " + response.asPrettyString());
    }

  //13
    @Test
    public void testEtiketOlustur() {
        Response response = boardService.etiketOlustur(testBoardId, "Damra", "red");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Yeni etiket response: " + response.asPrettyString());
    }
    //14
    @Test
    public void testBoardListeleriGetir() {
        Response response = boardService.boardListeleriniGetir(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board listeleri response: " + response.asPrettyString());
    }
//15
    @Test
    public void testListeOlustur() {
        Response response = boardService.listeOlustur(testBoardId, "Test Listesi");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Yeni liste response: " + response.asPrettyString());
    }

  //16
    @Test
    public void testBoardFiltreliListeleriGetir() {
        Response response = boardService.boardListeleriniGetir(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board listeleri response: " + response.asPrettyString());
    }
    //17
    @Test
    public void testBoardUyelikleriGetir() {
        Response response = boardService.boardUyelikleriGetir(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board üyelikleri response: " + response.asPrettyString());
    }

    //18
    @Test
    public void testInviteMemberToBoard() {
        Response response = boardService.inviteMemberToBoard(testBoardId, "test@example.com", "Test User");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board davet response: " + response.asPrettyString());
    }
   //19
    @Test
    public void testAddMemberToBoard() {
        Response response = boardService.addMemberToBoard(testBoardId, "6802a84cae324592ec4c6d96", "normal");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board üye ekleme response: " + response.asPrettyString());
    }
//20
    @Test
    public void testRemoveMemberFromBoard() {
        Response response = boardService.removeMemberFromBoard(testBoardId, "6802a84cae324592ec4c6d96");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Board üye silme response: " + response.asPrettyString());
    }
//21
    @Test
    public void testUpdateMembershipOnBoard() {
        // Önce bir board oluştur
        Response createBoardResponse = boardService.createBoard("Test Board for Membership", "", true, true, "", "", "");
        String boardId = createBoardResponse.jsonPath().getString("id");
        
        // Mevcut kullanıcının ID'sini al
        String memberId = "6802a84cae324592ec4c6d96"; // Sizin Trello kullanıcı ID'niz
        String type = "admin"; // normal, admin, veya observer olabilir
        
        Response response = boardService.updateMembershipOnBoard(boardId, memberId, type);
        assertEquals(response.getStatusCode(), 200);
        
        // Test board'ını temizle
        boardService.deleteBoard(boardId);
    }

//22
    @Test
    public void testUpdateEmailPositionPref() {
        // Önce bir board oluştur
        Response createBoardResponse = boardService.createBoard("Test Board for Email Position", "", true, true, "", "", "");
        String boardId = createBoardResponse.jsonPath().getString("id");
        
        Response response = boardService.updateEmailPositionPref(boardId, "bottom");
        assertEquals(response.getStatusCode(), 200);
        
        // Test board'ını temizle
        boardService.deleteBoard(boardId);
    }
    //23
    @Test
    public void testUpdateIdEmailListPref() {
        // Önce bir board oluştur
        Response createBoardResponse = boardService.createBoard("Test Board for Email List", "", true, true, "", "", "");
        String boardId = createBoardResponse.jsonPath().getString("id");

        // Email list tercihini güncelle (izin verilen değerler: all, disabled, members, none)
        Response response = boardService.updateIdEmailListPref(boardId, "members");
        assertEquals(response.getStatusCode(), 200, "Email list preference update failed");

        // Test board'ını temizle
        boardService.deleteBoard(boardId);
    }

    @Test
    public void testUpdateShowSidebar() {
        Response response = boardService.updateShowSidebar(testBoardId, true);
        assertEquals(response.getStatusCode(), 200);
    }
    //25
    @Test
    public void testUpdateShowSidebarActivity() {
        Response response = boardService.updateShowSidebarActivity(testBoardId, true);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testUpdateShowSidebarBoardActions() {
        Response response = boardService.updateShowSidebarBoardActions(testBoardId, true);
        assertEquals(response.getStatusCode(), 200);
    }
//28
    @Test
    public void testCreateTagForBoard() {
        Response response = boardService.createTagForBoard(testBoardId, "TestTag");
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Create tag response: " + response.asPrettyString());
    }
  //32
    @Test
    public void testMarkBoardAsViewed() {
        Response response = boardService.markBoardAsViewed(testBoardId);
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Mark as viewed response: " + response.asPrettyString());
    }

    @AfterClass
    public void cleanup() {
        // Clean up the test board
        if (testBoardId != null) {
            Response response = boardService.deleteBoard(testBoardId);
            assertEquals(response.getStatusCode(), 200);
            System.out.println("Deleted test board with ID: " + testBoardId);
        }
    }
}
