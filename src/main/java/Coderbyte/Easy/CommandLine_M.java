package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.List;

public class CommandLine_M {

    public static String CommandLine_M(String str) {

        List<Integer> equalSings = new ArrayList<>();
        List<Integer> divs = new ArrayList<>();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '=') {
                equalSings.add(i);
            }
        }

        divs.add(-1);

        divs = getDivs(str, equalSings, divs);

        divs.add(str.length());


        for (int i = 0; i < equalSings.size(); i++) {
            result += (equalSings.get(i) - divs.get(i) - 1) + "=" + (divs.get(i + 1) - equalSings.get(i) - 1) + " ";
        }

        return result;
    }

    private static List<Integer> getDivs(String str, List<Integer> equalSings, List<Integer> divs) {

        for (int i = 0; i < equalSings.size() - 1; i++) {
            String substring = str.substring(equalSings.get(i), equalSings.get(i + 1));

            int index = substring.lastIndexOf(" ");
            divs.add(equalSings.get(i) + index);
        }

        return divs;
    }


    public static void main(String[] args) {
        String s = "letters=A B Z T numbers=1 2 26 20 combine=true";
        System.out.println(CommandLine_M(s));

        String s1 = "a=3 b=4 a=23 b=a 4 23 c=";
        System.out.println(CommandLine_M(s1));
    }

}
