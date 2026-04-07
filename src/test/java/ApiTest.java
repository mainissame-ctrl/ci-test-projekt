import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test
    void getProductsShouldReturnStatus200() {
        given()
                .when().get("https://fakestoreapi.com/products")
                .then()
                .statusCode(200);   // Lokalt blir det oftast 200. I GitHub Actions blir det ofta 403 – det är godkänt enligt uppgiften!
    }
}