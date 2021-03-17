package smith.tuka.algos.medium;

import java.util.*;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] input = {3, 5, -1, 4, 8, 8, 11, 6, 5, -1, 4, 8, 8, 11, 6};
//        int[] input = { 11,6};
        int target = 16;

        System.out.println(Arrays.toString(towNumberSumIII(input, target)));
    }

    //    O(N) time
//    O(N) space
    private static int[] towNumberSum(int[] input, int target) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length - 1; j++) {
                if (input[i] + input[j] == target) {
                    return new int[]{input[i], input[j]};
                }
            }
        }
        return new int[]{};
    }

    // O(NlogN) time
    // O(1)
    private static int[] towNumberSumII(int[] input, int target) {
        Arrays.sort(input);
        int i = 0, j = input.length - 1;
        while (i < j) {
            if (input[i] + input[j] < target) {
                i++;
            } else if (input[i] + input[j] > target) {
                j--;
            } else if (input[i] + input[j] == target) {
                return new int[]{input[i], input[j]};
            }

        }
        return new int[]{};

    }

    private static int[] towNumberSumIII(int[] input, int target) {
        int compliment;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<input.length; i++){
            compliment=target-input[i];
            if(set.contains(compliment)) {
                return new int[]{compliment, input[i]};
            }
            else {
                set.add(input[i]);
            }
        }
            return new int[]{};
    }

}
