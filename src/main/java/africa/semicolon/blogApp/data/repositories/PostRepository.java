package africa.semicolon.blogApp.data.repositories;

import africa.semicolon.blogApp.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
