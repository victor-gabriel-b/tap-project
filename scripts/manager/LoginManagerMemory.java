package manager;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import entity.Login;
import entity.Score;
import manager.interfaces.LoginManager;

public class LoginManagerMemory implements LoginManager{
    
    private ArrayList<Login> db;
    private int lastId = 1;

    public LoginManagerMemory(){
        this.db = new ArrayList<Login>();
    }

    //cria um login na tabela do db
    public int add_login(Login login){
        this.db.add(login);
        return getNextId();
    }

    private int getNextId(){
        this.lastId++;
        return this.lastId;
    }

    private int find_index_by_id(int id) throws NoSuchElementException {
        for (int i = 0; i<db.size(); i++){
            if (this.db.get(i).getId() == id) {
                return i;
            }            
        }
        throw new NoSuchElementException();
    }

    //Pega os dados do login pelo id e retorna um objeto daquele tipo
    public Login read_login(int id){
        try {
            int index = find_index_by_id(id);
            return this.db.get(index);
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    //Altera os dados do login pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_login(Login login){
        int index = find_index_by_id(login.getId());
        
        this.db.get(index).setUserId(login.getUserId());
        this.db.get(index).setDataHora(login.getDataHora());
    }

    //Deleta o login pelo id
    public void delete(int id){
        this.db.remove(find_index_by_id(id));
    }

    //Deleta o login pelo login
    public void delete(Login login){
        this.db.remove(find_index_by_id(login.getId()));
    }

    public int maxId () {
        int maxId = -1;
        for (Login login : db) {
            if (login.getId()>maxId){
                maxId = login.getId();
            }
        }

        return maxId;
    }
}
