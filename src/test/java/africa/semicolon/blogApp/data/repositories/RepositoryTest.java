
package africa.semicolon.blogApp.data.repositories;

        import africa.semicolon.blogApp.data.model.Comment;
        import africa.semicolon.blogApp.data.model.Post;
        import africa.semicolon.blogApp.data.model.User;
        import africa.semicolon.blogApp.data.model.View;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;

        import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ViewRepository viewRepository;
    @Autowired
    private PostRepository postRepository;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
        commentRepository.deleteAll();
        viewRepository.deleteAll();
        postRepository.deleteAll();
    }
    @Test
    public void userRepositorySaveTest(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void commentRepositorySaveTest(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
    }
    @Test
    public void viewRepositorySaveTest(){
        View view = new View();
        viewRepository.save(view);
        assertEquals(1, viewRepository.count());
    }
    @Test
    public void postRepositorySaveTest(){
        Post post= new Post();
        postRepository.save(post);
        assertEquals(1, postRepository.count());
    }
}