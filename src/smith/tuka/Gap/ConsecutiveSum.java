package smith.tuka.Gap;

public class ConsecutiveSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(consecutiveSum(arr, 15));
        System.out.println(consecutiveSum(arr, 10));
    }

    private static boolean consecutiveSum(int[] arr, int target) {
        if(arr==null || arr.length<3) return false;

        for(int i=2; i<arr.length; i++){
            if(arr[i]+arr[i-1]+arr[i-2]==target){
                return true;
            }
        }
        return false;
    }
}
