package Spotify;

public class Node {
    Media data;
    Node next;
    Node prev;

    public Node(Media data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
