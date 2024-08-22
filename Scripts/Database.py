
class Database:

    def __init__ (self):
        self.usuarios = []
        self.id = -1

    def add(self, usuario):
        self.id = self.id + 1
        self.usuarios.append(usuario)
        return self.getLenght()
    
    
    def read(self, id):
        print(f"{id} | {self.usuarios[id].username} | {self.usuarios[id].email}")
    
    def getLenght(self):
        return len(self.usuarios)
