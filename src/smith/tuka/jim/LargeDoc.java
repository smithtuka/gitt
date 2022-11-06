package smith.tuka.jim;

import java.util.LinkedHashMap;
import java.util.Map;

public class LargeDoc {
    public static void main(String[] args) {
        String input = "the boy is the one who tore the other boy's book, boy's";
        System.out.println(firstNonRepeatingWord(input));
    }

    private static String firstNonRepeatingWord(String input) {
        if (input == null || input.length() == 0) return null;
//        input.split("[\r\n\t]");
        String[] doc = input.split(" ");

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : doc) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else map.put(word, 1);

        }
        System.out.println(map.entrySet());

        for (String word : map.keySet()) {
            if (map.get(word) == 1) return word;
        }
        return null;
    }

    // HashSet (fast search, insert, delete O(1) --> equals, accepts Nulls
    // TreeSet --> natural order O(logn) ie asc, compareTo for duplicate check, good locality , NPE for nulls,
//    LinkedHashSet is there between --> keeps insertion order
}
