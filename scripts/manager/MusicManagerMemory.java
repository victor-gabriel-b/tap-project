package manager;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import entity.Music;
import manager.interfaces.MusicManager;

public class MusicManagerMemory implements MusicManager{

    private ArrayList<Music> db;
    private int lastId = 1;

    public MusicManagerMemory(){
        this.db = new ArrayList<Music>();
    }

    //cria um music na tabela do db
    public int add_music(Music music){
        this.db.add(music);
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

    //Pega os dados do music pelo id e retorna um objeto daquele tipo
    public Music read_music(int id){
        try {
            int index = find_index_by_id(id);
            return this.db.get(index);
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    //Altera os dados do music pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_music(Music music){
        int index = find_index_by_id(music.getId());
        
        this.db.get(index).setGameName(music.getGameName());
        this.db.get(index).setGenre(music.getGenre());
        this.db.get(index).setLaunchYear(music.getLaunchYear());
        this.db.get(index).setLink(music.getLink());
        this.db.get(index).setName(music.getName());
    }

    //Deleta o music pelo id
    public void delete(int id){
        this.db.remove(find_index_by_id(id));
    }

    //Deleta o music pelo music
    public void delete(Music music){
        this.db.remove(find_index_by_id(music.getId()));
    }
    


}