# Library to make the verification easier
import re

# Exception for Invalid Login
class InvalidLoginException(Exception):
    pass

# This function was made to verify the data of the login and password. The mensages from the Exceptions are in Brazilian Portuguese language. Because the app is going to be inicially for the brazilian clients 
def user_validation(username, password):
    
    if not username:
        raise InvalidLoginException("O login não pode ser vazio.")
    
    if len(username) > 12:
        raise InvalidLoginException("O login deve ter no máximo 12 caracteres")
    
    for i in range(len(username)):
        
        if username[i] == " ":
            raise InvalidLoginException("O login não pode conter espaços.")
        
        if username[i].isdigit():
            raise InvalidLoginException("O login não pode conter números.")
    
    if len(password) > 128:
        raise InvalidLoginException("A senha deve ter no máximo 128 caracteres.")
    
    if len(password) < 8:
        raise InvalidLoginException("A senha deve ter no mínimo 8 caracteres.")
    
    if not re.search(r'[A-Z]', password):
        raise InvalidLoginException("A senha deve conter pelo menos uma letra maiúscula.")
    
    if not re.search(r'[a-z]', password):
        raise InvalidLoginException("A senha deve conter pelo menos uma letra minúscula.")
    
    if not re.search(r'[0-9]', password):
        raise InvalidLoginException("A senha deve conter pelo menos um número.")
    
    if not re.search(r'[!@#$%^&*(),.?":{}|<>]', password):
        raise InvalidLoginException("A senha deve conter pelo menos um caractere especial.")
    
    if password == username:
        raise InvalidLoginException("A senha não pode ser igual ao nome de usuário.")
    
    return True

