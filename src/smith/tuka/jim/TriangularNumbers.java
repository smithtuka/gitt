package smith.tuka.jim;

public class TriangularNumbers {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 6, 10, 15, 21};
        int[] arr = {1,3};
        System.out.println(indexOfaNumber(arr, 10));
        System.out.println(nextNumberInSequence(arr));
    }

    private static Integer indexOfaNumber(int[] arr, int element) {
        if (arr == null) return null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) return i;
        }
        return null;
    }

    private static Integer nextNumberInSequence(int[] arr) {
//        if (arr.length < 3) return null;
        int lastIndex = arr.length - 1;
        int lastAddition = arr[lastIndex] - arr[lastIndex - 1];
        return arr[lastIndex] + lastAddition + 1;
    }

}
