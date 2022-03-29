package client;

import model.User;

public class UserApiClient extends BaseHttpClient {

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    public User createUser(User user) {
       return doPostRequest(baseUrl + "/users/", user).body().as(User.class);
    }
}
