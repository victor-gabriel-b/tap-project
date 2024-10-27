package manager.interfaces;

import entity.Music;
import observer.Observer;

public interface MusicManager {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    //cria um music na tabela do db
    public int add_music(Music music);

    //Pega os dados do music pelo id e retorna um objeto daquele tipo
    public Music read_music(int id);

    //Altera os dados do music pelo id, onde se não quiser alterar um dos dados é só passar uma string vazia
    public void update_music(Music music);

    //Deleta o music pelo id
    public void delete(int id);

    //Deleta o music pelo music
    public void delete(Music music);    
}
