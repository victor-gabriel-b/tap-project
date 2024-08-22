
class Usuario:
    def __init__(self, id, username, email, password):
        self.id = id
        self.username = username
        self.email = email
        self.password = password
    
    
    
    
    
    #Classes Getters & Setters
        
    def setUsername(self, username):
        self.username = username
        
    def getUsername(self):
        return self.username


    def setEmail(self, email):
        self.email = email
        
    def getEmail(self):
        return self.email

        
    def setSenha(self, senha):
        self.senha = senha
        
    def getSenha(self):
        return self.senha


    def setId(self, id):
        self.id = id
        
    def getId(self):
        return self.id