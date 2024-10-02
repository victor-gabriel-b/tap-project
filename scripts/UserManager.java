import java.sql.*;

public class UserManager{

    private Database db;
    private LoginValidation lv;
    

    //Inicializador, onde pega a instância do db, cria uma instância da classe LoginValidation e inicializa a tabela usuário
    public UserManager(){
        this.db = Database.getInstance();
        this.lv = new LoginValidation();
        initializer();
    }

    //cria um usuário na tabela do db
    public int add_user(User user){
        try{
            lv.userValidation(user.getUsername(), user.getPassword());

        }catch (Exception e) {
            e.printStackTrace();
        }
            
        String sql = "INSERT INTO users (username, email, password)" 
        + "VALUES"
	    + "(?,?,?) "
        + "RETURNING id";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            
            ResultSet rs = pstmt.executeQuery();

            int id = rs.getInt("id");
            pstmt.close();
            rs.close();
            return id;
            

        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return -1;
    }

    //Pega os dados do usuários pelo id e retorna um objeto daquele tipo
    public User read_user(int id){
        User user = new User(id, "", "", "");
        String sql = "SELECT username, email, password FROM users WHERE id = ?";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));

            pstmt.close();
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return user;

    }

    public User read_username(String username){
        User user = new User(-1, username, "", "");
        String sql = "SELECT id, email, password FROM users WHERE username = ?";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));

            pstmt.close();
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return user;
    
    }

    //Altera os dados do usuário pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_user(User user){

        String sql = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";

        try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getEmail());
                pstmt.setString(3, user.getPassword());
                pstmt.setInt(4, user.getId());
                pstmt.executeUpdate();
                pstmt.close();

        } catch (SQLException e){
                e.printStackTrace();
        }
    }

    //Deleta o usuário pelo id
    public void delete(int id){
        String sql = "DELETE FROM users WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                pstmt.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }

   //Deleta o usuário pelo id
    public void delete(User user){
        String sql = "DELETE FROM users WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, user.getId());
                pstmt.executeUpdate();
                pstmt.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }  

    //Inicializador da tabela dos usuários, executado pelo db
    private void initializer(){
        String sql = "CREATE TABLE IF NOT EXISTS users ("
        + "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "	username text NOT NULL,"
        + "	email text NOT NULL,"
        + " password text NOT NULL"
        + ")";

        db.execute(sql);

    }
    


}
