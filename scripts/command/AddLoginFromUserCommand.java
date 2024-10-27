package command;

import java.time.ZonedDateTime;

import entity.Login;
import entity.User;
import infra.DatabaseFacade;

public class AddLoginFromUserCommand implements Command{
    private String name = "AddLoginFromUser";
    private User user;

    public AddLoginFromUserCommand(User user){
        this.user = user;
    }
    public String getName(){
        return this.name;
    }

    public boolean execute(DatabaseFacade df){
        Login login = new Login(0, this.user.getId(), ZonedDateTime.now());
        return (df.getLoginManager().add_login(login)!=-1);
    }
}
