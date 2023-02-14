package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;


public class SwapII_2M {

    public static String SwapII_2M(String str) {

        String result = "";

        String all = str.replaceAll("([0-9])([a-zA-Z]+)([0-9])", "$3$2$1");
        String[] split = all.split("");


        for (int i = 0; i < split.length; i++) {

            if (split[i].matches("[a-zA-Z]")) {
                result += changeCap(split[i]);
            } else {
                result += split[i];
            }

        }


        return result;
    }


    private static String changeCap(String letters) {
        String result = "";

        char[] charArray = letters.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])) {
                result += Character.toUpperCase(charArray[i]);
            } else if (Character.isUpperCase(charArray[i])) {
                result += Character.toLowerCase(charArray[i]);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String l3OV2E = "L3OV2E";
        System.out.println(SwapII_2M("L3OV2E"));

        String s3 = "Hel4lo2 World";
        System.out.println(SwapII_2M(s3));

        String s = "Hello -5LOL6";
        System.out.println(SwapII_2M(s));

        String s1 = "2S 6 du5d4e";
        System.out.println(SwapII_2M(s1));

        String s2 = "123gg))((";
        System.out.println(SwapII_2M(s2));
    }

}
