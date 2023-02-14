package Coderbyte.Easy;

public class DashInsert_M {

    public static String DashInsert(String str) {
        String result = "";

        int number1 = 0;
        int number2 = 0;

        for (int i = 1; i < str.length(); i++) {
            number1 = Integer.parseInt("" + str.charAt(i - 1));
            number2 = Integer.parseInt("" + str.charAt(i));

            if ((number1 % 2 != 0) && (number2 % 2 != 0)) {
                result += str.charAt(i - 1) + "-";
            } else {
                result += str.charAt(i - 1);
            }

        }

        result += "" + str.charAt(str.length() - 1);


        return result;
    }

    public static void main(String[] args) {
        String s = "99946";
        System.out.println(DashInsert(s));

        String s1 = "56730";
        System.out.println(DashInsert(s1));
    }

}