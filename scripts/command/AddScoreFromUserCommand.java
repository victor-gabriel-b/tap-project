package command;

import entity.Score;
import entity.User;
import infra.DatabaseFacade;

public class AddScoreFromUserCommand implements Command {
    private String name = "AddScoreFromUser";
    private User user;
    private Double score;
    
    public AddScoreFromUserCommand(User user, Double scoreNumber){
        this.user = user;
        this.score = scoreNumber;        
    }

    public String getName(){
        return this.name;
    }

    public boolean execute(DatabaseFacade df){
        Score scoreObject = new Score(0, this.user.getId(), this.score);
        return (df.getScoreManager().add_score(scoreObject)!=1);        
    }

}
