package Coderbyte.Easy;

import java.util.HashSet;

public class ThreeNumbers_M {

    public static String ThreeNumbers(String str) {
        String[] split = str.split("\\s");

        for (int i = 0; i < split.length; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = 0; j < split[i].length(); j++) {

                char charAt = split[i].charAt(j);

                if (Character.isDigit(charAt)) {
                    set.add(charAt - 48);
                }
            }

            if (set.size() != 3) {
                return "false";
            }
        }

        return "true";
    }

    public static void main(String[] args) {
        String s = "2a3b5 w1o2rl3d g1gg92";
        System.out.println(ThreeNumbers(s));

        String s1 = "21aa3a ggg4g4g6ggg";
        System.out.println(ThreeNumbers(s1));

        // incorrect case
        String s2 = "hell268o w6or2l4d";
        System.out.println(ThreeNumbers(s2));
    }

}