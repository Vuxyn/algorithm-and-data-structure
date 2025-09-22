package MyAnimeList;

public class Media {
    public String title;
    public String studio;
    public int year;
    public int id;
    public int idCounter = 1001;

    public Media(String title, String studio, int year) {
        this.title =  title;
        this.studio = studio;
        this.year = year;
        this.id = ++idCounter;
    }

    public String getTitle() { return title; }
    public String getStudio() { return studio; }
    public int getYear() { return year; }
    public int getId() { return id; }
    public void displayInfo() {
         System.out.printf("ID: %d | Title: %-20s | Studio: %-15s | Year: %d", 
                         id, title, studio, year);
    }
    public String getType() { return "MEDIA"; }
    public String getDetails() { return "Basic Media"; }
}
