package Coderbyte.Easy;

public class NumberStream_M {

    public static String NumberStream_2(String str) {

        for (int i = 0; i < str.length(); i++) {
            String stringOfChars = getStringOfChars(str.charAt(i));
            if (str.contains(stringOfChars)) {
                return "true";
            } else {
                int i1 = str.lastIndexOf(str.charAt(i));
                i = i1 + 1;
            }

        }


        return "false";
    }

    private static String getStringOfChars(char charAt) {
        int num_digits = Integer.parseInt("" + charAt);

        String result = "";

        for (int i = 0; i < num_digits; i++) {
            result += "" + charAt;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(NumberStream_2("5556293383563665"));
        System.out.println(NumberStream_2("5788888888882339999"));
    }

}