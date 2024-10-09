package manager.interfaces;

import entity.Login;

public interface LoginManager {
    //cria um login na tabela do db
    public int add_login(Login login);

    //Pega os dados do login pelo id e retorna um objeto daquele tipo
    public Login read_login(int id);

    //Altera os dados do login pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_login(Login login);

    //Deleta o login pelo id
    public void delete(int id);

    //Deleta o login pelo login
    public void delete(Login login);

    // Retorna o maior Id de login encontrado
    public int maxId ();
}
