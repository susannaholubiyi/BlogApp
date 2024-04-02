package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.data.model.User;
import africa.semicolon.blogApp.data.repositories.UserRepository;
import africa.semicolon.blogApp.dto.CreatePostRequest;
import africa.semicolon.blogApp.dto.LoginUserRequest;
import africa.semicolon.blogApp.dto.RegisterUserRequest;
import africa.semicolon.exceptions.userNameAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
    }

    @Test
    public void registerUserTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("Seyi");
        registerUserRequest.setLastName("Olubiyi");
        registerUserRequest.setUsername("suzu");
        registerUserRequest.setPassword("1111");
        userServices.register(registerUserRequest);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void registerUser_sameUserRegistersAgain_ExceptionIsThrownTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("Seyi");
        registerUserRequest.setLastName("Olubiyi");
        registerUserRequest.setUsername("suzu");
        registerUserRequest.setPassword("1111");
        userServices.register(registerUserRequest);

        assertThrows(userNameAlreadyExistsException.class, ()->userServices.register(registerUserRequest));

    }
    @Test
    public void userCanCreatePostTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstname");
        registerUserRequest.setLastName("lastname");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userServices.register(registerUserRequest);
        assertEquals(1, userRepository.count());
        Optional<User> user = userRepository.findByUsername("username");
        assertTrue(user.isPresent());

        CreatePostRequest createPostRequest = new  CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setUsername("username");
        createPostRequest.setContents("content");
        userServices.createPost(createPostRequest);
        user = userRepository.findByUsername("username");
        assertTrue(user.isPresent());
        assertEquals(1, user.get().getPosts().size());
        assertEquals("title", user.get().getPosts().get(0).getTitle());

    }
    @Test
    public void userCanLoginTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstname");
        registerUserRequest.setLastName("lastname");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userServices.register(registerUserRequest);
        assertEquals(1, userRepository.count());

        Optional<User> user = userRepository.findByUsername("username");
        assertTrue(user.isPresent());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("username");
        loginUserRequest.setPassword("password");

        userServices.login(loginUserRequest);

        user = userRepository.findByUsername("username");
        assertFalse(user.get().isLocked());
    }

}