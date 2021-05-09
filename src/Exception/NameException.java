package Exception;

public class NameException extends RuntimeException{
    public NameException(){
        super("Input string is invalid as a name or surname");
    }
    public NameException(String message) {
        super(message);
    }
}
