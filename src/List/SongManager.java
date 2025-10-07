package List;
import Data.*;
import Nodes.*;

public class SongManager extends LinkedList {
    @Override
    public void add(Media media){
        MediaNode newNode = new MediaNode(media);

        if(head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean delete(String title) {
        if (head == null) return false;
        
        if (head.data.title.equalsIgnoreCase(title)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.next.data.title.equalsIgnoreCase(title)) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
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
            System.out.println("  (No songs available)");
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
