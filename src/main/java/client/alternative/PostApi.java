package client.alternative;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class PostApi extends PlaceholderRestClient {

    public ValidatableResponse getPostById(Long id) {
        return given().spec(baseSpec())
                .when()
                .get("/posts/" + id)
                .then();
    }
}
