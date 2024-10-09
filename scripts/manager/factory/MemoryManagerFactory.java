package manager.factory;

import manager.LoginManagerMemory;
import manager.MusicManagerMemory;
import manager.ScoreManagerMemory;
import manager.UserManagerMemory;

public class MemoryManagerFactory implements ManagerFactory{
    public MemoryManagerFactory(){}
    public LoginManagerMemory createLoginManager(){
        return new LoginManagerMemory();
    }
    public MusicManagerMemory createMusicManager(){
        return new MusicManagerMemory();
    }
    public ScoreManagerMemory createScoreManager(){
        return new ScoreManagerMemory();
    }
    public UserManagerMemory createUserManager(){
        return new UserManagerMemory();
    }
}
