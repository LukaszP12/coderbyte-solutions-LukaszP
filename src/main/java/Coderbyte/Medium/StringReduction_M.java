package Coderbyte.Medium;

public class StringReduction_M {

    public static int StringReduction_M(String str) {
        if (allSame(str)) {
            return str.length();
        }

        String result = str;

        while (true) {

            char[] charArray = result.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (i + 1 < str.length() && charArray[i] != charArray[i + 1]) {
                    String newSign = replace(charArray[i], charArray[i + 1]);
                    result = result.substring(0, i) + newSign + result.substring(i + 2);
                    break;
                } else {
                    continue;
                }
            }

            if (allSame(result)) {
                return result.length();
            }

        }

    }

    private static String replace(char c, char c1) {

        if ((c == 'b' && c1 == 'c') || (c == 'c' && c1 == 'b')) {
            return "a";
        }

        if ((c == 'a' && c1 == 'c') || (c == 'c' && c1 == 'a')) {
            return "b";
        }

        if ((c == 'a' && c1 == 'b') || (c == 'b' && c1 == 'a')) {
            return "c";
        }

        return "";
    }

    private static boolean allSame(String str) {
        if (str.equals("")) {
            return false;
        }

        char firstChar = str.charAt(0);
        String all = str.replaceAll("" + firstChar, "");
        if (all.length() == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(StringReduction_M("abc"));
        System.out.println(StringReduction_M("cccc"));
        System.out.println(StringReduction_M("abc"));
        System.out.println(StringReduction_M("bcab"));
        System.out.println(StringReduction_M("ccaa"));
        System.out.println(StringReduction_M("abcabc"));
        System.out.println(StringReduction_M("abb"));
        System.out.println(StringReduction_M("ccaa"));
        System.out.println(StringReduction_M("abbcb"));
    }

}