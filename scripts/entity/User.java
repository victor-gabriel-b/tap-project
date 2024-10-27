package entity;

import java.util.ArrayList;

import entity.memento.Memento;
import entity.memento.*;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    
    private ArrayList<String> state;

    public User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    ///Getters & Setters classes  
    public  void setUsername(String username){
        this.username = username;
    }
        
    public String getUsername(){
        return this.username;
    }

    public void setEmail(String email){
        this.email = email;
    }
        
    public String getEmail(){
        return this.email;
    }
        
    public void setPassword(String password){
        this.password = password;
        
    }  
        
    public String getPassword(){
        return this.password;
    }

    public void setId(int id){
        this.id = id;
    }   
        
    public int getId(){
        return this.id;
    }

    public void setState() {
        this.state.clear();
        
        this.state.add(Integer.toString(this.id));
        this.state.add(getUsername());
        this.state.add(getEmail());
        this.state.add(getPassword());
    }

    public Memento saveState() {
        return new Memento(this.state);
    }

    public void restoreState(IMemento memento) {
        var concreteMemento = (Memento)memento;
        this.state = concreteMemento.getSavedState();

        setId(Integer.valueOf(this.state.get(0)));
        setUsername(this.state.get(1));
        setEmail(this.state.get(2));
        setPassword(this.state.get(3));
    }
        
}
