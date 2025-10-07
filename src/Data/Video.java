package Data;

public class Video extends Media {
    public String channel;
    public String resolution;
    public long views;
    
    public Video(String title, String channel, int duration, String resolution) {
        super(title, channel, duration);
        this.channel = channel;
        this.resolution = resolution;
        this.views = 0;
    }
    
    @Override
    public String getType() {
        return "Video";
    }
    
    @Override
    public void display() {
        System.out.println("[VIDEO] " + title + " | Channel: " + channel + 
                         " | Resolution: " + resolution + " | Duration: " + getFormattedDuration() + 
                         " | Views: " + views);
    }
    
    public void watch() {
        views++;
        System.out.println("Watching: " + title + " (Views: " + views + ")");
    }
    
}
