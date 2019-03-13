package HomeWork4;

public class SimpleLinkedList {
    private Node firstElement;//001
    private int size;

    public void add(int value) {
        Node node = new Node(value);//005
        node.setNextElement(firstElement);//005 {nextElement = 001}
        firstElement = node;//005
        size++;
        //firstElement -> 008 -> 005 -> 001 -> null
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }

        int data = firstElement.getData();
        firstElement = firstElement.getNextElement();
        size--;

        return data;
    }

    public int remove(int value) {
        Node currentNode = firstElement;
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.getData() == value) {
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextElement();
        }

        if (currentNode == null) {
            return -1;
        }

        if (previousNode == null) {
            firstElement = currentNode.getNextElement();
        }
        else {
            previousNode.setNextElement(currentNode.getNextElement());
        }

        size--;
        return currentNode.getData();
    }

    public boolean find(int value) {
        Node currentNode = firstElement;

        while (currentNode != null) {
            if (currentNode.getData() == value) {
                return true;
            }
            currentNode = currentNode.getNextElement();
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Node getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(Node firstElement) {
        this.firstElement = firstElement;
    }

    public void display() {
        System.out.println("----------- Linked List Start");

        Node currentNode = firstElement;

        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.getNextElement();
        }
        System.out.println("----------- Linked List Finish");
    }
}
