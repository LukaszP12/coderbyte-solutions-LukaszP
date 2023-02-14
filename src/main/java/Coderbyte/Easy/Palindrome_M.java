package Coderbyte.Easy;

public class Palindrome_M {

    public static String Palindrome(String str) {

        str = str.replaceAll("\\s", "");

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return "false";
            }

        }

        return "true";
    }

    public static void main(String[] args) {
        String s = "never odd or even";
        System.out.println(Palindrome(s));

        String eye = "eye";
        System.out.println(Palindrome(eye));
    }

}