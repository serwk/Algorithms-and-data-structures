package HomeWork4;

public class Node {
    private final int data;
    private Node nextElement;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public String toString() {
        return "{" + data + "}";
    }
}
