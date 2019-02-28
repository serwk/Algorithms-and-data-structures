package HomeWork2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int ARRAY_CAPACITY = 100_000;

    public static final int MAX_VALUE = 100_000;

    public static void main(String[] args) {
        MyArray arr1 = new MyArray(ARRAY_CAPACITY);
        MyArray arr2 = new MyArray(ARRAY_CAPACITY);
        MyArray arr3 = new MyArray(ARRAY_CAPACITY);

        randomInitialize(arr1, arr2, arr3);


        measureTime(arr1::sortBubble, "Sort Bubble");//arr1.sortBubble();
        measureTime(arr2::sortSelect, "Sort Select");//arr2.sortSelect();
        measureTime(arr3::sortInsert, "Sort Insert");//arr3.sortInsert();
    }

    private static void randomInitialize(MyArray... arrays) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (MyArray array : arrays) {
                array.add(value);
            }
        }
    }

    private static void measureTime(Runnable action, String actionName) {
        long startTime = System.nanoTime();
        action.run();
        long finishTime = System.nanoTime();
        long duration = finishTime - startTime;

        System.out.println(String.format("%s took time: %d ms.",
                actionName,
                TimeUnit.NANOSECONDS.toMillis(duration)));
    }
}
