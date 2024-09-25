import java.util.ArrayList;

public class Music{

    private String link;
    private String name;
    private String gameName;
    private ArrayList<String> genre;
    private int launchYear;

    public Music(String link, String name, String gameName, ArrayList<String> genre, int launchYear){

        this.link = link;
        this.name = name;
        this.gameName = gameName;
        this.genre = genre;
        this.launchYear = launchYear;
        
    }

    //Getters and Setters

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    
    

}