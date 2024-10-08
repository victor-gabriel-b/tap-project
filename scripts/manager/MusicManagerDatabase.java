package manager;
import java.sql.*;

import entity.Music;
import infra.Database;
import manager.interfaces.MusicManager;

public class MusicManagerDatabase implements MusicManager{

    private Database db;
    

    //Inicializador, onde pega a instância do dbe inicializa a tabela music
    public MusicManagerDatabase(){
        this.db = Database.getInstance();
        initializer();
    }

    //cria um usuário na tabela do db
    public int add_music(Music music){
            
        String sql = "INSERT INTO musics (name, link, gamename, genre, launchyear)" 
        + "VALUES"
	    + "(?,?,?,?,?) "
        + "RETURNING id";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setString(1, music.getName());
            pstmt.setString(2, music.getLink());
            pstmt.setString(3, music.getGameName());
            pstmt.setString(4, music.getGenre());
            pstmt.setInt(5, music.getLaunchYear());
            
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
    public Music read_music(int id){
        Music music = new Music(id, "", "", "", "",-1);
        String sql = "SELECT name, link, gamename, genre, launchyear FROM musics WHERE id = ?";

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            
            music.setName(rs.getString("name"));
            music.setLink(rs.getString("link"));
            music.setGameName(rs.getString("gamename"));
            music.setGenre(rs.getString("genre"));
            music.setLaunchYear(rs.getInt("launchyear"));

            pstmt.close();
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return music;

    }

    //Altera os dados do usuário pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_music(Music music){

        String sql = "UPDATE musics SET name = ?, link = ?, gamename = ?, genre = ?, launchyear = ? WHERE id = ?";

        try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setString(1, music.getName());
                pstmt.setString(2, music.getLink());
                pstmt.setString(3, music.getGameName());
                pstmt.setString(4, music.getGenre());
                pstmt.setInt(5, music.getLaunchYear());
                pstmt.setInt(6, music.getId());
                pstmt.executeUpdate();
                pstmt.close();

        } catch (SQLException e){
                e.printStackTrace();
        }
    }

    //Deleta o usuário pelo id
    public void delete(int id){
        String sql = "DELETE FROM musics WHERE id = ?";

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
    public void delete(Music music){
        String sql = "DELETE FROM musics WHERE id = ?";

            try{
                PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
                pstmt.setInt(1, music.getId());
                pstmt.executeUpdate();
                pstmt.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }

    //Inicializador da tabela dos usuários, executado pelo db
    private void initializer(){
        String sql = "CREATE TABLE IF NOT EXISTS musics ("
        + "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "	name text NOT NULL,"
        + "	link text NOT NULL,"
        + " gamename text NOT NULL,"
        + " genre text NOT NULL,"
        + " launchyear INTEGER NOT NULL"
        + ")";

        db.execute(sql);

    }
    


}