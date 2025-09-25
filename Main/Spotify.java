package Main;

import Data.SpotifySong;
import List.*;
import java.util.Scanner;

public class Spotify {
    public static void main(String[] args) {
        DoublyLinkedList mainPlaylist = new DoublyLinkedList();
        SinglyLinkedList recentlyPlayed = new SinglyLinkedList();
        CircularLinkedList loopPlaylist = new CircularLinkedList();

        // Sample for demonstration
        SpotifySong sample1 = new SpotifySong("Cruel Angel's Thesis", "Yoko Takahashi", "Neon Genesis Evangelion", 240, "Anime");
        mainPlaylist.insertLast(sample1);
        loopPlaylist.insertLast(sample1);
        SpotifySong sample2 = new SpotifySong("Tank!", "SEATBELTS", "Cowboy Bebop", 180, "Anime");
        mainPlaylist.insertLast(sample2);
        loopPlaylist.insertLast(sample2);
        SpotifySong sample3 = new SpotifySong("Blue Bird", "Ikimonogakari", "Naruto Shippuden", 250, "Anime");
        mainPlaylist.insertLast(sample3);
        loopPlaylist.insertLast(sample3);
        SpotifySong sample4 = new SpotifySong("Butterfly", "Kouji Wada", "Digimon Adventure", 220, "Anime");
        mainPlaylist.insertLast(sample4);
        loopPlaylist.insertLast(sample4);
        SpotifySong sample5 = new SpotifySong("Unravel", "TK from Ling Tosite Sigure", "Tokyo Ghoul", 230, "Anime");
        mainPlaylist.insertLast(sample5);
        loopPlaylist.insertLast(sample5);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("         Spotify Program Menu");
            System.out.println("=".repeat(40));
            System.out.println("1. Add Song");
            System.out.println("2. View Playlists");
            System.out.println("3. Play Music");
            System.out.println("4. Exit");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addSongMenu(scanner, mainPlaylist, recentlyPlayed, loopPlaylist);
                    break;
                case 2:
                    viewPlaylistsMenu(scanner, mainPlaylist, recentlyPlayed, loopPlaylist);
                    break;
                case 3:
                    playMusicMenu(scanner, mainPlaylist, recentlyPlayed, loopPlaylist);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting Spotify. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Helper method to create a new song
    private static SpotifySong createSong(Scanner scanner) {
        System.out.println("\n" + "-".repeat(30));
        System.out.println("Enter Song Details:");
        System.out.println("-".repeat(30));
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Album: ");
        String album = scanner.nextLine();
        System.out.print("Duration (seconds): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.println("-".repeat(30));
        return new SpotifySong(title, artist, album, duration, genre);
    }

    private static void playSong(DoublyLinkedList playlist, Scanner scanner, SinglyLinkedList recentlyPlayed) {
        System.out.print("Enter index to play: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        try {
            SpotifySong song = (SpotifySong) playlist.get(index);
            song.play();
            recentlyPlayed.insertLast(song);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    private static void pauseSong(DoublyLinkedList playlist, Scanner scanner) {
        System.out.print("Enter index to pause: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        try {
            SpotifySong song = (SpotifySong) playlist.get(index);
            song.pause();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    private static void stopSong(DoublyLinkedList playlist, Scanner scanner) {
        System.out.print("Enter index to stop: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        try {
            SpotifySong song = (SpotifySong) playlist.get(index);
            song.stop();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    private static void deleteSong(DoublyLinkedList playlist, Scanner scanner) {
        System.out.print("Enter index to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        try {
            playlist.deleteAt(index);
            System.out.println("Song deleted.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    private static void loopPlay(CircularLinkedList playlist) {
        if (playlist.size == 0) {
            System.out.println("Loop Playlist is empty.");
            return;
        }
        System.out.println("Looping through Loop Playlist:");
        for (int i = 0; i < playlist.size; i++) {
            SpotifySong song = (SpotifySong) playlist.get(i);
            song.play();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Loop finished.");
    }

    private static void addSongMenu(Scanner scanner, DoublyLinkedList mainPlaylist, SinglyLinkedList recentlyPlayed, CircularLinkedList loopPlaylist) {
        System.out.println("\n" + "-".repeat(30));
        System.out.println("Add Song to Playlist");
        System.out.println("-".repeat(30));
        System.out.println("1. Main Playlist (Doubly Linked List)");
        System.out.println("2. Recently Played (Singly Linked List)");
        System.out.println("3. Loop Playlist (Circular Linked List)");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose a playlist: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                mainPlaylist.insertLast(createSong(scanner));
                System.out.println("Song added to Main Playlist.");
                break;
            case 2:
                recentlyPlayed.insertLast(createSong(scanner));
                System.out.println("Song added to Recently Played.");
                break;
            case 3:
                loopPlaylist.insertLast(createSong(scanner));
                System.out.println("Song added to Loop Playlist.");
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option. Returning to main menu.");
        }
    }

    private static void describeLoopPlaylist(CircularLinkedList playlist) {
        if (playlist.size == 0) {
            System.out.println("Loop Playlist is empty.");
            return;
        }
        System.out.println("Loop Playlist:");
        for (int i = 0; i < playlist.size; i++) {
            SpotifySong song = (SpotifySong) playlist.get(i);
            System.out.println((i + 1) + ". " + song.toString());
        }
    }

    private static void viewPlaylistsMenu(Scanner scanner, DoublyLinkedList mainPlaylist, SinglyLinkedList recentlyPlayed, CircularLinkedList loopPlaylist) {
        System.out.println("\n" + "-".repeat(30));
        System.out.println("View Playlists");
        System.out.println("-".repeat(30));
        System.out.println("1. Main Playlist");
        System.out.println("2. Recently Played");
        System.out.println("3. Loop Playlist");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose a playlist to view: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1: mainPlaylist.display();
                break;
            case 2: recentlyPlayed.display();
                break;
            case 3: describeLoopPlaylist(loopPlaylist);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option. Returning to main menu.");
        }
    }

    private static void playMusicMenu(Scanner scanner, DoublyLinkedList mainPlaylist, SinglyLinkedList recentlyPlayed, CircularLinkedList loopPlaylist) {
        System.out.println("\n" + "-".repeat(30));
        System.out.println("Play Music");
        System.out.println("-".repeat(30));
        System.out.println("1. Play song from Main Playlist");
        System.out.println("2. Pause song from Main Playlist");
        System.out.println("3. Stop song from Main Playlist");
        System.out.println("4. Delete song from Main Playlist");
        System.out.println("5. Loop play from Loop Playlist");
        System.out.println("6. Back to Main Menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1: playSong(mainPlaylist, scanner, recentlyPlayed);
                break;
            case 2: pauseSong(mainPlaylist, scanner);
                break;
            case 3: stopSong(mainPlaylist, scanner);
                break;
            case 4: deleteSong(mainPlaylist, scanner);
                break;
            case 5: loopPlay(loopPlaylist);
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid option. Returning to main menu.");
        }
    }
}
