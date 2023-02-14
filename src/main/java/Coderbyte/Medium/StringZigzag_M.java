package Coderbyte.Medium;

import java.util.Arrays;

public class StringZigzag_M {

    public static String StringZigzag_M(String[] strArr) {
        int length = Integer.parseInt(strArr[1]);

        String[] zigZags = new String[length];
        Arrays.fill(zigZags, "");

        int row = 0;
        boolean dirDown = false;

        String word = strArr[0];

        if (word.length() < length || length == 1) {
            return word;
        }


        for (int i = 0; i < word.length(); i++) {
            zigZags[row] += "" + word.charAt(i);


            if (dirDown) {
                if (row < zigZags.length - 1) {
                    row++;
                } else {
                    dirDown = false;
                    row--;
                }
            } else {
                if (row > 0) {
                    row--;
                } else {
                    dirDown = true;
                    row++;
                }
            }


        }

        String result = "";

        for (int i = 0; i < zigZags.length; i++) {
            result += "" + zigZags[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"cat", "5"};
        System.out.println(StringZigzag_M(strings));

        String[] strings1 = {"kaamvjjfl", "4"};
        System.out.println(StringZigzag_M(strings1));
    }

}
