import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestApi {


    @Test
    public void getUrl(){

        String getUrl = "https://swapi.dev/api/people";
        String basePath = "/1/";
        int statusCode = 200;
        
        given()
                .baseUri(getUrl)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(statusCode)
                .body("birth_year", equalTo("19BBY"));
    }

    @Test
    public void getUrNegative(){

        String getUrl = "https://swapi.dev/api/people";
        String basePath = "/101/";
        int statusCode = 400;

        given()
                .baseUri(getUrl)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(statusCode)
                .body("birth_year", equalTo("19BB45Y"));
    }

}
