package smith.tuka.facebook.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    //    Given a string s, find the length of the longest substring without repeating characters.
    public static void main(String[] args) {
        String word = "abcabcbb"; //
        System.out.println(longestSubString(word));
        System.out.println(longestSubString_sw(word));
    }

    private static int longestSubString(String word) { // brute force
        int ans = 0;
        if (null == word) return 0;
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            int count = 0;
            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                System.out.println("char:" + c + ".");
                if (letters.contains(c)) {
                    letters.clear();
                    break;
                } else {
                    letters.add(c);
                    count++;
                }
                if (count > ans) ans = count;
            }
        }
        return ans;
    }

    // sliding window
    private static int longestSubString_sw(String word) { // brute force
        if (null == word) return 0;
        int n = word.length();
        int i = 0, j = 0, max = 0;
        Set<Character> substring = new HashSet<>();
        while (j < n) {
            if (!substring.contains(word.charAt(j))) {
                substring.add(word.charAt(j));
                max = Math.max(max, substring.size());
                j++;
            } else {
                substring.remove(word.charAt(i));
                i++;
            }
        }
        return max;
    }

}
