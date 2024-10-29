package manager;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import entity.User;

import manager.interfaces.UserManager;
import validation.UserValidation;

public class UserManagerMemory implements UserManager{

    private ArrayList<User> db;
    private UserValidation lv;

    private int lastId = 0;

    public UserManagerMemory(){
        this.lv = new LoginValidation();
        this.db = new ArrayList<User>();
    }

    //cria um user na tabela do db
    public int add_user(User user){
        try{
            lv.userValidation(user.getUsername(), user.getPassword());

        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setId(getNextId());
        this.db.add(user);
        
        return user.getId();
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

    private int find_index_by_username(String username) throws NoSuchElementException {
        for (int i = 0; i<db.size(); i++){
            if (this.db.get(i).getUsername() == username) {
                return i;
            }            
        }
        throw new NoSuchElementException();
    }

    //Pega os dados do user pelo id e retorna um objeto daquele tipo
    public User read_user(int id){
        System.out.println(db.size());
        try {
            int index = find_index_by_id(id);
            return this.db.get(index);
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    //Altera os dados do user pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_user(User user){
        int index = find_index_by_id(user.getId());
        
        this.db.get(index).setEmail(user.getEmail());
        this.db.get(index).setPassword(user.getPassword());
        this.db.get(index).setUsername(user.getUsername());
    }

    //Deleta o user pelo id
    public void delete(int id){
        this.db.remove(find_index_by_id(id));
    }

    public User read_username(String username){
        try {
            int index = find_index_by_username(username);
            return this.db.get(index);
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    //Deleta o user pelo user
    public void delete(User user){
        this.db.remove(find_index_by_id(user.getId()));
    }
    


}
