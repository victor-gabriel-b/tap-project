// Library to make the verification easier
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Exception for Invalid Login
class InvalidLoginException extends Exception {

    public InvalidLoginException(String message) {

        super(message);
    }
}

public class LoginValidation {
    
    // This function was made to verify the data of the login and password. The mensages from the Exceptions are in Brazilian Portuguese language. Because the app is going to be inicially for the brazilian clients
    public boolean userValidation(String username, String password) throws InvalidLoginException {
        
        if (username == null || username.isEmpty()) {

            throw new InvalidLoginException("O login não pode ser vazio.");
        }
        
        if (username.length() > 12) {

            throw new InvalidLoginException("O login deve ter no máximo 12 caracteres.");
        }
        
        for (int i = 0; i < username.length(); i++) {

            if (Character.isWhitespace(username.charAt(i))) {

                throw new InvalidLoginException("O login não pode conter espaços.");
            }
            
            if (Character.isDigit(username.charAt(i))) {

                throw new InvalidLoginException("O login não pode conter números.");
            }
        }
        
        if (password.length() > 128) {

            throw new InvalidLoginException("A senha deve ter no máximo 128 caracteres.");
        }
        
        if (password.length() < 8) {

            throw new InvalidLoginException("A senha deve ter no mínimo 8 caracteres.");
        }
        
        if (!containsUpperCase(password)) {

            throw new InvalidLoginException("A senha deve conter pelo menos uma letra maiúscula.");
        }
        
        if (!containsLowerCase(password)) {

            throw new InvalidLoginException("A senha deve conter pelo menos uma letra minúscula.");
        }
        
        if (!containsDigit(password)) {

            throw new InvalidLoginException("A senha deve conter pelo menos um número.");
        }
        
        if (!containsSpecialCharacter(password)) {

            throw new InvalidLoginException("A senha deve conter pelo menos um caractere especial.");
        }
        
        if (password.equals(username)) {

            throw new InvalidLoginException("A senha não pode ser igual ao nome de usuário.");
        }
        
        return true;
    }
    
    // Method to verify if the password contains at least one uppercase letter
    private static boolean containsUpperCase(String str) {

        for (char c : str.toCharArray()) {

            if (Character.isUpperCase(c)) {

                return true;

            }
        }

        return false;
    }

    // Method to verify if the password countains at least one lowercase letter
    private static boolean containsLowerCase(String str) {

        for (char c : str.toCharArray()) {

            if (Character.isLowerCase(c)) {

                return true;
            }

        }

        return false;

    }

    // Method to verify if the string(password) countains at least one number
    private static boolean containsDigit(String str) {

        for (char c : str.toCharArray()) {

            if (Character.isDigit(c)) {

                return true;

            }
        }

        return false;
        
    }

    // Method to verify if the password at least one special character
    private static boolean containsSpecialCharacter(String str) {

        Pattern specialChars = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher hasSpecial = specialChars.matcher(str);
        return hasSpecial.find();

    }

}
