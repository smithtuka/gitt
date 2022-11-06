package smith.tuka.jim;

import java.util.Arrays;

public class WordsWithOddLength {
    public static void main(String[] args) {
        String input = "the boy is the one who tore the other boy's book, boy's";
        System.out.println(removeWordsWithOddLength(input));
    }

    private static String removeWordsWithOddLength(String input) {
        StringBuilder sb = new StringBuilder();
        for(String word: input.split("[\\s]")){
//            System.out.println(Arrays.toString(input.split("[\\s]")));
            if(word.length()%2==0) sb.append(word +" ");
        }
        return sb.toString().trim();
    }
}
