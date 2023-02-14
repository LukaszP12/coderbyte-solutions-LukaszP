package Coderbyte.Medium;

import java.util.HashMap;

public class StringScramble_M {

    public static boolean StringScramble_M(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {

            if (map1.get(str1.charAt(i)) == null) {
                map1.put(str1.charAt(i), 1);
            } else {
                map1.put(str1.charAt(i), map1.get(str1.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {

            if (map2.get(str2.charAt(i)) == null) {
                map2.put(str2.charAt(i), 1);
            } else {
                map2.put(str2.charAt(i), map2.get(str2.charAt(i)) + 1);
            }
        }

        return map1.entrySet().containsAll(map2.entrySet());
    }

    public static void main(String[] args) {
        System.out.println(StringScramble_M("cdore", "coder"));
        System.out.println(StringScramble_M("h3llko", "hello"));

        System.out.println(StringScramble_M("coodrebtqqkye", "coderbyte"));
    }
}
