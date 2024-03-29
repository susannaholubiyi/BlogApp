package africa.semicolon.blogApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class View {
    private LocalDateTime timeOfView;
    @DBRef
    private User viewer;
    private String id;
}
