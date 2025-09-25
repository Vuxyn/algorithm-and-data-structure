package List;
import Nodes.DoublyNode;

public class DoublyLinkedList extends LinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    
    public DoublyLinkedList(){
        super();
        this.head = null;
        this.tail = null;
    }

    @Override
    public void insertFirst(Object data){
        DoublyNode newNode = new DoublyNode(data);
        if(head == null){
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void insertLast(Object data){
        DoublyNode newNode = new DoublyNode(data);
        if(tail == null){
            head = tail =  newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void insertAt(int index, Object data){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if(index == 0) { insertFirst(data); return; }
        if(index == size) { insertLast(data); return; }

        DoublyNode newNode = new DoublyNode(data);
        DoublyNode current = head;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }

        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }

    @Override
    public Object deleteFirst() {
        if (head == null) { return null; }
        
        Object data = head.getData();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
        return data;
    }
    
    @Override
    public Object deleteLast() {
        if (tail == null) { return null; }
        
        Object data = tail.getData();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        return data;
    }
    
    @Override
    public Object deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        if (index == 0) { return deleteFirst(); }
        
        if (index == size - 1) { return deleteLast(); }
        
        DoublyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        
        Object data = current.getData();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return data;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        DoublyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current.getData();
    }
    
    @Override
    public int search(Object data) {
        DoublyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }
    
    @Override
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        DoublyNode current = head;
        System.out.print("Doubly LinkedList: null <- ");
        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) {
                System.out.print(" <-> ");
            }
            current = current.getNext();
        }
        System.out.println(" -> null");
    }
    
    @Override
    public void clear(){
        head = tail = null;
        size = 0;
    }

    //Exclusif method for this class
    public void displayReverse() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        DoublyNode current = tail;
        System.out.print("Doubly LinkedList (Reverse): null <- ");
        while (current != null) {
            System.out.print(current.getData());
            if (current.getPrev() != null) {
                System.out.print(" <-> ");
            }
            current = current.getPrev();
        }
        System.out.println(" -> null");
    }
}
