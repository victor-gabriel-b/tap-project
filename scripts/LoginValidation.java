import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}

public class LoginValidation {
    
    public boolean userValidation(String username, String password) throws InvalidLoginException {
        
        // Verificação para null ou strings vazias
        if (username == null || username.isEmpty()) {
            throw new InvalidLoginException("O login não pode ser vazio.");
        }
        
        if (username.length() > 12) {
            throw new InvalidLoginException("O login deve ter no máximo 12 caracteres.");
        }
        
        // Verificar se o login contém espaços ou números
        for (int i = 0; i < username.length(); i++) {
            if (Character.isWhitespace(username.charAt(i))) {
                throw new InvalidLoginException("O login não pode conter espaços.");
            }
            
            if (Character.isDigit(username.charAt(i))) {
                throw new InvalidLoginException("O login não pode conter números.");
            }
        }
        
        if (password == null) {
            throw new InvalidLoginException("A senha não pode ser nula.");
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
    
    //verificar se a senha contém pelo menos uma letra maiúscula
    private static boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    //verificar se a senha contém pelo menos uma letra minúscula
    private static boolean containsLowerCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    //verificar se a senha contém pelo menos um número
    private static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    //verificar se a senha contém pelo menos um caractere especial
    private static boolean containsSpecialCharacter(String str) {
        Pattern specialChars = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher hasSpecial = specialChars.matcher(str);
        return hasSpecial.find();
    }
}
