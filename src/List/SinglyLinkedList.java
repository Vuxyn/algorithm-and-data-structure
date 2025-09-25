package List;
import Nodes.SinglyNode;

public class SinglyLinkedList extends LinkedList {
    public SinglyNode head;

    public SinglyLinkedList() { 
        super();
        this.head = null;
    }

    @Override
    public void insertFirst(Object data) {
        SinglyNode newNode = new SinglyNode(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void insertLast(Object data) {
        SinglyNode newNode = new SinglyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            SinglyNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        if (index == 0) {
            insertFirst(data);
            return;
        }
        
        SinglyNode newNode = new SinglyNode(data);
        SinglyNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    @Override
    public Object deleteFirst() {
        if (head == null) {
            return null;
        }
        Object data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public Object deleteLast() {
        if (head == null) {
            return null;
        }
        
        if (head.getNext() == null) {
            Object data = head.getData();
            head = null;
            size--;
            return data;
        }
        
        SinglyNode current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        Object data = current.getNext().getData();
        current.setNext(null);
        size--;
        return data;
    }

    @Override
    public Object deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        if (index == 0) {
            return deleteFirst();
        }
        
        SinglyNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Object data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return data;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        SinglyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public int search(Object data) {
        SinglyNode current = head;
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
        
        SinglyNode current = head;
        System.out.print("Singly LinkedList: ");
        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println(" -> null");
    }
    
    @Override
    public void clear() {
        head = null;
        size = 0;
    }
}
