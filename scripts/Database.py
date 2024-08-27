class Database:

    #create the database
    def __init__ (self):
        self.users = []
        self.id = -1


    #add an user to the database and return it's id
    def add(self, users):
        self.id = self.id + 1
        self.users.append(users)
        return self.getLenght()
    
    
    #Search in the database for the user's id
    def read(self, id):
        if 0 <= id < len(self.users):
            print(f"{id} | {self.users[id].username} | {self.users[id].email}")
            
        else:
            print("ID inválido.")
    
    #return the "last id"
    def getLenght(self):
        return len(self.users)
    
    
