package Season;

public class Node {
    SeasonItem item;
    Node next;

    public Node(SeasonItem item) {
        this.item = item;
        this.next = null;
    }
}
