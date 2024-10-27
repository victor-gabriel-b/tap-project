package adapter;

import java.util.ArrayList;
import java.util.List;

//classes que implementem a interface target e adaptem as chamadas para a API específica
public class YouTubeAdapter implements MusicAPI {
    // Simulação de uma API do YouTube
    private YouTubeAPI youTubeAPI;

    public YouTubeAdapter() {
        this.youTubeAPI = new YouTubeAPI();
    }

    @Override
    public List<String> search(String query) {
        // Adapta a chamada para a API do YouTube
        return youTubeAPI.searchVideos(query);
    }

    @Override
    public String getDetails(String id) {
        // Adapta a chamada para a API do YouTube
        return youTubeAPI.getVideoDetails(id);
    }
}

// Simulação de uma API do YouTube
class YouTubeAPI {
    public List<String> searchVideos(String query) {
        // Simula a busca de vídeos no YouTube
        List<String> results = new ArrayList<>();
        results.add("Video 1: " + query);
        results.add("Video 2: " + query);
        return results;
    }

    public String getVideoDetails(String id) {
        // Simula a obtenção de detalhes de um vídeo no YouTube
        return "Detalhes do vídeo com ID: " + id;
    }
}
