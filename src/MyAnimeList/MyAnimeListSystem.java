package MyAnimeList;
import java.util.Scanner;

public class MyAnimeListSystem {
    public static Scanner scanner = new Scanner(System.in);
    public static AnimeList myList = new AnimeList();

    public static void main(String[] args) {
        System.out.println("MY ANIME LIST MANAGEMENT SYSTEM");
        System.out.println("=".repeat(40));

        myList.addAnime("Attack on Titan", "Mappa", 2013, 87, "Completed");
        myList.addAnime("One Piece", "Toei Animation", 1999, 1000, "Ongoing");
        myList.addManga("Demon Slayer", "Shueisha", 2016, 205, "Completed", "Koyoharu Gotouge");
        myList.addAnime("Naruto", "Pierrot", 2002, 720, "Completed");
        myList.addAnime("Re:zero", "White Fox", 2016, 90, "Ongoing");
        myList.addManga("Jujutsu Kaisen", "Shueisha", 2020, 170, "Completed", "Gege Akutami");

        System.out.println("Sample dataset added to your list");

        boolean running = true;
        while(running){
            showMenu();
            int choice = getInput("Choose your option: ");

            switch(choice) {
                case 1: addAnime(); break;
                case 2: addManga(); break;
                case 3: removeMedia(); break;
                case 4: searchMedia(); break;
                case 5: myList.displayAll(); break;
                case 6: showByCategory(); break;
                case 7: myList.showStatistics(); break;
                case 8: 
                    running = false;
                    System.out.println("Arigatou Gozaimashita, See You!");
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }
    public static void showMenu() {
        System.out.println("\n" + "=".repeat(35));
        System.out.println("🎌 MY ANIME LIST MENU:");
        System.out.println("1.  Add Anime Series");
        System.out.println("2.  Add Manga");
        System.out.println("3.  Remove from List");
        System.out.println("4.  Search Title");
        System.out.println("5.  Show My Complete List");
        System.out.println("6.  Filter by Category");
        System.out.println("7.  Show Statistics");
        System.out.println("8.  Exit");
        System.out.println("=".repeat(35));
    }

    public static void addAnime() {
        System.out.println("\n🎌 ADD NEW ANIME:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Studio: ");
        String studio = scanner.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Episodes: ");
        int episodes = Integer.parseInt(scanner.nextLine());
        System.out.print("Status (Ongoing/Completed/On Hold): ");
        String status = scanner.nextLine();
        
        myList.addAnime(title, studio, year, episodes, status);
    }

    public static void addManga() {
        System.out.println("\n📚 ADD NEW MANGA:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Chapters: ");
        int chapters = Integer.parseInt(scanner.nextLine());
        System.out.print("Status (Ongoing/Completed/Hiatus): ");
        String status = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        
        myList.addManga(title, publisher, year, chapters, status, author);
    }

    public static void removeMedia() {
        if (myList.isEmpty()) {
            System.out.println("Your list is empty!");
            return;
        }
        System.out.print("Title to remove: ");
        String title = scanner.nextLine();
        myList.removeMedia(title);
    }
    
    public static void searchMedia() {
        if (myList.isEmpty()) {
            System.out.println("Your list is empty!");
            return;
        }
        System.out.print("Search title: ");
        String title = scanner.nextLine();
        myList.searchMedia(title);
    }

    public static void showByCategory() {
        if (myList.isEmpty()) {
            System.out.println("Your list is empty!");
            return;
        }
        System.out.println("Categories:");
        System.out.println("1. Anime");
        System.out.println("2. Manga");
        int choice = getInput("Choose category: ");
        
        switch (choice) {
            case 1: myList.showByCategory("ANIME"); break;
            case 2: myList.showByCategory("MANGA"); break;
            default: System.out.println("Invalid choice!");
        }
    }
    
    public static int getInput(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

}
