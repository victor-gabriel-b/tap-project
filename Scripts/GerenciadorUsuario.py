from Database import *
from Usuario import *
import re


class GerenciadorUsuario:
    def __init__(self):
        self.criar_conexao()

    def criar_conexao(self):
        self.database = Database()

    def validar_username(self, username):
        if not username or len(username) > 12:
            raise ValueError("O login deve ter no máximo 12 caracteres e não pode ser vazio.")
        if any(char.isdigit() for char in username):
            raise ValueError("O login não pode conter números.")
        return True
    
    def validar_senha(self, senha):
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

    def adicionar_usuario(self, username, email, senha):
        
        #Validações
        try:
            self.validar_username(username)
            self.validar_senha(senha)
        except ValueError as e:
            print(f"Erro: {e}")
            return
    
        usuario = Usuario("", username, email, senha)
        
        id = self.database.add(usuario)
    
        usuario.setId(id) 
    

    def exibir_usuarios(self):
    
        for i in range(self.database.getLenght()):
            self.database.read(i)


