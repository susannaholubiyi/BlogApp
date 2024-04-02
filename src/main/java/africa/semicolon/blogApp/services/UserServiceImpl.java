package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.data.model.Post;
import africa.semicolon.blogApp.data.model.User;
import africa.semicolon.blogApp.data.repositories.UserRepository;
import africa.semicolon.blogApp.dto.*;
import africa.semicolon.exceptions.IncorrectPasswordException;
import africa.semicolon.exceptions.userNameAlreadyExistsException;
import africa.semicolon.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static africa.semicolon.utils.Mappers.*;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostServicesImpl postServices;
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest){
        registerUserRequest.setUsername(registerUserRequest.getUsername().toLowerCase());
        validateUserName(registerUserRequest.getUsername());
        User user = map(registerUserRequest);
        user.setLocked(false);
        userRepository.save(user);
        return map(user);
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {

        User registeredUser = findUserBy(loginUserRequest.getUsername().toLowerCase());

        String providedPassword = loginUserRequest.getPassword();
        String storedPassword = registeredUser.getPassword();
        if(validatePassword(storedPassword, providedPassword)){ registeredUser.setLocked(false);}
        userRepository.save(registeredUser);
        return mapLogin(registeredUser);
    }

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        User user = findUserBy(createPostRequest.getUsername());
        Post createdPost = postServices.createPost(createPostRequest);
        user.getPosts().add(createdPost);
        userRepository.save(user);

        return mapCreatePost(createdPost);
    }

    private boolean validatePassword(String savedPassword, String providedPassword) {
        if(providedPassword.equals(savedPassword)) return true;
        else throw new IncorrectPasswordException(String.format("%s is incorrect, kindly input correct password", providedPassword));

    }

    private User findUserBy(String username) {
        Optional<User> user =  userRepository.findByUsername(username);
        if(user.isEmpty()) throw new UserDoesNotExistException(String.format("%s is not a registered user, kindly register", username));
        return user.get();
    }

    private void validateUserName(String username) {
        boolean usernameExists = userRepository.existsByUsername(username);
        if(usernameExists) throw new userNameAlreadyExistsException(String.format("%s is a registered user", username));
    }
}
