package smith.tuka.facebook.arraysandstrings.interesting;

//LeetCode 266.
public class PalindromePermutation {

    public static void main(String[] args) {
        String word = "racecar";
        System.out.println(hasPalindromePermutation(word));
    }

    private static boolean hasPalindromePermutation(String word) {
        if (null == word) return false;
        int[] char_counts = new int[128]; // ASCII has 128 characters
        for (int i = 0; i < word.length(); i++) {
            char_counts[word.charAt(i)]++; //all were initialized at 0
            System.out.println(char_counts[word.charAt(i)]);
        }
        int count = 0;
        for (int i = 0; i < 128; i++) {
            count += char_counts[i] % 2;
        }
        return count <= 1; // only 1 odd or all ev
    }
}
