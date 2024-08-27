import os
import pickle
from Database import *
from User import *
from LoginValidation import *

DATABASE_PATH = "dados_usuario.pkl"

class UserManager:
    
    def __init__(self):
        self.db_conection()

    #Create the conection with the database
    def db_conection(self):
        # Check if the file exists before even trying to read from it. This is done so we can tell the difference between "File does not exists" and "THE FILE IS ALL WRONG"
        if os.path.isfile(DATABASE_PATH):
            try:
                with open(DATABASE_PATH, 'rb') as db_in:
                    # If it works, the connection is done and we get out
                    self.database = pickle.load(db_in)
                    return
            except IOError as e:
                print(f"Arquivo existe mas houve falha na leitura. Um banco vazio será criado e o arquivo será sobrescrito ao salvar. Erro: {e}")

        # If anything goes even slightly wrong we arrive here
        self.database = Database()

    #add users at database
    def add_user(self, username, email, password):
        
        try:
            user_validation(username, password)
        except InvalidLoginException as e:
            print(f"Erro: {e}")
            return
    
        user = User("", username, email, password)
        
        id = self.database.add(user)
    
        user.setId(id) 
    
    #List all users
    def list_users(self):
        for i in range(self.database.getLenght()):
            self.database.read(i)

    # Saves the database to a persistent file
    def save(self):
        try:
            with open(DATABASE_PATH, "wb") as db_out:
                pickle.dump(self.database, db_out, pickle.HIGHEST_PROTOCOL)
        except IOError as e:
            print(f"Falha ao escrever database como arquivo! Erro: {e}")