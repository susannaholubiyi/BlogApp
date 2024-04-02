package africa.semicolon.blogApp.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String contents;
    private String username;
}
