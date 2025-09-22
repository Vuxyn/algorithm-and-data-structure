package Season;

public abstract class SeasonItem {
    public String name;
    public int temperature;
    public int duration;

    public SeasonItem(String name, int temperature, int duration) {
        this.name = name;
        this.temperature = temperature;
        this.duration = duration;
    }

    public abstract String getDisplayInfo();
    public abstract String getDescription();
    
    public String getName() { return name; }
    public int getTemperature() { return temperature; }
    public int getDuration() { return duration; }
}
