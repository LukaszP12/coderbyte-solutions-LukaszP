package Coderbyte.Medium;

public class EvenPairs_M {

    public static String EvenPairs(String str) {
        String[] numberStrings = str.split("[a-zA-Z]+");

        return findAdjEven(numberStrings) == true ? "true" : "false";
    }

    private static boolean findAdjEven(String[] numberStrings) {

        for (String s : numberStrings) {

            for (int i = 1; i < s.length(); i++) {
                int num1 = Integer.parseInt(s.substring(0, i));

                int num2 = Integer.parseInt(s.substring(i));

                if (num1 % 2 == 0 && num2 % 2 == 0) {
                    return true;
                }

            }

        }

        return false;
    }

    public static void main(String[] args) {
        String pair1 = "f178svg3k19k46";
        System.out.println(EvenPairs(pair1));

        String pair2 = "7r5gg812";
        System.out.println(EvenPairs(pair2));
    }

}