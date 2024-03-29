package africa.semicolon.blogApp.data.repositories;

import africa.semicolon.blogApp.data.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}

