package Season;

public class Cycle {
    public Node current;
    public int size;
    public int currentMonth;

    public Cycle() {
        this.current = null;
        this.size = 0;
        this.currentMonth = 0;
    }

    public void addItem(SeasonItem item) {
        Node newNode = new Node(item);
        
        if (current == null) {
            // First item
            current = newNode;
            current.next = current; // Point to itself
        } else {
            // Find the last node
            Node temp = current;
            while (temp.next != current) {
                temp = temp.next;
            }
            // Insert new node
            temp.next = newNode;
            newNode.next = current;
        }
        size++;
        System.out.println("✓ Added: " + item.getName());
    }

    public boolean removeItem(String name) {
        if (current == null) return false;
        
        if (size == 1) {
            if (current.item.getName().equalsIgnoreCase(name)) {
                current = null;
                size = 0;
                System.out.println("✓ Removed: " + name);
                return true;
            }
            return false;
        }
        
        Node prev = current;
        Node temp = current;
        
        // Find the item to remove
        do {
            if (temp.item.getName().equalsIgnoreCase(name)) {
                // Remove the node
                prev.next = temp.next;
                
                // Update current if necessary
                if (temp == current) {
                    current = temp.next;
                }
                
                size--;
                System.out.println("✓ Removed: " + name);
                return true;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != current);
        
        System.out.println("✗ Item not found: " + name);
        return false;
    }

    public SeasonItem getCurrentItem() {
        return current != null ? current.item : null;
    }
    
    public boolean isEmpty() { return size == 0; }

    public void moveNext() {
        if (current != null) {
            current = current.next;
            currentMonth += 3; // Assume each move = 3 months
            if (currentMonth > 12) currentMonth = currentMonth % 12;
            if (currentMonth == 0) currentMonth = 12;
        }
    }

    public void movePrevious() {
        if (current == null || size <= 1) return;
        
        // Find previous node
        Node temp = current;
        while (temp.next != current) {
            temp = temp.next;
        }
        current = temp;
        currentMonth -= 3;
        if (currentMonth <= 0) currentMonth = currentMonth + 12;
    }

    public void autoCycle(int steps) {
        if (current == null) {
            System.out.println("Season cycle is empty");
            return;
        }
        
        System.out.println("\n🔄 Auto cycling for " + steps + " steps:");
        System.out.println("-".repeat(30));
        
        for (int i = 1; i <= steps; i++) {
            System.out.println("Step " + i + ": " + current.item.getName());
            moveNext();
            
            try {
                Thread.sleep(800); // Pause
            } catch (InterruptedException e) {
                break;
            }
        }
        
        System.out.println("-".repeat(30));
        System.out.println("Current: " + current.item.getName());
    }
}
