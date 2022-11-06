package smith.tuka.facebook.arraysandstrings.interesting;

import java.util.Arrays;

public class QuickSort_Descending {
    public static void main(String[] args) {
        int[] arr = {10, 3, 7, 7, 12, 77, 32, 56, 24, 77, 2, 5, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr)); // rectify
    }

    public static void quickSort(int[] ar, int start, int end) {
        if (start <end) {
            int p = partition(ar, start, end);
            quickSort(ar, start, p-1);
            quickSort(ar, p+1, end);
        }
    }

    public static int partition(int[] ar, int start, int end) {
        int pivot = ar[end];
        int i = start;
        for (int j = end; j>= start; j--) {
            if (ar[j] > pivot) {
                int temp1 = ar[i];
                ar[i] = ar[j];
                ar[j] = temp1;

                i = i+1;
            }
        }
        int temp2 = ar[i];
        ar[i] = ar[end];
        ar[end] = temp2;
        return i;
    }
}

