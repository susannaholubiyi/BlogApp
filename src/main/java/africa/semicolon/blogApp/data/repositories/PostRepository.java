package africa.semicolon.data.repositories;

import africa.semicolon.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
