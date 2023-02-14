package Coderbyte.Easy;

import java.util.Scanner;

public class StringChanges_M {

//    Whenever a capital M is encountered,
//    duplicate the previous character (then remove the M)

//    whenever a capital N is encountered
//    remove the next character from the string (then remove the N).

    public static String StringChanges(String str) {
        String result = "";

        boolean prevN = false;


        for (int i = 0; i < str.length(); i++) {

            if (prevN) {
                prevN = false;
                continue;
            }

            if (str.charAt(i) == 'M') {
                if (!result.isEmpty()) {
                    String lastChar = result.substring(result.length() - 1);
                    result += lastChar;
                } else {
                    continue;
                }

            } else if (str.charAt(i) == 'M' && !result.isEmpty()) {
            } else if (str.charAt(i) == 'N') {
                prevN = true;
            } else {
                result += "" + str.charAt(i);
            }
        }


        return result;
    }


    public static void main(String[] args) {
        String mrtyNNgMM = "MrtyNNgMM";
        System.out.println(StringChanges(mrtyNNgMM));

        String oMoMkkNrrN = "oMoMkkNrrN";
        System.out.println(StringChanges(oMoMkkNrrN));
    }

}
