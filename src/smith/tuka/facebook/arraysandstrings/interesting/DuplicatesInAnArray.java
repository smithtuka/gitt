package smith.tuka.facebook.arraysandstrings.interesting;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInAnArray {
//Given an integer array nums of length n where all the integers of nums are in the range [1, n]
// and each integer appears once or twice, return an array of all the integers that appears twice.
//
//You must write an algorithm that runs in O(n) time and uses only constant extra space.

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5, 5, 9, 10, 10, 1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // to match condition range [1, n], and avoid going out of bounds
            if (nums[index] < 0) {
                results.add(index + 1);
            } else
                nums[index] = -nums[index];
        }
        return results;
    }
}
