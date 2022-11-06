package smith.tuka.Gap;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharArray {
    public static void main(String[] args) {
        String input = "hahahajutetjakejha";
        System.out.println(charWithCount(input));
    }

    private static String charWithCount(String input) {
        if (null == input || input.length() < 1) return null;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] characters = input.toCharArray();
        Arrays.sort(characters);
        for (char c : characters) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : map.keySet()) {
            sb.append(c).append(map.get(c)).append(", ");
        }
        return sb.substring(0, sb.lastIndexOf(","));
    }


}
