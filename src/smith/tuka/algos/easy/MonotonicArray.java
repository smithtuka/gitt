package smith.tuka.algos.easy;

public class MonotonicArray {
    public static void main(String[] args) {

    }

    public static boolean isMonotonic(int[] arr) {
    		if(arr.length<2) return true;
    boolean first=false, second=false;
		for(int i=0; i<arr.length-1; i++){
        if(arr[i]==arr[i+1]){
            continue;
        }else if(arr[i]-arr[i+1]>0){
            first=true;
        } else if(arr[i]-arr[i+1]<0){
            second=true;
        }
        if(first&&second) return false;
    }
		return true;
}
}
