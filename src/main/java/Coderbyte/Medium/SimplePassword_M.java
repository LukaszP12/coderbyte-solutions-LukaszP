package Coderbyte.Medium;

import java.util.Arrays;
import java.util.List;

public class SimplePassword_M {

//    1. It must have a capital letter.
//    2. It must contain at least one number.
//    3. It must contain a punctuation mark or mathematical symbol.
//    4. It cannot have the word "password" in the string.
//    5. It must be longer than 7 characters and shorter than 31 characters.

    public static boolean SimplePassword_M(String str) {

        if (str.length() < 7 || str.length() > 31) {
            return false;
        }

        if (str.replaceAll("[A-Z]", "").length() == str.length()) {
            return false;
        }

        if (!containsMark(str)) {
            return false;
        }

        if (str.replaceAll("\\d", "").length() == str.length()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            String word = "";
            if (charAt == 'p' || charAt == 'P') {
                if (i + 8 < str.length()) {
                    word = str.substring(i, i + 8);
                }

                if ("password".equalsIgnoreCase(word)) {
                    return false;
                }
            }
        }


        return true;
    }

    private static boolean containsMark(String str) {
        List<String> signs = Arrays.asList(".", ",", "!", "?", ":", ";", "+", "-", "/", "*", "=");
        boolean contains = false;

        for (String s : signs) {
            if (str.contains(s)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    public static void main(String[] args) {
        System.out.println(SimplePassword_M("passWord123!!!!"));
        System.out.println(SimplePassword_M("turkey90AAA="));
        System.out.println(SimplePassword_M("apple!M7"));
    }

}