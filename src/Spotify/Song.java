package Spotify;

public class Song extends Media{
    String album;
    String genre;
    
    public Song(String title, String artist, int duration, String album, String genre) {
        super(title, artist, duration);
        this.album = album;
        this.genre = genre;
    }

    @Override
    public String getDisplayInfo() {
        return String.format("♪ %s - %s [%s] (%s) - %s", 
                           title, artist, album, genre, formatDuration());
    }

    @Override
    public String getType() {
        return "Song";
    }

    public String getAlbum() { return album; }
    public String getGenre() { return genre; }
}
