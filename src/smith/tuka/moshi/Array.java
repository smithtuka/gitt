package smith.tuka.moshi;

import java.util.Arrays;

public class Array {
    private int length;
    private int[] array;
    private int currentIndex=0;

    public Array(int length) {
        this.length = length;
        this.array = new int[length];
    }

    public void insert(int number) {
        if (currentIndex < length) {
            array[currentIndex] = number;
            currentIndex++;
        } else {
            System.out.println("ArrayIndexOutOfBounds!");
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index " + index + " out of bounds");
        } else {
            int[] newArray = new int[length - 1];
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (i == index) continue;
                newArray[j] = array[i];
                j++;
            }
            array = newArray;
            length = length--;
        }
    }

    public int indexOf(int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) return i;
        }
        return -1;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    private void resize() {
        int RESIZE_FACTOR = 2;
        array = Arrays.copyOf(array, length * RESIZE_FACTOR);
        currentIndex = length;
        length = array.length;
//        System.arraycopy(array, 0, newArray, array.length, array.length);
    }

    public static void main(String[] args) {
        Array n = new Array(2);
//        n.resize();
        n.print();
    }
}
