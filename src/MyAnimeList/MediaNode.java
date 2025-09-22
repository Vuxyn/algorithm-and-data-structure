package MyAnimeList;

public class MediaNode {
    Media media;
    MediaNode next;

    public MediaNode(Media media){
        this.media = media;
        this.next = null;
    }
}
