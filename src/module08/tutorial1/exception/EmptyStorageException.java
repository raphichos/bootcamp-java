package module08.tutorial1.exception;

public class EmptyStorageException extends RuntimeException{

    public EmptyStorageException(String message) {
        super(message);
    }
}
