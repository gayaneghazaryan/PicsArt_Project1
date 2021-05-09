package Exception;


public class RoleException extends RuntimeException{
    public RoleException() {
        super("The info about role is invalid.");
    }

    public RoleException(String message) {
        super(message);
    }
}
