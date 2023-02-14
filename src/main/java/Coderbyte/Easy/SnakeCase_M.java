package Coderbyte.Easy;

import java.util.regex.Pattern;

public class SnakeCase_M {

    public static String SnakeCase(String str) {
        String pattern = "\\W";
        String s1 = str.replaceAll(pattern, " ");
        String[] split = s1.split("\\s");

        String result = "";

        for (String s : split) {
            String lowered = s.toLowerCase();
            result += lowered + "_";
        }

        return result = result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String s = "cats AND*Dogs-are Awesome";
        System.out.println(SnakeCase(s));

        String s1 = "a b c d-e-f%g";
        System.out.println(SnakeCase(s1));
    }

}
