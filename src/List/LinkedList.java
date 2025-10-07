package List;
import Data.*;
import Nodes.*;

public abstract class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public abstract void add(Media media);
    public abstract boolean delete(String title);
    public abstract Media search(String title);
    public abstract void display();

    public int getSize() { return size; }

}
