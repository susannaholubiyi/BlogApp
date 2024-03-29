package africa.semicolon.data.repositories;

import africa.semicolon.data.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}

