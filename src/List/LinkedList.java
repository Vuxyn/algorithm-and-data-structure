package List;

public abstract class LinkedList {
    public int size;
    public LinkedList() { this.size = 0; }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }

    // Abstract methods that must be implemented
    public abstract void insertFirst(Object data);
    public abstract void insertLast(Object data);
    public abstract void insertAt(int index, Object data);
    public abstract Object deleteFirst();
    public abstract Object deleteLast();
    public abstract Object deleteAt(int index);
    public abstract Object get(int index);
    public abstract int search(Object data);
    public abstract void display();
    public abstract void clear();
}
