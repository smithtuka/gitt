package smith.tuka.algos.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {
    public static void main(String[] args) {
//        int[] arr = {12,3,1,2,-6,5,-8,6};
        int[] arr = new int[]{13, 56, 7, 8, 8, 9, 0, 45, 6, 2, 45, 6, 8, 9, 0, 17};

        threeNumberSum(arr, 86).forEach(a -> System.out.println(Arrays.toString(a)));
    }
        public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
            // Write your code here.
            Arrays.sort(array);
            List<Integer[]> result = new ArrayList<>();

            for(int i=0 ; i<array.length-2; i++){
                int left=i +1, right=array.length-1, pSum;
                while(left<right){
//                    System.out.println(" Right :: " + right);
                                         pSum = array[i]+array[left]+array[right];
                    System.out.println(" partial sum :: " + pSum);
                    if(pSum==targetSum){
                        result.add(new Integer[]{array[i], array[left], array[right]});
                        left++;
                        right--;
                    }else
                    if(pSum<targetSum){
                              left++;
                    } else
                    if(pSum>targetSum){
                        right--;
                    }
                }
            }
            return result;
        }

}
