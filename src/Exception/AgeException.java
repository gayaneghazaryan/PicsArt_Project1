package Exception;

public class AgeException extends RuntimeException{
    public AgeException() {
        super("Input age is invalid. Employees should be older than 16.");
    }

    public AgeException(String message) {
        super(message);
    }
}
