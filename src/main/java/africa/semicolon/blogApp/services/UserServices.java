package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.data.model.User;
import africa.semicolon.blogApp.dto.*;

import java.util.Optional;

public interface UserServices {
    RegisterUserResponse register(RegisterUserRequest registerUserRequest);

    LoginUserResponse login(LoginUserRequest loginUserRequest);
    CreatePostResponse createPost(CreatePostRequest createPostRequest);

}
