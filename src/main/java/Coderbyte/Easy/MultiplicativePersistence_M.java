package Coderbyte.Easy;

public class MultiplicativePersistence_M {

    public static int MultiplicativePersistence(int num) {
        int counter = 0;

        while (num >= 10) {
            counter++;
            num = multiplyDigits(num);
        }

        if (num < 10) {
            return counter;
        }

        return -1;
    }

    private static int multiplyDigits(int num) {
        char[] charArray = String.valueOf(num).toCharArray();

        int product = 1;

        for (int i = 0; i < charArray.length; i++) {
            product *= Integer.parseInt("" + charArray[i]);
        }

        return product;
    }

    public static void main(String[] args) {
        System.out.println(MultiplicativePersistence(4));
        System.out.println(MultiplicativePersistence(25));
    }

}
