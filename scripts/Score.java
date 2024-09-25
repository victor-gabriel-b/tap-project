public class Score{

    private String nickname;
    private float score;

    public Score(String nickname, float score){
        this.nickname = nickname;
        this.score = score;
        
    }

    public float getScore(){
        return this.score;
    }

    public void setScore(float score){
        this.score = score;
    }

    public String getNickname(){
        return this.nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;

    }




    
}