package MyAnimeList;

import java.util.Scanner;

public class AnimeList {
    MediaNode head;
    int size;

    public AnimeList() {
        head = null;
        size = 0;
    }
    public void addAnime(String title, String studio, int year, int episodes, String status) {
        Anime anime = new Anime(title, studio, year, episodes, status);
        addMedia(anime);
        System.out.println("Anime '" + title + "' added to your list!");
    }

    public void addManga(String title, String publisher, int year, int chapters, String status, String author) {
        Manga manga = new Manga(title, publisher, year, chapters, status, author);
        addMedia(manga);
        System.out.println("Manga '" + title + "' added to your list!");
    }
    
    public void addMedia(Media media) {
        MediaNode newNode = new MediaNode(media);
        if(head == null){
            head = newNode;
        } else {
            MediaNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean removeMedia(String title) {
        if(head == null) {
            System.out.println("Your anime list is empty!");
            return false;
        }
        if(head.media.getTitle().equalsIgnoreCase(title)) {
            System.out.println("Removed: " + head.media.getTitle());
            head = head.next;
            size--;
            return true;
        }

        MediaNode current = head;
        while(current.next != null) {
            if(current.next.media.getTitle().equalsIgnoreCase(title)){
                System.out.println("Removed: " + current.next.media.getTitle());
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        System.out.println("'" +  title + "' not found in your list!");
        return false;
    }

    public boolean searchMedia(String title) {
        MediaNode current = head;
        int position = 0;

        while(current != null){
            if(current.media.getTitle().equalsIgnoreCase(title)){
                System.out.println("Found at position " + position + ":");
                current.media.displayInfo();
                return true;
            }
            current = current.next;
            position++;
        }

        System.out.println("'" + title + "' not found in your list!");
        return false;
    }

    // Update based on "MEDIA" type
    public boolean updateMedia(String title) {
        MediaNode current = head;
        
        while (current != null) {
            if (current.media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + title);
                System.out.println("Current type: " + current.media.getType());
                
                try {
                    if (current.media.getType().equals("ANIME")) {
                        Anime anime = (Anime) current.media;
                        System.out.print("New rating (0-10, current: " + anime.getRating() + "): ");
                        Scanner sc = new Scanner(System.in);
                        String input = sc.nextLine();
                        if (!input.isEmpty()) {
                            double rating = Double.parseDouble(input);
                            if (rating >= 0 && rating <= 10) {
                                anime.setRating(rating);
                                System.out.println("Rating updated to " + rating + "/10!");
                            } else {
                                System.out.println("Rating must be between 0-10!");
                            }
                        }
                        sc.close();
                    } else if (current.media.getType().equals("MANGA")) {
                        Manga manga = (Manga) current.media;
                        System.out.print("New chapter count (current: " + manga.getChapters() + "): ");
                        Scanner sc = new Scanner(System.in);
                        String input = sc.nextLine();
                        if (!input.isEmpty()) {
                            int chapters = Integer.parseInt(input);
                            manga.setChapters(chapters);
                            System.out.println("Chapter count updated to " + chapters + "!");
                        }
                        sc.close();
                    }
                    return true;
                } catch (ClassCastException e) {
                    System.out.println("Error updating media!");
                    return false;
                }
            }
            current = current.next;
        }
        
        System.out.println("'" + title + "' not found!");
        return false;
    }

    //DISPLAY ALL MEDIA (ANIME AND MANGA)
    public void displayAll() {
        if(head == null) {
            System.out.println("Your list is empty");
            return;
        }
        System.out.println("\n🎌 MY ANIME LIST:");
        System.out.println("=".repeat(95));
        MediaNode current = head;
        int pos = 0;

        while(current != null){
            System.out.printf("[%d] ", pos);
            current.media.displayInfo(); // Each class displays differently
            current = current.next;
            pos++;
        }
        System.out.println("=".repeat(95));
        System.out.println("Total entries: " + size);
    }

    //WATCHING STATISTICS
    public void showStatistics() {
        if (head == null) {
            System.out.println("No data to analyze!");
            return;
        }
        
        int animeCount = 0,  mangaCount = 0;
        int newestYear = 0, oldestYear = 9999;
        String newestTitle = "", oldestTitle = "";
        double totalAnimeRating = 0;
        int ratedAnimeCount = 0;
        
        MediaNode current = head;
        while (current != null) {
            // Count by type using polymorphic getType()
            String type = current.media.getType();
            
            if (type.equals("ANIME")) {
                animeCount++;
                try {
                    Anime anime = (Anime) current.media;
                    if (anime.getRating() > 0) {
                        totalAnimeRating += anime.getRating();
                        ratedAnimeCount++;
                    }
                } catch (ClassCastException e) {
                    // Ignore
                }
            } else if (type.equals("MANGA")) {
                mangaCount++;
            }
            
            // Find newest and oldest
            int year = current.media.getYear();
            if (year > newestYear) {
                newestYear = year;
                newestTitle = current.media.getTitle();
            }
            if (year < oldestYear) {
                oldestYear = year;
                oldestTitle = current.media.getTitle();
            }
            
            current = current.next;
        }
        
        System.out.println("\n📊 MY ANIME LIST STATISTICS:");
        System.out.println("=".repeat(35));
        System.out.println("Anime Series: " + animeCount);
        System.out.println("Manga: " + mangaCount);
        System.out.println("Total Entries: " + size);
        if (ratedAnimeCount > 0) {
            System.out.printf("⭐ Average Anime Rating: %.2f/10\n", (totalAnimeRating / ratedAnimeCount));
        }
        System.out.println("Newest: " + newestTitle + " (" + newestYear + ")");
        System.out.println("Oldest: " + oldestTitle + " (" + oldestYear + ")");
        System.out.println("=".repeat(35));
    }
    
    //SHOW BY CATEGORY
    public void showByCategory(String category) {
        if (head == null) {
            System.out.println("Your list is empty!");
            return;
        }
        
        System.out.println("\nFILTERING BY: " + category.toUpperCase());
        System.out.println("=".repeat(95));
        
        MediaNode current = head;
        int found = 0;
        
        while (current != null) {
            if (current.media.getType().equals(category.toUpperCase())) {
                current.media.displayInfo();
                found++;
            }
            current = current.next;
        }
        
        if (found == 0) {
            System.out.println("No " + category.toLowerCase() + " found in your list!");
        } else {
            System.out.println("Found " + found + " " + category.toLowerCase() + "(s)");
        }
    }
    
    public boolean isEmpty() {
        return head == null;
    }

}
