package client;

import model.Post;

public class PostApiClient extends BaseHttpClient {

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    public Post getPostById(Long id) {
        return doGetRequest(baseUrl + "/posts/" + id).body().as(Post.class);
    }

    public Post createPost(Post post) {
        return doPostRequest(baseUrl + "/posts/", post).body().as(Post.class);
    }
}
