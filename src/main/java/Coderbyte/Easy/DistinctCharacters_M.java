package Coderbyte.Easy;

import java.util.HashSet;
import java.util.Set;

public class DistinctCharacters_M {

    public static String DistinctCharacters(String str) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        System.out.println(set.size());
        return set.size() >= 10 ? "true" : "false";
    }

    public static void main(String[] args) {
        String s = "12334bbmma:=6";
        System.out.println(DistinctCharacters(s));

        String s1 = "eeeemmmmmmmmm1000";
        System.out.println(DistinctCharacters(s1));

        String s2 = "12345789mansjvenf";
        System.out.println(DistinctCharacters(s2));
    }

}
