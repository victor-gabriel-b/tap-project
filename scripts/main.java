import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import builder.ConcreteUserBuilder;
import builder.UserDirector;
import entity.Login;
import entity.Music;
import entity.Score;
import entity.User;
import infra.DatabaseFacade;
import report.CsvReport;
import report.HtmlReport;
import observer.MusicObserver;
import adapter.MusicAPI;
import adapter.YouTubeAdapter;
import adapter.SpotifyAdapter;

public class main {
    public static void main(String[] args) {

        DatabaseFacade dbf = DatabaseFacade.getInstance();
        
        manager.interfaces.UserManager users;
        users = dbf.getUserManager();
        manager.interfaces.ScoreManager scores = dbf.getScoreManager();
        manager.interfaces.MusicManager musics = dbf.getMusicManager();
        manager.interfaces.LoginManager logins = dbf.getLoginManager();

        // Adiciona um observer a MusicManager
        MusicObserver musicObserver = new MusicObserver();
        ((manager.MusicManagerDatabase) musics).addObserver(musicObserver);

        // Usa o padrao builder para criar objetos do tipo User
        UserDirector userDirector = new UserDirector(new ConcreteUserBuilder());

        User userA = userDirector.constructUser(0, "WesleySilva", "wesley.abc@hotmail.com", "Abcdefg1!");
        int id = users.add_user(userA);
        userA.setId(id);

        User userB = userDirector.constructUser(0, "WisePedrosa", "wise@it.a.coisa.com", "PAoFR@ANC3S");
        id = users.add_user(userB);
        userB.setId(id);

        Score scoreA = new entity.Score(0, 1, 5000.0);
        id = scores.add_score(scoreA);
        scoreA.setId(id);

        Score scoreB = new entity.Score(0, 1, 999.0);
        id = scores.add_score(scoreB);
        scoreB.setId(id);
    
        Score scoreC = new entity.Score(0, 2, 999.0);
        id = scores.add_score(scoreC);
        scoreC.setId(id);

        dbf.addScoreFromUser(userB, 3.0);

        Music musicA = new Music(0, "One Winged Angel", "youtube.com/mmYdf0yqK_Fc", "Final Fantasy VII", "RPG", 1997);
        id = musics.add_music(musicA);
        musicA.setId(id);

        //Music musicB = new Music(0, "The Last of Us", "youtube.com/mmYdf0yqK_Fc", "The Last of Us", "Survival Horror", 2013);

        
        for (int i = 1; i < 2; i++) {
            User user = users.read_user(i);
            System.out.println(i + " " + user.getUsername() + " " + user.getEmail() + " " + user.getPassword());
        }

        users.delete(userA);

        for (int i = 1; i < 2; i++) {
            User user = users.read_user(i);
            System.out.println(i + " " + user.getUsername() + " " + user.getEmail() + " " + user.getPassword());
        }

        ArrayList<Score> scores_user = dbf.getScoresByUsername("WisePedrosa");
        for (int i = 0; i < scores_user.size(); i++) {
            Score score = scores_user.get(i);
            System.out.println(i + " " + score.getUserId() + " " + score.getScore());
        }

        ZonedDateTime dataHora;
        var loginA = new Login(0, 1, dataHora = ZonedDateTime.now());
        id = logins.add_login(loginA);
        loginA.setId(id);


        logins.delete(id);

        // Usa o Adapter para buscar músicas no YouTube
        MusicAPI musicAPI = new YouTubeAdapter();
        List<String> searchResults = musicAPI.search("Final Fantasy VII Soundtrack");
        for (String result : searchResults) {
            System.out.println(result);
        }

        // Detalhes de um vídeo específico
        String videoDetails = musicAPI.getDetails("mmYdf0yqK_Fc");
        System.out.println(videoDetails);

        // Usa o Adapter para buscar músicas no Spotify
        musicAPI = new SpotifyAdapter();
        searchResults = musicAPI.search("Final Fantasy VII Soundtrack");
        for (String result : searchResults) {
            System.out.println(result);
        }

        // Detalhes de uma música específica
        String trackDetails = musicAPI.getDetails("track_id");
        System.out.println(trackDetails);


        HtmlReport report = new HtmlReport();
        CsvReport report2 = new CsvReport();
        
        report.generateReport();
        report2.generateReport();

    }
}
