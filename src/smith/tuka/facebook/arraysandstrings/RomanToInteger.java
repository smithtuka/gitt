package smith.tuka.facebook.arraysandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {


    public static void main(String[] args) {
        String word = "MMMCMXCIX";
        System.out.println(toInteger(word));
    }

    private static int toInteger(String word) {
        if (null == word || word.equals("")) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        List<Character> numerals = new ArrayList<>(map.keySet());
        int result = 0;
        int sum = 0;
        int current = 0;
        int next = 0;
        word = word.toUpperCase();
        int i = 0;

        while (i < word.length()) {
            current = map.get(word.charAt(i));
            if ((i + 1) < word.length()) {
                next = map.get(word.charAt(i + 1));
            }
            if (next > current) {
                sum = next - current;
                i += 2;
            } else {
                sum = current;
                i++;
            }
            result += sum;
        }
        return result;

    }
}
