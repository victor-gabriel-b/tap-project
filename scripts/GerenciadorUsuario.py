import pickle
import os
from Database import *
from Usuario import *
from login_validation import *
CAMINHO_DATABASE = "dados_usuario.pkl"

class GerenciadorUsuario:
    def __init__(self):
        self.criar_conexao()

    def criar_conexao(self):
        # Verificar se existe antes de mesmo de tentar com 'try' para que seja possível diferenciar "arquivo não encontrado" de "TÁ TUDO ERRADO NO ARQUIVO"
        if os.path.isfile(CAMINHO_DATABASE):
            try:
                with open(CAMINHO_DATABASE, 'rb') as db_in:
                    # Caso dê certo, vazar na hora pra não criar de novo lá em baixo
                    self.database = pickle.load(db_in)
                    return
            except IOError as e:
                print(f"Arquivo existe mas houve falha na leitura. Um banco vazio será criado e o arquivo será sobrescrito ao salvar. Erro: {e}")

        # Qualquer coisa deu levemente errado chega aqui
        self.database = Database()

    def adicionar_usuario(self, username, email, senha):  
        try:
            validar_username(username)
            validar_senha(senha)
        except ValueError as e:
            print(f"Erro: {e}")
            return
    
        usuario = Usuario("", username, email, senha)
        
        id = self.database.add(usuario)
    
        usuario.setId(id) 
    
    def exibir_usuarios(self):
        for i in range(self.database.getLenght()):
            self.database.read(i)

    def salvar(self):
        try:
            with open(CAMINHO_DATABASE, "wb") as db_out:
                pickle.dump(self.database, db_out, pickle.HIGHEST_PROTOCOL)

        except IOError as e:
            print(f"Falha ao escrever database como arquivo! Erro: {e}")


