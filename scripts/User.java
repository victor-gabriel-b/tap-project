public class User {

    private int id;
    private String username;
    private String email;
    private String password;

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
        
}
