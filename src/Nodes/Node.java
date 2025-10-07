package Nodes;
import Data.Media;

public abstract class Node {
    public Media data;
    public Node nestedNode;
    public Node next;
    public Node prev;

    public Node(Media data){
        this.data = data;
        this.nestedNode = null;
        this.next = null;
        this.next = null;
    }

    public Node(Node nestedNode){
        this.nestedNode = nestedNode;
        this.next = null;
        this.next = null;
    }


}
