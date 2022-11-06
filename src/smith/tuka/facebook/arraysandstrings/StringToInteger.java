package smith.tuka.facebook.arraysandstrings;

//Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
//
//The algorithm for myAtoi(string s) is as follows:
//
//Read in and ignore any leading whitespace.
//Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
//Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//Return the integer as the final result.

public class StringToInteger {
    public static void main(String[] args) {
        String word = "188837827278";
        System.out.println(atoi2(word));
    }

    private static double atoi(String word) {
        if (null == word || word.length() < 1) return 0;
        boolean isNegative = word.charAt(0) == '-';
        StringBuilder sb = new StringBuilder();
        int start = (word.charAt(0) == '-' || word.charAt(0) == '+') ? 1 : 0;
        for (int i = start; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                if (sb.indexOf(".") != -1) {
                    sb.append(".");
                    continue;
                } else {
                    break;
                }
            }
            if (isANumber(word.charAt(i))) {
                sb.append(word.charAt(i));
            } else
                break;
        }
        double ans = isNegative ? (-1) * Double.parseDouble(sb.toString()) : Double.parseDouble(sb.toString());
        ans = (ans < 0 && ans < -1 * Math.pow(2, 231) + 1) ? -1 * Math.pow(2, 231) + 1 : ans;
        ans = (ans > 0 && ans > 232) ? Math.pow(2, 231) : ans;
        return ans;
    }

    public static boolean isANumber(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // atoi 2

    public static long atoi2(String word) {
        if (null == word) return -1;
        word = word.trim();
        boolean isNegative = word.charAt(0) == '-';
        int start = (word.charAt(0) == '-' || word.charAt(0) == '+') ? 1 : 0;
        int i = start;
        long ans = 0;
        while (i < word.length()) {
            if (isANumber(word.charAt(i))) {
                ans = 10 * ans + word.charAt(i) - '0'; // Character.getNumericValueOf()
                System.out.print(word.charAt(i) - '0' + ", ");
                System.out.println(Character.getNumericValue(word.charAt(i)) + " ");
                i++;
            } else break;
        }

        ans = checkRange(ans);

        return isNegative && ans != 0 ? -1 * ans : ans;

    }

    private static long checkRange(long ans) {
        if(ans<0 && ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(ans>0 && ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return ans;
        // IF NOT allowed to work with Integer; note 7 is last digit of MAX value, 8 for min Value
//        divide by 10, check if next didgit to add is <=7, else take max Number
    }


}
