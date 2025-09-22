package MyAnimeList;

public class Manga extends Media {
    public String mangaStatus;
    public int chapters;
    public String author;

    public Manga(String title, String studio, int year, int chapters, String mangaStatus, String author){
        super(title, studio, year);
        this.mangaStatus = mangaStatus;
        this.chapters = chapters;
        this.author = author;
    }
    
    //DISPLAY
    public int getChapters() { return chapters; }
    public String getAuthor() { return author; }
    public String getMangaStatus() { return mangaStatus; }

    //UPDATE
    public void setChapters(int chapters) { this.chapters = chapters; }
    public void setAuthor(String author) { this.author = author; }
    public void setMangaStatus(String mangaStatus) { this.mangaStatus = mangaStatus; }

    @Override
    public String getType() { return "MANGA"; }

    @Override
    public String getDetails() { 
        return chapters + " chapters, " + mangaStatus + ", Author: " + author;
    }

    @Override
    public void displayInfo(){
        System.out.printf("ID: %d | Title: %-20s | Studio: %-15s | Year: %d | Type: %-8s | Details: %s\n", 
                         id, title, studio, year, getType(), getDetails());
    }

}
