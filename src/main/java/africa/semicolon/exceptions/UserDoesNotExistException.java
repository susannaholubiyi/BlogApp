package africa.semicolon.exceptions;

public class UserDoesNotExistException extends BlogAppExceptions{
    public UserDoesNotExistException(String message){
        super(message);
    }
}
