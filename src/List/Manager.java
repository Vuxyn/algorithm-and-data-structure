package List;
import Data.*;

public class Manager {
    SongManager songManager;
    PodcastManager podcastManager;
    VideoManager videoManager;

    public Manager(){
        this.songManager = new SongManager();
        this.podcastManager = new PodcastManager();
        this.videoManager = new VideoManager();
    }

    public void addSong(String title, String artist, int duration, String album, String genre) {
        Song song = new Song(title, artist, duration, album, genre);
        songManager.add(song);
        System.out.println("✓ Song added: " + title);
    }

    public boolean deleteSong(String title) {
        boolean deleted = songManager.delete(title);
        if (deleted) {
            System.out.println("✓ Song deleted: " + title);
        } else {
            System.out.println("✗ Song not found: " + title);
        }
        return deleted;
    }
    
    public Media searchSong(String title) {
        return songManager.search(title);
    }

    public void displayAllSongs() {
        System.out.println("\n=== All Songs ===");
        songManager.display();
        System.out.println("Total: " + songManager.getSize() + " songs");
    }

    //Podcast
    public void addPodcast(String title, String artist, int duration, String host, String category, int episode) {
        Podcast podcast = new Podcast(title, artist, duration, host, category, episode);
        podcastManager.add(podcast);
        System.out.println("✓ Podcast added: " + title);
    }
    
    public boolean deletePodcast(String title) {
        boolean deleted = podcastManager.delete(title);
        if (deleted) {
            System.out.println("✓ Podcast deleted: " + title);
        } else {
            System.out.println("✗ Podcast not found: " + title);
        }
        return deleted;
    }
    
    public Media searchPodcast(String title) {
        return podcastManager.search(title);
    }

    public void displayAllPodcasts() {
        System.out.println("\n=== All Podcasts ===");
        podcastManager.display();
        System.out.println("Total: " + podcastManager.getSize() + " podcasts");
    }


    //Video
    public void addVideo(String title, String channel, int duration, String resolution) {
        Video video = new Video(title, channel, duration, resolution);
        videoManager.add(video);
        System.out.println("✓ Video added: " + title);
    }
    
    public boolean deleteVideo(String title) {
        boolean deleted = videoManager.delete(title);
        if (deleted) {
            System.out.println("✓ Video deleted: " + title);
        } else {
            System.out.println("✗ Video not found: " + title);
        }
        return deleted;
    }
    
    public Media searchVideo(String title) {
        return videoManager.search(title);
    }

    public void displayAllVideos() {
        System.out.println("\n=== All Videos ===");
        videoManager.display();
        System.out.println("Total: " + videoManager.getSize() + " videos");
    }

    public void displayVideoPlaylist(int loops) {
        videoManager.displayCircular(loops);
    }

    public void displayStatistics() {
        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║    SPOTIFY SYSTEM STATS       ║");
        System.out.println("╠═══════════════════════════════╣");
        System.out.println("║ Total Songs:     " + String.format("%12d", songManager.getSize()) + " ║");
        System.out.println("║ Total Podcasts:  " + String.format("%12d", podcastManager.getSize()) + " ║");
        System.out.println("║ Total Videos:    " + String.format("%12d", videoManager.getSize()) + " ║");
        System.out.println("║ ───────────────────────────   ║");
        System.out.println("║ Total Media:     " + String.format("%12d", 
            songManager.getSize() + podcastManager.getSize() + videoManager.getSize()) + " ║");
        System.out.println("╚═══════════════════════════════╝");
    }
}
