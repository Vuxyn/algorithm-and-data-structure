import Data.Media;
import List.Manager;

public class Spotify {
    public static void main(String[] args) {
        Manager manage = new Manager();

        manage.addSong("Kimi no Namae", "Chiai Fujiwika", 192, "Anime", "J-Pop");
        manage.addSong("Shinunoga E-Wa", "Fujii Kaze", 215, "Love", "J-Pop");

        manage.addPodcast("Tech Talk Daily", "Jane Doe", 1500, "Technology", "Tech World", 45);
        manage.addPodcast("History Hour", "John Smith", 3600, "History", "Past Times", 12);

        manage.addVideo("Java Tutorial for Beginners", "Programming Hub", 3600, "1080p");
        manage.addVideo("Nature Documentary", "National Geographic", 2700, "4K");
        manage.addVideo("Cooking Masterclass", "Gordon Ramsay", 1800, "1080p");

        System.out.println("\n\n>>> Displaying All Media...");
        manage.displayAllSongs();
        manage.displayAllPodcasts();
        manage.displayAllVideos();

        System.out.println("\n\n>>> Search Operations...");
        searchSong(manage, "Shinunoga E-Wa");
        searchPodcast(manage, "History Hour");
        searchVideo(manage, "Java Tutorial for Beginners");
        
        System.out.println("\n\n>>> Search Operations Completed.");

        System.out.println("\n>>> Delete Operations...");
        manage.deleteSong("Kimi no Namae");
        manage.deletePodcast("Tech Talk Daily");
        manage.deleteVideo("Cooking Masterclass");

        System.out.println("\n\n>>> Displaying All Media After Deletions...");
        manage.displayAllSongs();
        manage.displayAllPodcasts();
        manage.displayAllVideos();

        manage.displayStatistics();
    }

    public static void searchSong(Manager manage, String title){
        Media found = manage.searchSong(title);
        if (found != null) {
            System.out.print("Found: ");
            found.display();
        }
    }
    public static void searchPodcast(Manager manage, String title){
        Media found = manage.searchPodcast(title);
        if (found != null) {
            System.out.print("Found: ");
            found.display();
        }
    }
    public static void searchVideo(Manager manage, String title){
        Media found = manage.searchVideo(title);
        if (found != null) {
            System.out.print("Found: ");
            found.display();
        }
    }
    
}
