package bo.edu.ucb.sis213.mrjeff.util;

public class MrJeffException extends RuntimeException{
    public MrJeffException(String message) {
        super(message);
    }

    public MrJeffException(String message, Throwable cause) {
        super(message, cause);
    }
}
