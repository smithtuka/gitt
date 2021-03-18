package smith.tuka.algos.easy;

import java.util.Arrays;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
           /* Given two non-empty arrays of integers, write a function that determines
        whether the second array is a subsequence of the first one.
                A subsequence of an array is a set of numbers that aren't necessarily
        adjacent in the array but that are in the same order as they appear
        in the array. For instance, the numbers [1,3,4] form a subsequence of the array
[1,2,3,4], and so do the numbers [2,4]. note that a single number in an array and the array
        itself are both valid subsequences of the array.
        Sample Input
        array = [5,1,22,25,6,-1,8,10]
        sequence = [1,6,-1,10]
        Hint 1
        you can solve this question by iterating through the main input array once.
                */
        List<Integer> array = Arrays.asList(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = Arrays.asList(90,6,-1,10);
        System.out.println(isValidSubsequence(array,sequence));

        }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
         int index = 0;
         for(Integer val:array){
             if(sequence.get(index).equals(val) ){
                 index++;
             }
         }

        return index == sequence.size();
    }

}
