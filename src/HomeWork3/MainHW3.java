package HomeWork3;

public class MainHW3 {

    public static void main(String[] args) {

        //TASK 1.1 Queue
        System.out.println("TASK 1.1 Queue\n");
        TestQueue();

        System.out.println("\n*******************\n");

        //TASK 1.2 Stack
        System.out.println("TASK 1.2 Stack\n");
        TestStack();

        System.out.println("\n*******************\n");

        //TASK 2 Flip to string
        System.out.println("TASK 2 Flip to string\n");
        String currentString = "Hello!";
        System.out.println("Current String:  " + currentString);
        FlipToString(currentString);

        System.out.println("\n*******************\n");

    }

    public static void TestQueue() {
        Queue queue = new Queue(5);
        insertToQueue(queue, 1);
        insertToQueue(queue, 2);
        insertToQueue(queue, 3);
        insertToQueue(queue, 4);
        insertToQueue(queue, 5);

        System.out.println("Size: " + queue.getSize());
        System.out.println("Peek: " + queue.peek());

        System.out.println("Remove top: " + removeFromQueue(queue));
        System.out.println("Size: " + queue.getSize());
        System.out.println("Peek: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(removeFromQueue(queue));
        }
    }

    private static int removeFromQueue(Queue queue) {
        return !queue.isEmpty() ? queue.remove() : -1;
    }

    private static void insertToQueue(Queue queue, int val) {
        if (!queue.isFull()) {
            queue.insert(val);
        }
    }

    public static void TestStack() {
        Stack stack = new Stack(5);
        pushToStack(stack, 'a');
        pushToStack(stack, 'b');
        pushToStack(stack, 'c');
        pushToStack(stack, 'd');
        pushToStack(stack, 'e');
        pushToStack(stack, 'f');

        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.getSize());

        while (!stack.isEmpty()) {
            System.out.println((stack.pop()));
        }

        popFromStack(stack);
    }

    private static void popFromStack(Stack stack) {
        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void pushToStack(Stack stack, char value) {
        if (!stack.isFull()) {
            stack.push(value);
        }
    }

    public static void FlipToString(String str) {

        Stack st = new Stack(5);
        for (int i = 0; i < str.length(); i++) {
            if (!st.isFull()) {
                st.push(str.charAt(i));
            }
        }

        if (!st.isEmpty()) {
            System.out.print("Inverted String: ");
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }

    }
}