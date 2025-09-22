package Season;

public class Season extends SeasonItem {
    public final String weather;
    public final String activity;
    
    public Season(String name, int temperature, int duration, String weather, String activity) {
        super(name, temperature, duration);
        this.weather = weather;
        this.activity = activity;
    }
    
    @Override
    public String getDisplayInfo() {
        return String.format("🌟 %s - %d°C | %d months | %s", 
                           name, temperature, duration, weather);
    }
    
    @Override
    public String getDescription() {
        return String.format("Weather: %s | Best activity: %s | Duration: %d months", 
                           weather, activity, duration);
    }
    
    public String getWeather() { return weather; }
    public String getActivity() { return activity; }
}
