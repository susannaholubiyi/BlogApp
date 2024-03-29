
package africa.semicolon.blogApp.data.repositories;

        import africa.semicolon.blogApp.dto.RegisterUserRequest;
        import africa.semicolon.blogApp.data.model.User;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;

        import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void saveTest(){
        User user = new User();
        userRepository.save(user);
        assertEquals(3, userRepository.count());
    }

}