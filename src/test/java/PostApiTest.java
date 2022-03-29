import client.alternative.PostApi;
import io.restassured.response.ValidatableResponse;
import model.*;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostApiTest {

    private final PostSteps steps = new PostSteps();

    private final PostApi postApi = new PostApi();
    private Long userId = null;

    @Before
    public void setUp() {
        userId = steps.createUserForPost(
                new User(
                        999L,
                        "API TEST",
                        "API TEST",
                        "MY EMAIL",
                        new Address(
                                "PUSHKINA",
                                "XXX",
                                "MOSCOW",
                                "999999",
                                new Geo(
                                        "500.00",
                                        "500.00"
                                )
                        ),
                        "9999999999",
                        "www.api-test.ru",
                        new Company(
                                "AUTOTEST",
                                "CATCHPHRASE",
                                "BS"
                        )
                )
        );
    }

    @After
    public void cleanUp() {

    }

    @Test
    public void testGetPostByCorrectId() {
        Post expected = new Post(userId, 999L, "TITLE", "BODY");
        Long postId = steps.createPost(expected);
        Post actual = steps.getApiPostByPostId(postId);
        steps.checkPost(actual, expected);
    }

    @Test
    public void testGetPost() {
        ValidatableResponse response = postApi.getPostById(56L);
        int statusCode = response.extract().statusCode();
        Integer userId = response.extract().path("userId");
        assertThat("Status code couldn't be 200", statusCode, equalTo(HttpStatus.SC_OK));
        assertThat("User is must be 6", userId, equalTo(6));
    }
}
