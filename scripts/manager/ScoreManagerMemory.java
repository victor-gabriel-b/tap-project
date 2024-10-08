package manager;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import entity.Score;
import manager.interfaces.ScoreManager;

public class ScoreManagerMemory implements ScoreManager{

        private ArrayList<Score> db;
        private int lastId = 1;

        public ScoreManagerMemory(){}

        //cria um score na tabela do db
        public int add_score(Score score){
            this.db.add(score);
            return getNextId();
        }

        private int getNextId(){
            this.lastId++;
            return this.lastId;
        }

        private int find_index_by_id(int id) throws NoSuchElementException {
            for (int i = 0; i<db.size(); i++){
                if (this.db.get(i).getId() == id) {
                    return i;
                }            
            }
            throw new NoSuchElementException();
        }

        //Pega os dados do score pelo id e retorna um objeto daquele tipo
        public Score read_score(int id){
            try {
                int index = find_index_by_id(id);
                return this.db.get(index);
            }
            catch (NoSuchElementException e) {
                return null;
            }
        }

        //Altera os dados do score pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
        public void update_score(Score score){
            int index = find_index_by_id(score.getId());
            
            this.db.get(index).setScore(score.getScore());
            this.db.get(index).setUserId(score.getUserId());
        }

        //Deleta o score pelo id
        public void delete(int id){
            this.db.remove(find_index_by_id(id));
        }

        //Deleta o score pelo score
        public void delete(Score score){
            this.db.remove(find_index_by_id(score.getId()));
        }

        public ArrayList<Score> getScoresByUserId(int id){
            ArrayList<Score> scores = new ArrayList<Score>();

            for (Score score : db) {
                if (score.getUserId() == id){
                    scores.add(score);
                }
            }

            return scores;
        }

}
