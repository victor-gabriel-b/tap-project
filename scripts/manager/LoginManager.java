package manager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Login;
import infra.Database;

public class LoginManager {
    
    private Database db;

    public LoginManager(){
        db = Database.getInstance();
        initializer();

    }

    //cria um login na tabela do db
    public int add_login(Login login){


        String sql = "INSERT INTO logins (userId, dataHora)" 
        + "VALUES"
	    + "(?,?) "
        + "RETURNING id";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, login.getUserId());
            pstmt.setString(2, login.getStringDataHora());
            
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

    //Pega os dados do login pelo id e retorna um objeto daquele tipo
    public Login read_login(int id){
        var login = new Login(id, -1, null);
        String sql = "SELECT userId, dataHora FROM logins WHERE id = ?";



        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            
            login.setStringDataHora(rs.getString("dataHora"));
            login.setUserId(rs.getInt("userId"));

            pstmt.close();
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return login;

    }

    //Altera os dados do login pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_login(Login login){

        String sql = "UPDATE logins SET userId = ?, score = ? WHERE id = ?";

        try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, login.getUserId());
                pstmt.setString(2, login.getStringDataHora());
                pstmt.setInt(3, login.getId());
                pstmt.executeUpdate();
                pstmt.close();

        } catch (SQLException e){
                e.printStackTrace();
        }
    }

    //Deleta o login pelo id
    public void delete(int id){
        String sql = "DELETE FROM logins WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                pstmt.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }

   //Deleta o login pelo id
    public void delete(Login login){
        String sql = "DELETE FROM logins WHERE id = ?";
            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, login.getId());
                pstmt.executeUpdate();
                pstmt.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }


    private void initializer(){
        String sql = "CREATE TABLE IF NOT EXISTS logins ("
        + "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "	userId INTEGER NOT NULL,"
        + "	dataHora text NOT NULL,"
        + " FOREIGN KEY(userId) REFERENCES users(id)"
        + ")";

        db.execute(sql);

    }


}
