package smith.tuka.facebook.arraysandstrings;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9, 9, 10};
//        System.out.println(removeDuplicates(arr));
//        System.out.println(removeDuplicates2(arr));
        System.out.println(removeDuplicates3(arr));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int i = 0, j = 1, count = 0;
        while (j < nums.length - count) {
            if (nums[i] == nums[j]) {
                count++;
                bubble(j, nums, nums.length - count);
                continue;
            }
            i++;
            j++;
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;

    }

    private static void bubble(int start, int[] array, int end) {
        int temp;
        for (int i = start; i < end; i++) {
            temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    private static int removeDuplicates2(int[] nums) {
        int i = 1;
        int j = 0;
        if (nums.length == 1)
            return 1;
        while (i < nums.length) {
            if (nums[i - 1] != nums[i]) {
                nums[++j] = nums[i];
            }
            i++;
        }
        return ++j;
    }

    private static int removeDuplicates3(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                ++left;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }

}
