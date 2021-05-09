package Exception;

public class CuisineException extends RuntimeException{
    public CuisineException(){
        super("The info about cuisine is invalid");
    }
    public CuisineException(String message) {
        super(message);
    }
}
