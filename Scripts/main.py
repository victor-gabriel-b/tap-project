from GerenciadorUsuario import *


gerenciadorUsuario = GerenciadorUsuario()

gerenciadorUsuario.adicionar_usuario("WesleySilva", "wesley.abc@hotmail.com", "Abcdefg1!")  #Válido
gerenciadorUsuario.adicionar_usuario("Wesley123", "wesley.abc@hotmail.com", "abc1234")  #Inválido (username contém números)
gerenciadorUsuario.adicionar_usuario("Wesley", "wesley.abc@hotmail.com", "abc")  #Inválido (senha não cumpre as regras)
gerenciadorUsuario.adicionar_usuario("ZeAlysson", "ze.aly@hotmail.com", "Senha@123")  #Válido



gerenciadorUsuario.exibir_usuarios()