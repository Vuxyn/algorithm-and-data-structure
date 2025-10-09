package List;
import Data.*;
import Nodes.*;

public class VideoManager extends LinkedList {

    @Override
    public void add(Media media) {
        MediaNode newNode = new MediaNode(media);
        
        if (head == null) {
            head = tail = newNode;
            newNode.next = head; 
        } else {
            tail.next = newNode;
            newNode.next = head; 
            tail = newNode;
        }
        size++;
    }
    
    @Override
    public boolean delete(String title) {
        if (head == null) return false;
        
        if (head == tail && head.data.title.equalsIgnoreCase(title)) {
            head = tail = null;
            size--;
            return true;
        }
        
        if (head.data.title.equalsIgnoreCase(title)) {
            head = head.next;
            tail.next = head; 
            size--;
            return true;
        }
        
        Node current = head;
        do {
            if (current.next.data.title.equalsIgnoreCase(title)) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        } while (current != head);
        
        return false;
    }
    
    @Override
    public Media search(String title) {
        if (head == null) return null;
        
        Node current = head;
        do {
            if (current.data != null && current.data.title.equalsIgnoreCase(title)) {
                return current.data;
            }
            current = current.next;
        } while (current != head);
        
        return null;
    }
    
    @Override
    public void display() {
        if (head == null) {
            System.out.println("  (No videos available)");
            return;
        }
        
        Node current = head;
        int index = 1;
        do {
            System.out.print("  " + index + ". ");
            current.data.display();
            current = current.next;
            index++;
        } while (current != head);
    }
    
    public void displayCircular(int loops) {
        if (head == null) {
            System.out.println("  (No videos available)");
            return;
        }
        
        System.out.println("\n=== Video Playlist (Circular - " + loops + " loops) ===");
        Node current = head;
        int count = 0;
        int maxDisplay = size * loops;
        
        do {
            System.out.print("  " + (count + 1) + ". ");
            current.data.display();
            current = current.next;
            count++;
        } while (count < maxDisplay);
    }
}
