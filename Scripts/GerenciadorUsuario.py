from Database import *
from Usuario import *


class GerenciadorUsuario:
    def __init__(self):
        self.criar_conexao()

    def criar_conexao(self):
        self.database = Database()



    def adicionar_usuario(self, username, email, senha):
    
        usuario = Usuario("", username, email, senha)
    
        id = self.database.add(usuario)
    
        usuario.setId(id) 
    

    def exibir_usuarios(self):
    
        for i in range(self.database.getLenght()):
            self.database.read(i)


