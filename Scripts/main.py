from GerenciadorUsuario import *


gerenciadorUsuario = GerenciadorUsuario()

gerenciadorUsuario.adicionar_usuario("WesleySilva", "wesley.abc@hotmail.com", "Abcdefg1!")  #Válido
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.aly@hotmail.com", "Senha@123")  #Válido
gerenciadorUsuario.adicionar_usuario("Ze", "ze@hotmail.com", "Senha@123")  #Válido
# Testes para username inválidos:
gerenciadorUsuario.adicionar_usuario("NomeMuitoGrandeDeUsuario", "wesley.abc@hotmail.com", "Abcdefg1!")  # Username com mais de 12 caracteres
gerenciadorUsuario.adicionar_usuario("", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login não pode ser vazio.
gerenciadorUsuario.adicionar_usuario("ZeAlysson123", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login não pode conter números.
gerenciadorUsuario.adicionar_usuario("ZeAlyssonnnn", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login deve ter no máximo 12 caracteres.
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.alysson@hotmail.com", "1234567")  # Erro: A senha deve ter no mínimo 8 caracteres.
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.alysson@hotmail.com", "senhasegura")  # Erro: A senha deve conter pelo menos uma letra maiúscula.
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.alysson@hotmail.com", "SENHASEGURA")  # Erro: A senha deve conter pelo menos uma letra minúscula.
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.alysson@hotmail.com", "SenhaSegura")  # Erro: A senha deve conter pelo menos um número.
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.alysson@hotmail.com", "Senha1234")  # Erro: A senha deve conter pelo menos um caractere especial.
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.alysson@hotmail.com", "Senha123456789!")  # Erro: A senha deve ter no máximo 12 caracteres.



gerenciadorUsuario.exibir_usuarios()