package africa.semicolon.utils;

import africa.semicolon.blogApp.data.model.Post;
import africa.semicolon.blogApp.data.model.User;
import africa.semicolon.blogApp.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mappers {
    public static User map(RegisterUserRequest registerUserRequest){
        User user = new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }
    public static RegisterUserResponse map (User savedUser){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(savedUser.getId());
        registerUserResponse.setUsername(savedUser.getUsername());
        registerUserResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
        return registerUserResponse;
    }

    public static LoginUserResponse mapLogin(User registeredUser){
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setUsername(registeredUser.getUsername());
        loginUserResponse.setId(registeredUser.getId());
        return loginUserResponse;
    }
    public static Post mapCreatePost(CreatePostRequest createPostRequest){
        Post newPost = new Post();
        newPost.setTitle(createPostRequest.getTitle());
        newPost.setContents(createPostRequest.getContents());
        return newPost;
    }
    public static CreatePostResponse mapCreatePost(Post createdPost){
        CreatePostResponse createPostResponse = new CreatePostResponse();
        createPostResponse.setId(createdPost.getId());
        createPostResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
        return createPostResponse;
    }
}
