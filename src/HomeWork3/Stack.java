package HomeWork3;

public class Stack {
    private char[] data;
    private int size;

    public Stack(int maxSize) {
        this.data = new char[maxSize];
        this.size = 0;
    }

    public void push(char value) {
        if (isFull()) {
            throw new RuntimeException("Stack is full!");
        }
        data[size++] = value;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return data[--size];
    }

    public char peek() {
        return !isEmpty() ? data[size - 1] : ' ';
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int getSize() {
        return size;
    }
}
