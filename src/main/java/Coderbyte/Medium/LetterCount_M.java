package Coderbyte.Medium;

import java.util.ArrayList;

public class LetterCount_M {

    public static String LetterCount_M(String str) {

        ArrayList<String> words = getWords(str);

        int max = 0;
        String maxString = "";

        for (String word : words) {
            int repeatedMax = getRepeatedMax(word);
            if (repeatedMax > max) {
                max = repeatedMax;
                maxString = word;
            }
        }

        return max > 1 ? maxString : "-1";
    }

    private static int getRepeatedMax(String word) {

        int count = word.length();

        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            String s = word.replaceAll("" + charAt, "");
            if (s.length() < count) {
                count = s.length();
            }
        }


        return word.length() - count;
    }

    private static ArrayList<String> getWords(String str) {
        ArrayList<String> words = new ArrayList<>();

        int i = 0;
        String word = "";

        while (i < str.length()) {
            if (str.charAt(i) != ' ') {
                word += str.charAt(i);
            } else {
                words.add(word);
                word = "";
            }
            i++;
        }
        if (word.length() > 0) {
            words.add(word);
        }

        return words;
    }


    public static void main(String[] args) {
        String s = "Hello apple pie";
        String s1 = LetterCount_M(s);
        System.out.println(s1);

        String s2 = "No words";
        System.out.println(LetterCount_M(s2));
    }

}