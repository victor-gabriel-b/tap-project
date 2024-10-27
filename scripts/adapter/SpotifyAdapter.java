package adapter;

import java.util.ArrayList;
import java.util.List;

public class SpotifyAdapter implements MusicAPI {
    private SpotifyAPI spotifyAPI;

    public SpotifyAdapter() {
        this.spotifyAPI = new SpotifyAPI();
    }

    @Override
    public List<String> search(String query) {
        return spotifyAPI.searchTracks(query);
    }

    @Override
    public String getDetails(String id) {
        return spotifyAPI.getTrackDetails(id);
    }
}

class SpotifyAPI {
    public List<String> searchTracks(String query) {
        List<String> results = new ArrayList<>();
        results.add("Spotify Track 1: " + query);
        results.add("Spotify Track 2: " + query);
        return results;
    }

    public String getTrackDetails(String id) {
        return "Detalhes da faixa Spotify com ID: " + id;
    }
}
