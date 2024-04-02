package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.data.model.Post;
import africa.semicolon.blogApp.data.repositories.PostRepository;
import africa.semicolon.blogApp.dto.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.utils.Mappers.mapCreatePost;
@Service
public class PostServicesImpl implements PostServices{
    @Autowired
    private PostRepository postRepository;
    @Override
    public Post createPost(CreatePostRequest createPostRequest) {
        Post newPost = mapCreatePost(createPostRequest);
        postRepository.save(newPost);
        return newPost;
    }
}