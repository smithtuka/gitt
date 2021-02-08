package smith.tuka.algos.easy;

public class ValidateSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] sub = {1,3,4};
        System.out.println(validateSubsequence(arr1, sub));
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
}
