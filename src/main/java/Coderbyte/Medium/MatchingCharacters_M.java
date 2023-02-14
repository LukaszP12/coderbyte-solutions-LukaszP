package Coderbyte.Medium;

import java.util.HashSet;
import java.util.Set;

public class MatchingCharacters_M {

    public static int MatchingCharacters_M(String str) {
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    String substring = str.substring(i + 1, j);
                    int count = count(substring);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }

        return max;
    }

    private static int count(String substring) {
        Set<String> letters = new HashSet<>();

        for (int i = 0; i < substring.length(); i++) {
            letters.add("" + substring.charAt(i));
        }

        return letters.size();
    }

    public static void main(String[] args) {
        System.out.println(MatchingCharacters_M("a"));
        System.out.println(MatchingCharacters_M("mmmerme"));
        System.out.println(MatchingCharacters_M("ahyjakh"));
        System.out.println(MatchingCharacters_M("abccdefghi"));
        System.out.println(MatchingCharacters_M("ghececgkaem"));
    }
}
