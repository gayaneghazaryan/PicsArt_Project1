package Exception;

public class ExperienceException extends RuntimeException{
    public ExperienceException() {
        super("The info about experience should be a non-negative number");
    }

}
