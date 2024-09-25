public class UserManager {

    private Database db;
    private LoginValidation lv;
    
    public UserManager(){
        this.db = Database.getInstance();
        this.lv = new LoginValidation();
    }

    public void add_user(String username, String email, String password){
        try{
            lv.userValidation(username, password);
        catch (Exception e) {
            e.printStackTrace();
        }
            
    
        User user = new User(-1, username, email, password);
        
        int id = this.db.add(user);
    
        user.setId(id);
        }
            
    }
}
