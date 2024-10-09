package report;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Login;
import infra.Database;
import infra.DatabaseFacade;
import manager.interfaces.LoginManager;;

public abstract class Report {

    
    protected DatabaseFacade dbf;
    protected ArrayList<Login> loginList;
    protected LoginManager logins;
    protected int maxId;

    private void initializer(){
        this.loginList = new ArrayList<Login>();
        this.logins = dbf.getLoginManager();
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
        this.dbf = DatabaseFacade.getInstance();
    }

    //itera sobre i e pega os logins não nulos na tabela logins
    protected void getLogins(){
        //System.out.println("teste");
        //System.out.println(this.maxId);
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
        return this.logins.maxId();
    }

    protected abstract void saveReport();
    
}
