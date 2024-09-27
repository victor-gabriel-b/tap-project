import java.sql.*;
import java.util.ArrayList;

public class ScoreManager{

    private Database db;
    

    //Inicializador, onde pega a instância do db e inicializa a tabela score
    public ScoreManager(){
        this.db = Database.getInstance();
        initializer();
    }

    //cria um usuário na tabela do db
    public int add_score(Score score){

        String sql = "INSERT INTO scores (userId, score)" 
        + "VALUES"
	    + "(?,?) "
        + "RETURNING id";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, score.getUserId());
            pstmt.setDouble(2, score.getScore());
            
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
    public Score read_score(int id){
        Score score = new Score(id, 0, 0.0);
        String sql = "SELECT userId, score FROM scores WHERE id = ?";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            
            score.setScore(rs.getDouble("score"));
            score.setUserId(rs.getInt("userId"));

            pstmt.close();
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return score;

    }

    //Altera os dados do usuário pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_score(Score score){

        String sql = "UPDATE scores SET userId = ?, score = ? WHERE id = ?";

        try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, score.getUserId());
                pstmt.setDouble(2, score.getScore());
                pstmt.setInt(3, score.getId());
                pstmt.executeUpdate();
                pstmt.close();

        } catch (SQLException e){
                e.printStackTrace();
        }
    }

    //Deleta o usuário pelo id
    public void delete(int id){
        String sql = "DELETE FROM scores WHERE id = ?";

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
    public void delete(Score score){
        String sql = "DELETE FROM scores WHERE id = ?";
            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, score.getId());
                pstmt.executeUpdate();
                pstmt.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }

    public ArrayList<Score> getScoresByUserId(int id){
        ArrayList<Score> scores = new ArrayList<Score>();

        String sql = "SELECT userId, score FROM scores WHERE userId = ?";

        Score score;

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                score = new Score(id, 0, 0.0);
                
                score.setScore(rs.getDouble("score"));
                score.setUserId(rs.getInt("userId")); 
                
                scores.add(score);
            }

            pstmt.close();
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return scores;        
    }

    //Inicializador da tabela dos usuários, executado pelo db
    private void initializer(){
        String sql = "CREATE TABLE IF NOT EXISTS scores ("
        + "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "	userId INTEGER NOT NULL,"
        + "	score REAL NOT NULL,"
        + " FOREIGN KEY(userId) REFERENCES users(id)"
        + ")";

        db.execute(sql);

    }
    


}
