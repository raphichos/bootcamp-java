package module08.tutorial1.exception;

public class CustomException extends RuntimeException{

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
