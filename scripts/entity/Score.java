package entity;
public class Score{

    private int id;
    private int userId;
    private Double score;

    public Score(int id, int userId, Double score){
        this.userId = userId;
        this.score = score;
        this.id = id;
        
    }

    public Double getScore(){
        return this.score;
    }

    public void setScore(Double score){
        this.score = score;
    }

    public int getUserId(){
        return this.userId;
    }

    public void setUserId(int userId){
        this.userId = userId;

    }

    public void setId(int id){
        this.id = id;
    }   
        
    public int getId(){
        return this.id;
    }


    
}