package Exception;

public class SignatureDrinkException extends RuntimeException{
    public SignatureDrinkException() {
        super("Signature Drink is invalid");
    }

    public SignatureDrinkException(String message) {
        super(message);
    }
}
