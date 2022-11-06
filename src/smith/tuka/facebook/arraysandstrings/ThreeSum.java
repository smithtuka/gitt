package smith.tuka.facebook.arraysandstrings;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arrays = new int[]{13, 56, 7, 8, 8, 9, 0, 45, 6, 2, 45, 6, 8, 9, 0, 17};
        System.out.println(Arrays.toString(threeSum(arrays, 86))); // 86
    }

    private static int[] threeSum(int[] input, int targetSum) {
        System.out.println(Arrays.toString(input));
        int result[];
        if (input == null || input.length < 3) return new int[]{};
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));

        for (int i = 0; i < input.length-2; i++) {
            int left, right = input.length-1;
            int partialSum = 0;
            left = i + 1;
            while (left < right) {
                if (input[i] == 13) {
                    System.out.println(input[i] + ", " + input[left] + ", " + input[right]);
                }
                partialSum = input[i] + input[left] + input[right];
                if (partialSum < targetSum) {
                    left++;
                } else if (partialSum > targetSum) {
                    right--;
                } else if (partialSum == targetSum) {
                    return new int[]{input[i], input[left], input[right]};
                }
                System.out.println(partialSum);
            }
        }
        return new int[]{};
    }
}
