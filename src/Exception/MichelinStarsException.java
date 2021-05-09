package Exception;

public class MichelinStarsException extends RuntimeException{
    public MichelinStarsException() {
        super("The number of Michelin stars is invalid.");
    }

    public MichelinStarsException(String message) {
        super(message);
    }

}
