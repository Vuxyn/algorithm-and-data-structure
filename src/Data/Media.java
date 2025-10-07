package Data;

public abstract class Media {
    public String title;
    public String artist;
    public int duration;

    public Media(String title, String artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public abstract String getType();
    public abstract void display();

    public String getFormattedDuration(){
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + ":" + (seconds < 10 ? "0" + seconds : seconds);
    }
}
