package Coderbyte.Easy;

public class FirstReverse_M {

    public static String FirstReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(FirstReverse("coderbyte"));
        System.out.println(FirstReverse("I Love Code"));
    }

}