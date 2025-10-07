package Data;

public class Song extends Media{
    public String album;
    public String genre;

    public Song(String title, String artist, int duration, String album, String genre){
        super(title, artist, duration);
        this.album = album;
        this.genre = genre;
    }

    @Override
    public String getType(){ return "Song"; }

    @Override
    public void display(){ System.out.println("[SONG] " + title + " - " + artist + " | Album: " + album + 
                         " | Genre: " + genre + " | Duration: " + getFormattedDuration());}

}
