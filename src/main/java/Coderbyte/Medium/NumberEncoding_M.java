package Coderbyte.Medium;

public class NumberEncoding_M {

    public static String NumberEncoding_M(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            if (Character.isLetter(charAt)) {
                result += (charAt - 'a') + 1;
            } else {
                result += charAt;
            }

        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(NumberEncoding_M("hello 45"));
        System.out.println(NumberEncoding_M("jaj-a"));
    }

}
