package africa.semicolon.data.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String id;
    @DBRef
    private List<Post> posts;

}
