package Coderbyte.Easy;

public class StringMerge_M {

    public static String StringMerge(String str) {
        String[] split = str.split("\\*");

        String result = "";

        for (int i = 0; i < split[0].length(); i++) {
            result += "" + split[0].charAt(i) + split[1].charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aaa*bbb";
        System.out.println(StringMerge(s));

        String s1 = "123hg*aaabb";
        System.out.println(StringMerge(s1));
    }

}
