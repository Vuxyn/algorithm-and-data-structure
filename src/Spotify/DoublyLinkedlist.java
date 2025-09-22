package Spotify;

public class DoublyLinkedlist {
    Node head;
    Node tail;
    Node current;
    int size;

    public DoublyLinkedlist() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    public void addToEnd(Media item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("✓ Added: " + item.getTitle() + " to playlist");
    }

    public void addToBeginning(Media item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("✓ Added: " + item.getTitle() + " to playlist");
    }

    public boolean remove(String title) {
        Node temp = head;

        while(temp != null) {
            if(temp.data.getTitle().equalsIgnoreCase(title)) {
                if(temp == current) {
                    if(temp.next != null) {
                        current = temp.next;
                    } else if(temp.prev != null) {
                        current = temp.prev;
                    } else {
                        current = null;
                    }
                }
                if(temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
    
                if(temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
    
                size--;
                System.out.println("✓ Removed: " + title + " from playlist");
                return true;
            }
            temp = temp.next;
        }
        System.out.println("✗ Song: " + title + " not found in playlist");
        return false;
    }

    public boolean next(){
        if(current != null && current.next != null) {
            current = current.next;
            return true;
        }
        return false;
    }

    public boolean previous(){
        if(current != null && current.prev != null) {
            current = current.prev;
            return true;
        }
        return false;
    }

    public Media getCurrentItem() {
        return current != null ? current.data : null;
    }

    public void shuffle() {
        if(size <= 1) return;

        Media[] items = new Media[size];
        Node temp = head;
        int index = 0;

        while(temp != null) {
            items[index++] = temp.data;
            temp = temp.next;
        }
        for (int i = items.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Media tempItem = items[i];
            items[i] = items[j];
            items[j] = tempItem;
        }

        clear();
        for (Media item : items) {
            addToEnd(item);
        }
        System.out.println("✓ Playlist shuffled");
    }

    public void clear() {
        head = tail = current = null;
        size = 0;
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("📝 Playlist is empty");
            return;
        }
        
        System.out.println("\n=== PLAYLIST ===");
        Node temp = head;
        int index = 1;
        
        while (temp != null) {
            String marker = (temp == current) ? "▶ " : "  ";
            System.out.println(marker + index + ". " + temp.data.getDisplayInfo());
            temp = temp.next;
            index++;
        }
        System.out.println("================");
        System.out.println("Total items: " + size);
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
    public void search(String keyword) {
        System.out.println("\n=== SEARCH RESULTS ===");
        Node temp = head;
        int found = 0;
        
        while (temp != null) {
            if (temp.data.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                temp.data.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println((found + 1) + ". " + temp.data.getDisplayInfo());
                found++;
            }
            temp = temp.next;
        }
        
        if (found == 0) {
            System.out.println("No results found for: " + keyword);
        } else {
            System.out.println("Found " + found + " item(s)");
        }
        System.out.println("=====================");
    }
}
