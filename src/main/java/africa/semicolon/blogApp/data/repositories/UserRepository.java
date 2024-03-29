package africa.semicolon.data.repositories;

import africa.semicolon.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
