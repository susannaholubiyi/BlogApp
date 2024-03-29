package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.data.model.User;
import africa.semicolon.blogApp.data.repositories.UserRepository;
import africa.semicolon.blogApp.dto.RegisterUserRequest;
import africa.semicolon.blogApp.dto.RegisterUserResponse;
import africa.semicolon.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.utils.Mappers.map;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest){
        registerUserRequest.setUsername(registerUserRequest.getUsername().toLowerCase());
        validateUserName(registerUserRequest.getUsername());
        User user = map(registerUserRequest);
        userRepository.save(user);
        return map(user);
    }

    private void validateUserName(String username) {
        boolean usernameExists = userRepository.existsById(username);
        if(usernameExists) throw new UserDoesNotExistException(String.format("%s does not exist", username));
    }
}
