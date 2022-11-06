package smith.tuka.facebook.arraysandstrings;

import java.util.Arrays;

//leetcode 31
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2}; // 2,1
        int[] arr0 = {3, 1}; // 1,3
        int[] arr1 = {1, 2, 3}; // 1,3,2
        int[] arr2 = {3, 2, 1}; // 1,2,3
        int[] arr3 = {1, 1, 5}; // 1,5,1
        int[] arr4 = {1, 2, 5, 4, 3}; // 1,3,2,4,5

//        nextPermutation(arr);
//        nextPermutation(arr0);
//        nextPermutation(arr1);
//        nextPermutation(arr2);
//        nextPermutation(arr3);
//        nextPermutation(arr4);

        // leet code solution
        System.out.println("Solution 2 \n" );

        nextPermutation_2(arr);
        nextPermutation_2(arr0);
        nextPermutation_2(arr1);
        nextPermutation_2(arr2);
        nextPermutation_2(arr3);
        nextPermutation_2(arr4);
    }

    public static void nextPermutation(int[] nums) {

        if (nums.length < 2) return;
        int start = nums[0], n = nums.length - 1;
        sort(nums, 1, n);
//        System.out.println(Arrays.toString(nums));
        if (start < nums[n]) {
            reorder(nums);
        }

        System.out.println(Arrays.toString(nums));

    }

    private static void reorder(int[] nums) {
        // descending from 2nd
        int j = 1;
        int swapIndex = 1;
        int count = 1;
        while (j < nums.length - 1) {
            if (nums[j + 1] == nums[j]) {
                count++;
            } else if (nums[j + 1] > nums[j]) {
                swapIndex = j + 1;
                swap(nums, j, j + 1);
                break;
            }
            j++;
        }
//        swap(nums, count, swapIndex);
    }

    // sorting

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, j, i);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void nextPermutation_2(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i] >= nums[i+1]) i--;

        if(i >= 0){
            int j = nums.length -1;
            while(nums[i] >= nums[j]) j--;

            swap(nums, i, j);
        }

        reverse(nums, i+1);

        System.out.println(Arrays.toString(nums));
    }

    static void reverse(int[] nums, int i){
        int start=i, end = nums.length-1;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

//    void swap(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}


//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such an arrangement is impossible, it must rearrange it to the lowest possible order (i.e., sorted in ascending order).
//
//The replacement must be in place and use only constant extra memory.
