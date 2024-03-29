package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.dto.RegisterUserRequest;
import africa.semicolon.blogApp.dto.RegisterUserResponse;

public interface UserServices {
    RegisterUserResponse register(RegisterUserRequest registerUserRequest);
}
