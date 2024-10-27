package infra;
import java.util.ArrayList;

import command.Command;
import entity.Score;
import entity.User;
import manager.interfaces.*;
import manager.factory.DatabaseManagerFactory;
import manager.factory.ManagerFactory;

public class DatabaseFacade {
    private static DatabaseFacade instance;
    private UserManager userManager;
    private MusicManager musicManager;
    private ScoreManager scoreManager;
    private LoginManager loginManager;

    private DatabaseFacade(ManagerFactory factory){
        this.userManager = factory.createUserManager();
        this.musicManager = factory.createMusicManager();
        this.scoreManager = factory.createScoreManager();
        this.loginManager = factory.createLoginManager();
    }

    // Create the instance if it does not exist. Return it if it does.
    public static synchronized DatabaseFacade getInstance(){
        if (instance == null){
            DatabaseManagerFactory factory = new DatabaseManagerFactory();
            instance = new DatabaseFacade(factory);  // DatabaseManagerFactory is the default Manager factory
        }

        return instance;
    }

    // Creates the managers with the desired factory, if it does not exist
    public static synchronized DatabaseFacade getInstance(ManagerFactory factory){

        if (instance == null){
            instance = new DatabaseFacade(factory);
        }

        return instance;
    }

    public UserManager getUserManager(){
        return this.userManager;
    }

    public MusicManager getMusicManager(){
        return this.musicManager;
    }

    public ScoreManager getScoreManager(){
        return this.scoreManager;
    }

    public LoginManager getLoginManager(){
        return this.loginManager;
    }

    public ArrayList<Score> getScoresByUsername(String username){
        User user = this.userManager.read_username(username);
        int id = user.getId();
        return scoreManager.getScoresByUserId(id);
    }

    public boolean execute(Command c){
        return c.execute(this);
    }
}