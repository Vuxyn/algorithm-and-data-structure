package MyAnimeList;

public class Anime extends Media {
    public int episodes;
    public String status;
    public double rating;

    public Anime(String title, String studio, int year, int episodes, String status) {
        super(title, studio, year);
        this.episodes = episodes;
        this.status = status;
        this.rating = 0.0;
    }
    
    //DISPLAY
    public int getEpisodes() { return episodes; }
    public String getStatus() { return status; }
    public double getRating() { return rating; }

    //UPDATE
    public void setEpisodes(int episodes) { this.episodes = episodes; }
    public void setStatus(String status) { this.status = status; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String getDetails(){
        return episodes + " eps, " + status + ", Rating: " + rating + "/10";
    }

    @Override
    public void displayInfo() {
        System.out.printf("ID: %d | Title: %-20s | Studio: %-15s | Year: %d | Type: %-8s | Details: %s\n", 
                         id, title, studio, year, getType(), getDetails());
    }

    @Override
    public String getType() { return "ANIME"; }
}
