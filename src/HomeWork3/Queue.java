package HomeWork3;

public class Queue {
    public static final int DEFAULT_FRONT = 0;
    public static final int DEFAULT_REAR = -1;

    protected int[] data;
    protected int size;

    protected int front;
    protected int rear;

    public Queue(int maxSize) {
        this.data = new int[maxSize];
        this.front = DEFAULT_FRONT;
        this.rear = DEFAULT_REAR;
    }

    public void insert(int value) {
        if (rear == data.length - 1) {
            rear = DEFAULT_REAR;
        }

        data[++rear] = value;
        size++;
    }

    public int remove() {
        int value = data[front++];
        if (front == data.length) {
            front = DEFAULT_FRONT;
        }
        size--;
        return value;
    }

    public int peek() {
        return data[front];
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
