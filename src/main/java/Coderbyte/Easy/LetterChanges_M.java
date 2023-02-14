package Coderbyte.Easy;

import java.util.Arrays;
import java.util.List;

public class LetterChanges_M {

    static List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

    public static String LetterChanges_M(String str) {
        String result = "";
        char newChar = '0';

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            if (Character.isLetter(charAt)) {
                if (charAt == 'z') {
                    newChar = (char) (charAt - 25);
                } else if (charAt == 'Z') {
                    newChar = (char) (charAt - 25);
                } else {
                    newChar = (char) (charAt + 1);
                }

                if (vowels.contains("" + newChar)) {
                    result += "" + Character.toUpperCase(newChar);
                } else {
                    result += "" + newChar;
                }

            } else {
                result += "" + charAt;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(LetterChanges_M("hello*3"));
        System.out.println(LetterChanges_M("fun times!"));
    }

}