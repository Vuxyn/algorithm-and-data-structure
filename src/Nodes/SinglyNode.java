package Nodes;

public class SinglyNode extends Node {
    public SinglyNode next;

    public SinglyNode(Object data){
        super(data);
        this.next = null;
    }

    public SinglyNode getNext() { return next; }
    public void setNext(SinglyNode next) { this.next = next; }

    @Override
    public String toString() { return data.toString(); }
}
