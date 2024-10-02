import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Report {

    
    protected Database db;
    protected ArrayList<Login> loginList;
    protected LoginManager logins;
    protected int maxId;

    private void initializer(){
        this.loginList = new ArrayList<Login>();
        this.logins = new LoginManager();
        this.maxId = max();
    }

    //Método que é pra ser chamado
    public void generateReport(){
        connect();
        initializer();
        getLogins();
        saveReport();
    }


    //conecta com o db
    protected void connect(){
        this.db = Database.getInstance();
    }

    //itera sobre i e pega os logins não nulos na tabela logins
    protected void getLogins(){

        for(int i = 1; i <= this.maxId; i++){
            var login = logins.read_login(i);

            if(login.getDataHora() == null){
                continue;
            } else {
                loginList.add(login);
            }

        }
    }

    //pega o valor máximo de id da tabela logins
    protected int max(){
        String sql = "SELECT id FROM logins ORDER BY id DESC LIMIT 1";
        int id;

        try{
            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            id = rs.getInt("id");

            rs.close();
            pstmt.close();

            
        } catch(SQLException e){
            e.printStackTrace();
            id = -1;
        }
        

        return id;
    }

    protected abstract void saveReport();
    
}
