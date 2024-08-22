import re

def validar_username(username):
    if not username:
        raise ValueError("O login não pode ser vazio.")
    if len(username) > 12:
        raise ValueError("O login deve ter no máximo 12 caracteres")
    if any(char.isdigit() for char in username):
        raise ValueError("O login não pode conter números.")
    return True

def validar_senha(senha):
    if len(senha) > 12:
        raise ValueError("A senha deve ter no máximo 12 caracteres.")
    if len(senha) < 8:
        raise ValueError("A senha deve ter no mínimo 8 caracteres.")
    if not re.search(r'[A-Z]', senha):
        raise ValueError("A senha deve conter pelo menos uma letra maiúscula.")
    if not re.search(r'[a-z]', senha):
        raise ValueError("A senha deve conter pelo menos uma letra minúscula.")
    if not re.search(r'[0-9]', senha):
        raise ValueError("A senha deve conter pelo menos um número.")
    if not re.search(r'[!@#$%^&*(),.?":{}|<>]', senha):
        raise ValueError("A senha deve conter pelo menos um caractere especial.")
    return True
