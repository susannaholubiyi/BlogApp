package africa.semicolon.blogApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RegisterUserResponse {
    private String id;
    private String username;
    private String date;

}
