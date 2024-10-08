package entity;

public class Music{

    private int id;
    private String link;
    private String name;
    private String gameName;
    private String genre;
    private int launchYear;

    public Music(int id, String name, String link, String gameName, String genre, int launchYear){

        this.id = id;
        this.link = link;
        this.name = name;
        this.gameName = gameName;
        this.genre = genre;
        this.launchYear = launchYear;
        
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    
    

}