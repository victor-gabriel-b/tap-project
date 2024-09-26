import java.sql.*;
import java.util.ArrayList;

public class UserManager{

    private Database db;
    private LoginValidation lv;
    

    //Inicializador, onde pega a instância do db, cria uma instância da classe LoginValidation e inicializa a tabela usuário
    public UserManager(){
        this.db = Database.getInstance();
        this.lv = new LoginValidation();
        inicializer();
    }

    //cria um usuário na tabela do db
    public void add(String username, String email, String password){
        try{
            lv.userValidation(username, password);

        }catch (Exception e) {
            e.printStackTrace();
        }
            
        String sql = "INSET INTO users (username, email, password)" 
        + "VALUES"
	    + "(?,?,?)";

        try{
        PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, email);
        pstmt.setString(3, password);
        pstmt.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }


    }

    //Pega os dados do usuários pelo id e retorna eles em forma de ArrayList, onde 0 é username, 1 é email e 2 é password
    public ArrayList<String> read(int id){
        ArrayList<String> user = new ArrayList<String>();
        String sql = "SELECT username, email, password FROM users WHERE id = ?" 
        + "VALUES"
	    + "(?,?,?)";

        try{
            Statement stat = db.getConnection().createStatement();
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            ResultSet rs = stat.executeQuery(sql);

            
            user.add(rs.getString("username"));
            user.add(rs.getString("email"));
            user.add(rs.getString("password"));

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        

        return user;

    }

    //Altera os dados do usuário pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update(int id, String username, String email, String password){

        if(username.isEmpty() == false){
            String sql = "UPDATE users SET username = ? WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(email.isEmpty() == false){
            String sql = "UPDATE users SET email = ? WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setString(1, email);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(password.isEmpty() == false){
            String sql = "UPDATE users SET password = ? WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setString(1, password);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    //Deleta o usuário pelo id
    public void delete(int id){
        String sql = "DELETE FROM users WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }


    //Inicializador da tabela dos usuários, executado pelo db
    private void inicializer(){
        String sql = "CREATE TABLE IF NOT EXISTS users ("
        + "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "	username text NOT NULL,"
        + "	email text NOT NULL"
        + " password text NOT NULL"
        + ");";

        db.execute(sql);

    }
    


}
