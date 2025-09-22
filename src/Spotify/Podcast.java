package Spotify;

public class Podcast extends Media {
    String episode;
    String description;
    
    public Podcast(String title, String artist, int duration, String episode, String description) {
        super(title, artist, duration);
        this.episode = episode;
        this.description = description;
    }

    @Override
    public String getDisplayInfo() {
        return String.format("🎙 %s - %s [%s] (%s) - %s", 
                           title, artist, episode, description, formatDuration());
    }

    @Override
    public String getType() {
        return "Podcast";
    }

    public String getEpisode() { return episode; }
    public String getDescription() { return description; }
    
}
