package Exception;

public class SpecializationException extends RuntimeException{
    public SpecializationException() {
        super("The info about specialization is invalid");
    }

    public SpecializationException(String message) {
        super(message);
    }
}
