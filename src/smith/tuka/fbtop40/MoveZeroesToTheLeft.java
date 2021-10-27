package smith.tuka.fbtop40;

import java.util.Arrays;

public class MoveZeroesToTheLeft {
    public static void main(String[] args) {
        int[] array = {3, 1, 0, 2, 3, 0, 67, 0, 9, 5, 3, 5, 0, 0};
        int[] array2 = {0, 0, 3, 10, 0, 2, 13, 0, 67, 0, 9, 5, 3, 5, 0, 0};
        System.out.println(Arrays.toString(moveZeroesToTheLeft_brute(array)));
        System.out.println(Arrays.toString(moveZeroesToTheLeft_brute(array2)));
    }

    public static int[] moveZeroesToTheLeft_brute(int[] input) {
        int readIndex = input.length - 1;
        int writeIndex = input.length - 1;
        if (input.length < 2) {
            return input;
        }
        while (readIndex >= 0) {
            if (input[readIndex] != 0) {
                input[writeIndex] = input[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while (writeIndex >= 0) {
            input[writeIndex] = 0;
            writeIndex--;
        }

        return input;
    }


}
//    Given an integer array, move all elements that are equal to 0 to the left
//    while maintaining the order of other elements in the array.
