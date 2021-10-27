package smith.tuka.algos.easy;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int arr1[] = {-1, 5, 10, 20, 28, 3},
                arr2[] = {26, 134, 135, 15, 17};
        // -1, 3, 5, 10, 20, 28
        // 15, 17, 26, 134, 135 ans [  28,   26]

        int[] arrayOne = {10, 0, 20, 25, 2000},
                arrayTwo = {1005, 1006, 1014, 1032, 1031};

        System.out.println(Arrays.toString(smallestSum(arrayOne, arrayTwo)));
    }

    public static int[] smallestSum(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int smallest = Integer.MAX_VALUE, current, first = 0, second = 0, i = 0, j = 0;
        int[] result = new int[2];
        while (i < arr1.length && j < arr2.length) {
            first = arr1[i];
            second = arr2[j];
            if (first > second) {
                j++;
                current = first - second;
            } else if (first < second) {
                i++;
                current = second - first;
            } else {
                return new int[]{first, second};
            }
            if (smallest > current) {
                smallest = current;
                result = new int[]{first, second};

            }

        }
        return result;

    }

    public static int[] smallestSum2(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int smallest = Integer.MAX_VALUE, abs, first = 0, second = 0;
        for (int i = 0; i < arr2.length; i++) {
            abs = Math.abs(arr1[i] - arr2[i]);
            if (abs < smallest) {
                first = arr1[i];
                second = arr2[i];
                smallest = abs;
            }
            if (i == arr1.length - 1) {
                return new int[]{first, second};
            }
        }
        return new int[]{};

    }
}
