package africa.semicolon.blogApp.data.repositories;


import africa.semicolon.blogApp.data.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepository extends MongoRepository<View, String> {
}
