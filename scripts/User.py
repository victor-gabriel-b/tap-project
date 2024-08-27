
class User:
    
    def __init__(self, id, username, email, password):
        self.id = id
        self.username = username
        self.email = email
        self.password = password
    
    
    #Getters & Setters classes  
    def setUsername(self, username):
        self.username = username
        
    def getUsername(self):
        return self.username


    def setEmail(self, email):
        self.email = email
        
    def getEmail(self):
        return self.email

        
    def setPassword(self, password):
        self.password = password
        
    def getPassword(self):
        return self.password


    def setId(self, id):
        self.id = id
        
    def getId(self):
        return self.id