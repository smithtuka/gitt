package smith.tuka.algos.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] ar = {3,5,-4,8,11,1,-1,6};
        System.out.println(Arrays.toString(twoNumberSum(ar, 10)));
        System.out.println(Arrays.toString(twoNumberSum(10, ar)));
    }

    public static int[] twoNumberSum(int[] input, int target){
        int[] output = new int[2];
        Map<Integer, Boolean> dump = new HashMap<>();
        for(int i=0; i<input.length; i++){
            int buddyNum = target-input[i];
            if(!dump.containsKey(input[i]) && dump.containsKey(buddyNum)){
                output[0]=input[i];
                output[1]=buddyNum;
                return output;
            }
            else {
                dump.put(input[i], true);
            }
        }
        return new int[]{};
        // O(N) time
        // O(N) space
    }

    public static int[] twoNumberSum( int target, int[] input){
        Arrays.sort(input);
        int[] output = new int[2];
        int i = 0, j = input.length-1;
        while(i<j){
            if(input[j]+input[i]<target){
                i++;
            }
            if(input[j]+input[i]>target){
                j--;
            }
            if(input[j]+input[i]==target){
                output[0]=input[j];
                output[1]=input[i];
                return output;
            }
        }
        // sorting - O(NlogN) time
        // O(1) space
       return new int[]{};
    }
}
