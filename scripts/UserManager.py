from Database import *
from User import *
from LoginValidation import *


class UserManager:
    
    def __init__(self):
        self.db_conection()

    #Create the conection with the database
    def db_conection(self):
        self.database = Database()

    #add users at database
    def add_user(self, username, email, password):
        
        try:
            user_validation(username, password)
        except ValueError as e:
            print(f"Erro: {e}")
            return
    
        user = User("", username, email, password)
        
        id = self.database.add(user)
    
        user.setId(id) 
    
    #List all users
    def list_users(self):
        for i in range(self.database.getLenght()):
            self.database.read(i)
