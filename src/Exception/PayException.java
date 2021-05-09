package Exception;

public class PayException extends RuntimeException{
    public PayException() {
        super("The pay info is invalid");
    }

    public PayException(String message) {
        super(message);
    }

}
