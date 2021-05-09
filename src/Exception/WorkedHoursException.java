package Exception;

public class WorkedHoursException extends RuntimeException{
    public WorkedHoursException() {
        super("Info about worked hours is invalid.");
    }
    public WorkedHoursException(String message) {
        super(message);
    }
}
