import client.PostApiClient;
import client.UserApiClient;
import model.Post;
import model.User;

import static org.assertj.core.api.Assertions.assertThat;

public class PostSteps {

    private final PostApiClient postApiClient = new PostApiClient();
    private final UserApiClient userApiClient = new UserApiClient();

    public Long createUserForPost(User user) {
        return userApiClient.createUser(user).getId();
    }

    public Long createPost(Post post) {
        return postApiClient.createPost(post).getId();
    }

    public Post getApiPostByPostId(Long id) {
        return postApiClient.getPostById(id);
    }

    public void checkPost(Post apiPost, Post expected) {
        assertThat(apiPost).usingRecursiveComparison().isEqualTo(expected);
    }
}
