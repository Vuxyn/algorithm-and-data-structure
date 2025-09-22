package Spotify;

import java.util.Scanner;

public class Spotify {
    static DoublyLinkedlist playlist = new DoublyLinkedlist();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SampleData();
        System.out.println("🎵 Welcome to Music Playlist Manager 🎵");

        boolean running = true;
        while(running) {
            displayMenu();
            int choice = getIntInput("Choose your option: ");

            switch(choice) {
                case 1: addNewSong(); break;
                case 2: addNewPodcast(); break;
                case 3: removeItem(); break;
                case 4: playlist.displayPlaylist(); break;
                case 5: playNext(); break;
                case 6: playPrevious(); break;
                case 7: showCurrentlyPlaying(); break;
                case 8: searchItems(); break;
                case 9: playlist.shuffle(); break;
                case 0: 
                    running = false;
                    System.out.println("Thank you for using Music Playlist Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    static void displayMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         MUSIC PLAYLIST MENU");
        System.out.println("=".repeat(40));
        System.out.println("1. Add New Song");
        System.out.println("2. Add New Podcast");
        System.out.println("3. Remove Item");
        System.out.println("4. Show Playlist");
        System.out.println("5. Play Next ▶");
        System.out.println("6. Play Previous ◀");
        System.out.println("7. Currently Playing");
        System.out.println("8. Search");
        System.out.println("9. Shuffle Playlist 🔀");
        System.out.println("0. Exit");
        System.out.println("=".repeat(40));
    }

    static void addNewSong() {
        System.out.println("\n=== ADD NEW SONG ===");
        System.out.print("Song title: ");
        String title = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Album: ");
        String album = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        int duration = getIntInput("Duration (in seconds): ");
        
        Song song = new Song(title, artist, duration, album, genre);
        
        System.out.println("Add to: 1. End of playlist  2. Beginning of playlist");
        int position = getIntInput("Choice: ");
        
        if (position == 1) {
            playlist.addToEnd(song);
        } else {
            playlist.addToBeginning(song);
        }
    }

    static void addNewPodcast() {
        System.out.println("\n=== ADD NEW PODCAST ===");
        System.out.print("Podcast title: ");
        String title = scanner.nextLine();
        System.out.print("Host/Creator: ");
        String host = scanner.nextLine();
        System.out.print("Episode: ");
        String episode = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        int duration = getIntInput("Duration (in seconds): ");
        
        Podcast podcast = new Podcast(title, host, duration, episode, description);
        
        System.out.println("Add to: 1. End of playlist  2. Beginning of playlist");
        int position = getIntInput("Choice: ");
        
        if (position == 1) {
            playlist.addToEnd(podcast);
        } else {
            playlist.addToBeginning(podcast);
        }
    }

    static void removeItem() {
        if (playlist.isEmpty()) {
            System.out.println("❌ Playlist is empty!");
            return;
        }
        
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();
        playlist.remove(title);
    }

    static void playNext() {
        if (playlist.next()) {
            System.out.println("⏭ Playing next: " + playlist.getCurrentItem().getTitle());
        } else {
            System.out.println("❌ No next item available");
        }
    }

    static void playPrevious() {
        if (playlist.previous()) {
            System.out.println("⏮ Playing previous: " + playlist.getCurrentItem().getTitle());
        } else {
            System.out.println("❌ No previous item available");
        }
    }

    static void showCurrentlyPlaying() {
        Media current = playlist.getCurrentItem();
        if (current != null) {
            System.out.println("\n🎵 NOW PLAYING 🎵");
            System.out.println(current.getDisplayInfo());
        } else {
            System.out.println("❌ No item currently playing");
        }
    }

    static void searchItems() {
        System.out.print("Enter search keyword (title or artist): ");
        String keyword = scanner.nextLine();
        playlist.search(keyword);
    }

    public static void SampleData() {
        // Add some sample songs
        playlist.addToEnd(new Song("About You", "the 1945", 355, "About You", "Pop"));
        playlist.addToEnd(new Song("Shape of You", "Ed Sheeran", 263, "÷ (Divide)", "Pop"));
        playlist.addToEnd(new Song("Let Down", "Radiohead", 294, "Thriller", "Pop"));
        playlist.addToEnd(new Podcast("Koruptor Indonesia", "Deddy Corbuzier", 7200, "#1234", "Conversation about life"));
        playlist.addToEnd(new Song("Kimi no Namae", "Chiai Fujikawa", 482, "Tate no Yuusha ED", "Pop"));
    }

    public static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }
}
