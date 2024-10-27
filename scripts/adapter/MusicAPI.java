package adapter;

import java.util.List;

//interface que define os métodos que o sistema espera usar para se comunicar com APIs de música
public interface MusicAPI {
    List<String> search(String query);
    String getDetails(String id);
}

