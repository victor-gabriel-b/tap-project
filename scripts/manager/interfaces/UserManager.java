package manager.interfaces;

import entity.User;

public interface UserManager {
    //cria um user na tabela do db
    public int add_user(User user);

    //Pega os dados do user pelo id e retorna um objeto daquele tipo
    public User read_user(int id);

    //Altera os dados do user pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_user(User user);

    //Deleta o user pelo id
    public void delete(int id);

    //Deleta o user pelo user
    public void delete(User user);

    //Pega os dados do user pelo Username e retorna um objeto daquele tipo
    public User read_username(String username);
}
