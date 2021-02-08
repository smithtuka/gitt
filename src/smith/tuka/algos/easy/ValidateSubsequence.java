package smith.tuka.algos.easy;

public class ValidateSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] sub = {1,3,4};
        System.out.println(validateSubsequence (arr1, sub));
        System.out.println(validateSubsequence2(arr1, sub));
        System.out.println(validateSubsequence3(arr1, sub));
    }

    private static boolean validateSubsequence(int[] arr1, int[] sub) {
        int count =0;
        for(int i =0;  i<sub.length; i++){
            for(int j=count; j<arr1.length; j++){
                if(sub[i]==arr1[j]) {
                    count = j+1;
                    break;
                }
                if(j==arr1.length-1) return  false;
            }
        }
        return true;
    }

//    O(N) time, O(1) space
    private static boolean validateSubsequence2(int[] arr1, int[] sub) {
        int subIdx =0;
            for(int j=0; j<arr1.length; j++){
                if(subIdx==sub.length) break;
                if(sub[subIdx]==arr1[j]) {
                    subIdx++;
                }
            }
        return subIdx==sub.length;
    }

    private static boolean validateSubsequence3(int[] arr1, int[] sub) {
        int subIdx = 0;
        int arrIdx = 0;
        while (subIdx < sub.length && arrIdx < arr1.length) {
            if (sub[subIdx] == arr1[arrIdx]) {
                subIdx++;
                arrIdx++;
            }
            else arrIdx++;
        }
        return subIdx == sub.length;
    }

    }
