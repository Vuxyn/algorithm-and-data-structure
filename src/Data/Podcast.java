package Data;

public class Podcast extends Media {
    public String host;
    public String category;
    public int episode;

    public Podcast(String title, String artist, int duration, String host, String category, int episode){
        super(title, artist, duration);
        this.host = host;
        this.category = category;
        this.episode = episode;
    }

    @Override
    public String getType() { return "Podcast"; }
    
    @Override
    public void display() {
        System.out.println("[PODCAST] Episode " + episode + ": " + title + 
                         " | Host: " + host + " | Category: " + category + 
                         " | Duration: " + getFormattedDuration());
    }
}
