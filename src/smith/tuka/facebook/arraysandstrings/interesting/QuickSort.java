package smith.tuka.facebook.arraysandstrings.interesting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {10, 3, 7, 7, 12, 77, 32, 56, 24, 77, 2, 5, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partitioning index
            quickSort(arr, 0, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element and
        // indicates the right position
        // of pivot found so far

        for (int j = low; j < high; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] <= pivot) {
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
