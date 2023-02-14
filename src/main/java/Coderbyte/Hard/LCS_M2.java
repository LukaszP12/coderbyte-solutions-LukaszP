package Coderbyte.Hard;

import java.util.HashMap;
import java.util.Map;

public class LCS_M2 {


    public static int LCS_M2(String[] strArr) {

        String[] strings = removeRedanant(strArr);

        return compareStrings(strings[0], strings[1]);
    }

    private static int compareStrings(String string, String string1) {

        int count = 0;

        int length = string.length() > string1.length() ? string.length() : string1.length();

        int j = 0;
        for (int i = 0; i < length; i++) {

            while (j < length) {
                if (string.charAt(i) == string1.charAt(j)) {
                    count++;
                    j++;
                    continue;
                } else {
                    j++;
                }
            }

        }


        return count;
    }

    private static String[] removeRedanant(String[] strArr) {
        String[] strings = new String[strArr.length];

        Map<String, Integer> map1 = toMap(strArr[0]);
        Map<String, Integer> map2 = toMap(strArr[1]);

        String out1 = "";
        String out2 = "";

        for (int i = 0; i < strArr[0].length(); i++) {
            String s = "" + strArr[0].charAt(i);
            Integer integer = map2.get(s);

            if (integer != null) {
                out1 += s;
            }

        }

        for (int i = 0; i < strArr[1].length(); i++) {
            String s = "" + strArr[1].charAt(i);
            Integer integer = map1.get(s);

            if (integer != null) {
                out2 += s;
            }

        }

        strings[0] = out1;
        strings[1] = out2;

        return strings;
    }


    private static Map<String, Integer> toMap(String word) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            String letter = "" + word.charAt(i);
            Integer integer = map.get(letter);

            if (integer == null) {
                map.put(letter, 1);
            } else {
                map.put(letter, integer + 1);
            }

        }

        return map;
    }

    public static void main(String[] args) {
//        String[] strings = {"abc", "cb"};
//        System.out.println(LCS_M2(strings));

        // incorrect cases

        String[] strings1 = {"bcacb", "aacabb"};
        System.out.println(LCS_M2(strings1));

        String[] strings2 = {"abcabb", "bacb"};
        System.out.println(LCS_M2(strings2));

        String[] strings3 = {"bcacb", "aacabb"};
        System.out.println(LCS_M2(strings3));
    }

}