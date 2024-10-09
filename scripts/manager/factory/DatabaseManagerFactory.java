package manager.factory;

import manager.LoginManagerDatabase;
import manager.MusicManagerDatabase;
import manager.ScoreManagerDatabase;
import manager.UserManagerDatabase;

public class DatabaseManagerFactory implements ManagerFactory{
    public DatabaseManagerFactory(){}
    public LoginManagerDatabase createLoginManager(){
        return new LoginManagerDatabase();
    }
    public MusicManagerDatabase createMusicManager(){
        return new MusicManagerDatabase();
    }
    public ScoreManagerDatabase createScoreManager(){
        return new ScoreManagerDatabase();
    }
    public UserManagerDatabase createUserManager(){
        return new UserManagerDatabase();
    }    
}
