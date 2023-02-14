package Coderbyte.Easy;

public class SimpleEvens_M {

    public static String SimpleEvens(String num) {

        for (int i = 0; i < num.length(); i++) {
            int number = Integer.parseInt("" + num.charAt(i));

            if (number % 2 != 0) {
                return "false";
            }

        }

        return "true";
    }

    public static void main(String[] args) {
        System.out.println(SimpleEvens("2222220222"));
        System.out.println(SimpleEvens("20864646452"));
    }

}
