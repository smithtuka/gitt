package smith.tuka.fbtop40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {


    public static void main(String[] args) {
        int[] testArray = {1, -1, 3, 4, 5, 7, 10}; // 10
        int[] testArray2 = {3, 5,10}; // 10
        int[] testArray3 = {1, 2, 3, 7, 21, 215, 715, 610, 510, 71, 5, 0, -1, 71, 33, 66, 277, 56, 89, 91, 77, 101, 201, 111}; // 313

        System.out.println(Arrays.toString(twoSumCheck3(testArray2, 10)));
//        System.out.println(Arrays.toString(twoSumCheck2(testArray2, 15)));
//        System.out.println(Arrays.toString(twoSumCheck2(testArray3, 715)));
    }

    public static int[] twoSumCheck(int[] input, int targetSum) {
        System.out.println(Arrays.toString(input));
        Arrays.sort(input); // O(nlogn)
        System.out.println(Arrays.toString(input));
        int i = 0;
        int j = input.length - 1;
        int partialSum;

        while (i < j) {
            partialSum = input[i] + input[j];
            if (partialSum < targetSum) {
                i++; //i=i+1
            } else if (partialSum > targetSum) {
                j--; // j=j-1
            }
            if (partialSum == targetSum) {
                return new int[]{input[i], input[j]};
            }
        }
        return new int[]{};
    }

    public static int[] twoSumCheck2(int[] input, int targetSum) {
        for (int i = 0; i < input.length; i++) {
            final int composite = targetSum - input[i];
            if (IntStream.of(input).anyMatch(x -> x == composite)) { // not workable for numbers adding itself
                return new int[]{input[i], composite};
            }
        }
        return new int[]{};
    }


    public static int[] twoSumCheck3(int[] input, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], i); //O(n)
        }
        int composite;
        for (int i = 0; i < input.length; i++) {
            composite = targetSum - input[i];
            if (map.containsKey(composite) && map.get(composite) != i)
                return new int[]{input[i], composite};
        }
        return new int[]{};
    }

}
