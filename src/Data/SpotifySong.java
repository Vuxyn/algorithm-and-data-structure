package Data;

public class SpotifySong extends Song {
    public boolean isPlaying;

    public SpotifySong(String title, String artist, String album, int duration, String genre) {
        super(title, artist, album, duration, genre);
        this.isPlaying = false;
    }

    @Override
    public void play() {
        isPlaying = true;
        System.out.println("🎵 Playing: " + title + " - " + artist);
    }
    
    @Override
    public void pause() {
        isPlaying = false;
        System.out.println("⏸️  Paused: " + title + " - " + artist);
    }
    
    @Override
    public void stop() {
        isPlaying = false;
        System.out.println("⏹️  Stopped: " + title + " - " + artist);
    }
    
    public boolean isPlaying() { return isPlaying; }
    
}
