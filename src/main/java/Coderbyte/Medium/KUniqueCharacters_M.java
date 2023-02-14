package Coderbyte.Medium;

import java.util.HashSet;
import java.util.Set;

public class KUniqueCharacters_M {

    public static String KUniqueCharacters_M(String str) {
        int numChars = Integer.parseInt(str.charAt(0) + "");
        String s = str.substring(1);

        Set<Character> unique = new HashSet<>();

        int i = 0;
        int j = 0;

        int max = 0;

        int maxIndexi = i;
        int maxIndexj = j;

        unique.add(s.charAt(0));

        while (i < s.length()) {

            if (j != s.length() - 1) {
                j++;
                unique.add(s.charAt(j));
            } else {
                if (unique.size() == numChars) {
                    int length = s.substring(i).length();
                    if (length > max) {
                        max = length;
                        maxIndexi = i;
                        maxIndexj = j + 1;
                    }
                }

                i++;
                j = i;
                unique.clear();
            }

            if (unique.size() > numChars) {
                int length = s.substring(i, j).length();
                if (length > max) {
                    max = length;
                    maxIndexi = i;
                    maxIndexj = j;
                }
                i++;
                j = i;
                unique.clear();
                unique.add(s.charAt(i));
            }


        }

        return s.substring(maxIndexi, maxIndexj);
    }

    public static void main(String[] args) {
        System.out.println(KUniqueCharacters_M("2aabbcbbbadef"));
        System.out.println(KUniqueCharacters_M("2aabbaaccbbaaccaabb"));

        System.out.println(KUniqueCharacters_M("3aabacbebebe"));
        System.out.println(KUniqueCharacters_M("3aabbaacceeeeeaa"));

    }

}