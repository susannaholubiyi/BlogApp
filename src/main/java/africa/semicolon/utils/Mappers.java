package africa.semicolon.utils;

import africa.semicolon.blogApp.data.model.User;
import africa.semicolon.blogApp.dto.RegisterUserRequest;
import africa.semicolon.blogApp.dto.RegisterUserResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mappers {
    public static User map(RegisterUserRequest registerUserRequest){
        User user = new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setUserName(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }
    public static RegisterUserResponse map (User savedUser){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(savedUser.getId());
        registerUserResponse.setUsername(savedUser.getUserName());
        registerUserResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
        return registerUserResponse;
    }
}
