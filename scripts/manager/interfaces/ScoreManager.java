package manager.interfaces;

import java.util.ArrayList;
import entity.Score;

public interface ScoreManager {
    //cria um score na tabela do db
    public int add_score(Score score);

    //Pega os dados do score pelo id e retorna um objeto daquele tipo
    public Score read_score(int id);

    //Altera os dados do score pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_score(Score score);

    //Deleta o score pelo id
    public void delete(int id);

    //Deleta o score pelo score
    public void delete(Score score);      
    
    public ArrayList<Score> getScoresByUserId(int id);
}
