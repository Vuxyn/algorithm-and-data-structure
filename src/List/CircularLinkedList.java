package List;
import Nodes.SinglyNode;

public class CircularLinkedList extends LinkedList {
    public SinglyNode tail;
    
    public CircularLinkedList() {
        super();
        this.tail = null;
    }
    
    @Override
    public void insertFirst(Object data) {
        SinglyNode newNode = new SinglyNode(data);
        if (tail == null) {
            tail = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }
    
    @Override
    public void insertLast(Object data) {
        SinglyNode newNode = new SinglyNode(data);
        if (tail == null) {
            tail = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
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
        
        if (index == size) {
            insertLast(data);
            return;
        }
        
        SinglyNode newNode = new SinglyNode(data);
        SinglyNode current = tail.getNext();
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }
    
    @Override
    public Object deleteFirst() {
        if (tail == null) {
            return null;
        }
        
        Object data;
        if (tail.getNext() == tail) {
            data = tail.getData();
            tail = null;
        } else {
            SinglyNode head = tail.getNext();
            data = head.getData();
            tail.setNext(head.getNext());
        }
        size--;
        return data;
    }
    
    @Override
    public Object deleteLast() {
        if (tail == null) {
            return null;
        }
        
        Object data = tail.getData();
        if (tail.getNext() == tail) {
            tail = null;
        } else {
            SinglyNode current = tail.getNext();
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(tail.getNext());
            tail = current;
        }
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
        
        if (index == size - 1) {
            return deleteLast();
        }
        
        SinglyNode current = tail.getNext();
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
        
        SinglyNode current = tail.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
    
    @Override
    public int search(Object data) {
        if (tail == null) {
            return -1;
        }
        
        SinglyNode current = tail.getNext();
        int index = 0;
        do {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        } while (current != tail.getNext());
        return -1;
    }
    
    @Override
    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        SinglyNode current = tail.getNext();
        System.out.print("Circular LinkedList: ");
        do {
            System.out.print(current.getData());
            current = current.getNext();
            if (current != tail.getNext()) {
                System.out.print(" -> ");
            }
        } while (current != tail.getNext());
        System.out.println(" -> (back to first)");
    }
    
    @Override
    public void clear() {
        tail = null;
        size = 0;
    }
}
