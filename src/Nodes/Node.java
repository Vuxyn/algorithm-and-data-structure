package Nodes;

public abstract class Node {
    protected Object data;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
    
    @Override
    public abstract String toString();
}
