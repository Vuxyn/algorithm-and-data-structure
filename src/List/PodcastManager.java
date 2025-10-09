package List;
import Data.*;
import Nodes.*;

public class PodcastManager extends LinkedList {
    @Override
    public void add(Media media) {
        MediaNode newNode = new MediaNode(media);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    @Override
    public boolean delete(String title) {
        if (head == null) return false;
        
        Node current = head;
        while (current != null) {
            if (current.data.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                }
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                
                size--;
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    @Override
    public Media search(String title) {
        Node current = head;
        while (current != null) {
            if (current.data != null && current.data.title.equalsIgnoreCase(title)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    
    @Override
    public void display() {
        if (head == null) {
            System.out.println("  (No podcasts available)");
            return;
        }
        
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.print("  " + index + ". ");
            current.data.display();
            current = current.next;
            index++;
        }
    }
}
