package task16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Task16Test {
    private static final String KEY = "fbe1cefe8af41c16b600e686a81463b3";
    private static final String TOKEN = "ATTA1bcad645e112ce8be70a01abf0c94422cebb2e8190958d66f7a6012d82279ea6AB4FED6E";

    @Test
    void trelloTest() {
        // Create board
        Response createBoardRes = given()
                .queryParam("name", "testBoardName")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/boards/")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
        String boardID = createBoardRes.jsonPath().getString("id");

        // Create a "To Do" list on the board
        Response createToDoListRes = given()
                .queryParam("name", "To Do")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idBoard", boardID)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/lists")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
        String toDoListID = createToDoListRes.jsonPath().getString("id");

        // Create card in the "To Do" list
        Response createCardRes = given()
                .queryParam("name", "Test Card")
                .queryParam("idList", toDoListID)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/cards")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
        String cardID = createCardRes.jsonPath().getString("id");

        // Create the "Doing" list on the board
        Response createDoingListRes = given()
                .queryParam("name", "Doing")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idBoard", boardID)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/lists")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
        String doingListID = createDoingListRes.jsonPath().getString("id");

        // Put the card to "Doing" list
        Response moveCardRes = given()
                .queryParam("idList", doingListID)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .put("https://api.trello.com/1/cards/" + cardID)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
    }
}
