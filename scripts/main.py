from UserManager import *


UserManager = UserManager()

#UserManager.add_user("WesleySilva", "wesley.abc@hotmail.com", "Abcdefg1!")  #Válido
#UserManager.add_user("ZeAlysson", "ze.aly@hotmail.com", "Senha@123")  #Válido
#UserManager.add_user("Ze", "ze@hotmail.com", "Senha@123")  #Válido
#UserManager.add_user("Zezin", "ze@hotmail.com", "Senha@123")  #Válido
# Testes para username inválidos:
#UserManager
#UserManager.add_user("NomeMuitoGrandeDeUsuario", "wesley.abc@hotmail.com", "Abcdefg1!")  # Username com mais de 12 caracteres
#UserManager
#.add_user("", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login não pode ser vazio.
#UserManager
#.add_user("ZeAlysson123", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login não pode conter números.
#UserManager
#.add_user("ZeAlyssonnnn", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login deve ter no máximo 12 caracteres.
#UserManager
#.add_user("ZeAlysson", "ze.alysson@hotmail.com", "1234567")  # Erro: A senha deve ter no mínimo 8 caracteres.
#UserManager
#.add_user("ZeAlysson", "ze.alysson@hotmail.com", "senhasegura")  # Erro: A senha deve conter pelo menos uma letra maiúscula.
#UserManager
#.add_user("ZeAlysson", "ze.alysson@hotmail.com", "SENHASEGURA")  # Erro: A senha deve conter pelo menos uma letra minúscula.
#UserManager
#.add_user("ZeAlysson", "ze.alysson@hotmail.com", "SenhaSegura")  # Erro: A senha deve conter pelo menos um número.
#UserManager
#.add_user("ZeAlysson", "ze.alysson@hotmail.com", "Senha1234")  # Erro: A senha deve conter pelo menos um caractere especial.
#UserManager
#.add_user("ZeAlysson", "ze.alysson@hotmail.com", "Senha123456789!")  # Erro: A senha deve ter no máximo 12 caracteres.

UserManager.list_users()
UserManager.save()