package infra;
import java.sql.Connection;
import java.util.ArrayList;

import entity.Score;
import entity.User;
import manager.LoginManager;
import manager.MusicManager;
import manager.ScoreManager;
import manager.UserManager;

public class DatabaseFacade {
    // A conexão é inicializada na primeira tentativa de acesso ao usuario

    private static DatabaseFacade instance;
    private UserManager userManager;
    private MusicManager musicManager;
    private ScoreManager scoreManager;
    private LoginManager loginManager;

    private DatabaseFacade(){
        this.userManager = new UserManager();
        this.musicManager = new MusicManager();
        this.scoreManager = new ScoreManager();
        this.loginManager = new LoginManager();
    }

    public static synchronized DatabaseFacade getInstance(){

        if (instance == null){
            instance = new DatabaseFacade();
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

    public int addScoreFromUser(User user, Double score){
        Score scoreObject = new Score(0, user.getId(), score);
        return this.scoreManager.add_score(scoreObject);
    }

}