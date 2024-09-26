import java.util.ArrayList;
import java.sql.*;

public class Database{
    
    private ArrayList<String> users;
    private Connection connection;

    private static Database instance;

    private Database(){
        this.connection = this.getConnection();

        this.users = new ArrayList<>();
    }

    public static synchronized Database getInstance(){

        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection(){
        try {
            // Cria a conexão com o banco de dados
            Connection a = DriverManager.getConnection("jdbc:sqlite:base.db");
            return a;
        }
        catch (SQLException e){
           System.exit(0);
        }

        return null;
    }

    public void execute(String sql){
        try {
            Statement stmt = this.connection.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    
    /* 
    public void createTables(){
        String sql = "CREATE TABLE IF NOT EXISTS users ("
        + "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "	username text NOT NULL,"
        + "	email REAL NOT NULL"
        + " password text NOT NULL"
        + ");";
        try {
            Statement stmt = this.connection.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    */

    /* 
    public int add(String user){
        String sql = "INSERT INTO users (username, email, password)" 
        + "VALUES"
	    + "(\"\",)";
        try {
            Statement stmt = this.connection.createStatement() 
            stmt.execute(sql);
        }
        catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    */


    public void read(int id){

        if(0 <= id && id < getLenght()){

            System.out.printf("{id} | {self.users[id].username} | {self.users[id].email}");
            
        } else{
            
            System.out.println("ID Inválido");
        }
        
    }
    
    public int getLenght(){
        
        return this.users.size();
    }
        
    
}