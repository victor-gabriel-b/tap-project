package manager.factory;

import manager.interfaces.*;

public interface ManagerFactory {
    public LoginManager createLoginManager();
    public MusicManager createMusicManager();
    public ScoreManager createScoreManager();
    public UserManager createUserManager();   
}
