package validation;

public class UsernameInvalidException extends Exception {

    public UsernameInvalidException() {
        super("Username inválido");
    }

    public UsernameInvalidException(String message) {
        super(message);
    }
}