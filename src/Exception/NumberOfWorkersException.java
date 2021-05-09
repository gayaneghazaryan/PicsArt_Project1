package Exception;

public class NumberOfWorkersException extends RuntimeException{
    public NumberOfWorkersException() {
        super("The info about the number of workers is invalid.");
    }

    public NumberOfWorkersException(String message) {
        super(message);
    }
}
