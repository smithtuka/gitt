package smith.tuka.moshi;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(fibonacci(4));

    }

    public static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static int fibonacci(int number) {
        if (number < 2) return number;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
