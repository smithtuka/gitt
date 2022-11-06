package smith.tuka.algos.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

public class GeneralPractice {

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4, 5, 6};
        int[] inputArray2 = {3,5,-4,8,11,1,-1,6};
        System.out.println(Arrays.toString(towNumberSum(inputArray, 11)));
        System.out.println(Arrays.toString(towNumberSum(inputArray2, 10)));

        System.out.println(Arrays.toString(towNumberSum2(inputArray, 11)));
        System.out.println(Arrays.toString(towNumberSum2(inputArray2, 10)));
    }

    private static int[] towNumberSum(int[] inputArray, int targetSum) {
        Arrays.sort(inputArray); // O(NlogN)
        int j = 0, k = inputArray.length - 1;
        while(j<k){
            if(inputArray[j]+inputArray[k]<targetSum){
                j++;
            }
            if(inputArray[j]+inputArray[k]>targetSum){
                k--;
            }
            if(inputArray[j]+inputArray[k]==targetSum){
                return new int[]{inputArray[j], inputArray[k]};
            }
        }
        return new int[]{};
    }

    private static int[] towNumberSum2(int[] inputArray, int targetSum) {
        for(int i=0; i<inputArray.length; i++){
            final int composite = inputArray[i];
            int number=targetSum-composite;
            if(
//                    Arrays.stream(inputArray).anyMatch(x-> x==number)
                    IntStream.of(inputArray).anyMatch(x-> x==number)
            ){
                return new int[]{number,composite};
            }
        }
        return new int[]{};
    }
}
