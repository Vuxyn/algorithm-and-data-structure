package Nodes;

public class DoublyNode extends Node {
    public DoublyNode next;
    public DoublyNode prev;

    public DoublyNode(Object data){
        super(data);
        this.next = null;
        this.prev = null;
    }

    public DoublyNode getNext() { return next; }
    public DoublyNode getPrev() { return prev; }
    public void setNext(DoublyNode next) { this.next = next; }
    public void setPrev(DoublyNode prev) { this.prev = prev; }

    @Override
    public String toString() { return data.toString(); }
}
