package HomeWork2;

import java.util.Arrays;

public class MyArray {

    public static final int INITIAL_SIZE = 16;
    private int[] arr;
    private int currentSize;

    public MyArray(int maxSize) {
        arr = new int[maxSize];
    }

    public MyArray() {
        arr = new int[INITIAL_SIZE];
    }

    public void add(int value) {
        if (arr.length == currentSize) {
            growArray();
        }
         arr[currentSize] = value;
         currentSize++;
    }

    private void growArray() {
        arr = Arrays.copyOf(arr,arr.length + INITIAL_SIZE);
    }

    public boolean delete (int value) {
        int index = indexOf(value);
        if (index == -1) {
           return false;
        }

        for (int i = index; i<currentSize-1; i++) {
            arr[i] = arr[i+1];
        }
        currentSize--;
        return true;
    }

    public int indexOf(int value) {
        int i;
        for (i = 0; i < currentSize; i++) {
            if (arr[i] == value) {
                break;
            }
        }

        return (i == currentSize)? -1: i;

    }

    public void sortBubble() {
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j <currentSize-1-i; j++){
                if (arr[j] > arr[j+1]) {
                    swap(j, j+1);
                }
            }
        }

    }

    public void sortSelect() {
        for (int i=0; i < currentSize - 1; i++){
            int indexMin = i;
            for (int j=i+1; j < currentSize; j++){
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            swap(i,indexMin);
        }
    }

    public void sortInsert() {
        for (int i = 1; i < currentSize; i++) {
            int temp = arr[i];
            int in = i;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }
    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
