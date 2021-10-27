package smith.tuka.algos.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToTheEnd {

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 2, 2, 2, 3, 4, 2};
        System.out.println(moveToEnd(Arrays.asList(arr), 2));
    }

    // O(n) time O(1) space
    public static List<Integer> moveToEnd(List<Integer> arr, int toMove) {
        int i = 0, j = arr.size() - 1;
        while (i < j) {
            while (i < j && arr.get(j) == toMove) j--;
            if (arr.get(i) == toMove) swap(i, j, arr);
            i++;
        }
        return arr;
    }

    private static void swap(int i, int j, List<Integer> arr) {
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, temp);
    }

    // O(n) time O(n) space
    public static List<Integer> moveToEnd2(List<Integer> arr, int toMove) {

        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != toMove) {
                result.add(arr.get(i));
            } else if (arr.get(i) == toMove) count++;
        }
        System.out.println(result);
        while (count > 0) {
            result.add(toMove);
            count--;
        }
        return result;
    }
}
