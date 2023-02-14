package Coderbyte.Easy;

import java.util.HashSet;
import java.util.Set;

public class NonrepeatingCharacter_M {

    public static String NonrepeatingCharacter_M(String str) {

        Set<Character> set = new HashSet<Character>();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            String substring = str.substring(i + 1);

            if (substring.contains(charAt + "")) {
                set.add(charAt);
                continue;
            } else {
                if (!set.contains(charAt)) {
                    result = "" + charAt;
                    return result;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(NonrepeatingCharacter_M("abcdef"));
        System.out.println(NonrepeatingCharacter_M("hello world hi hey"));


        System.out.println(NonrepeatingCharacter_M("agettkgaeee"));
        System.out.println(NonrepeatingCharacter_M("aaaaabbbbbcpcccccddddddeeeeefffffff"));
    }

}
