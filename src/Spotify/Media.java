package Spotify;

public abstract class Media {
    String title;
    String artist;
    int duration;

    public Media(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public abstract String getDisplayInfo();
    public abstract String getType();

    public String getTitle(){ return title; }
    public String getArtist(){ return artist; }
    public int getDuration(){ return duration; }

    public String formatDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}
