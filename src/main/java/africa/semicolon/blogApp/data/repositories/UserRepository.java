package africa.semicolon.blogApp.data.repositories;

import africa.semicolon.blogApp.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
