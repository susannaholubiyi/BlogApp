package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.data.model.Post;
import africa.semicolon.blogApp.dto.CreatePostRequest;

public interface PostServices {
    Post createPost(CreatePostRequest createPostRequest);
}
