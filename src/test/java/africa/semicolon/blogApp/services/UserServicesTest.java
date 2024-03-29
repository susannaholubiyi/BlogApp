package africa.semicolon.blogApp.services;

import africa.semicolon.blogApp.data.model.User;
import africa.semicolon.blogApp.data.repositories.UserRepository;
import africa.semicolon.blogApp.dto.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void userCanLoginTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("Seyi");
        registerUserRequest.setLastName("Olubiyi");
        registerUserRequest.setUsername("suzu");
        registerUserRequest.setPassword("1111");
        userServices.register(registerUserRequest);
        assertEquals(1, userRepository.count());


    }

}