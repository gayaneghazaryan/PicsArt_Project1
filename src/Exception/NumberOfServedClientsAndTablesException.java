package Exception;

public class NumberOfServedClientsAndTablesException extends RuntimeException {
    public NumberOfServedClientsAndTablesException() {
        super("The info about the number of served clients or tables is invalid");
    }

    public NumberOfServedClientsAndTablesException(String message) {
        super(message);
    }
}
