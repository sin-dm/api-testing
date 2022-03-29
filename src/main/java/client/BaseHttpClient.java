package client;

import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseHttpClient {

    private final String JSON = "application/json";

    private final RestAssuredConfig config = RestAssuredConfig.newConfig()
            .sslConfig(new SSLConfig().relaxedHTTPSValidation())
            .redirect(new RedirectConfig().followRedirects(true));

    protected Response doGetRequest(String uri) {
        return given().config(config)
                .header("Content-Type", JSON)
                .get(uri);
    }

    protected Response doGetRequest(String uri, String token) {
        return given().config(config)
                .header("Content-Type", JSON)
                .header("Authorization", token)
                .get(uri);
    }

    protected Response doPostRequest(String uri, Object body) {
        return given().config(config)
                .header("Content-Type", JSON)
                .body(body)
                .post(uri);
    }
}
