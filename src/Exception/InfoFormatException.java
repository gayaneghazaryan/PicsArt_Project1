package Exception;

public class InfoFormatException extends RuntimeException{
    public InfoFormatException() {
        super("Wrong information format");
    }

    public InfoFormatException(String message) {
        super(message);
    }

}
