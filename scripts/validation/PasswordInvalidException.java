package validation;

public class PasswordInvalidException extends Exception {

    public PasswordInvalidException() {
        super("Senha inválida");
    }

    public PasswordInvalidException(String message) {
        super(message);
    }
}
