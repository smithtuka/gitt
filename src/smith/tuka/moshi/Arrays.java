package smith.tuka.moshi;


public class Arrays {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        System.out.println(numbers.indexOf(10));
        numbers.insert(20);
        numbers.insert(10);
        numbers.insert(30);
        System.out.println(numbers.indexOf(10));

        numbers.removeAt(5);

        numbers.print();
    }
}
