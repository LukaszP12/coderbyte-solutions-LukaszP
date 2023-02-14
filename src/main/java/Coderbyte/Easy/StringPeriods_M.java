package Coderbyte.Easy;

public class StringPeriods_M {

    public static String StringPeriods_M(String str) {
        if (str.length() == 1) {
            return "-1";
        }

        if (str.replaceAll("" + str.charAt(0), "").length() == 0) {
            if (str.length() % 2 == 0) {
                return str.substring(0, str.length() / 2);
            } else if (str.length() % 3 == 0) {
                return str.substring(0, str.length() / 3);
            } else {
                return "" + str.charAt(0);
            }
        }

        int endIndex = 0;


        for (int i = 1; i <= str.length() / 2 + 1; i++) {
            String substring = str.substring(0, i);
            if (str.substring(i).contains(substring)) {
                continue;
            } else {
                endIndex = i - 1;
                break;
            }
        }

        String candidate = "";

        if (endIndex != 0 && str.length() % endIndex == 0) {
            int length2 = str.length() / endIndex;
            for (int i = 0; i < length2; i++) {
                candidate += str.substring(0, endIndex);
            }

        }

        return str.equals(candidate) ? str.substring(0, endIndex) : "-1";
    }


    public static void main(String[] args) {
        String s1 = "abcxabc";
        System.out.println(StringPeriods_M(s1));

        String s2 = "affedaaffed";
        System.out.println(StringPeriods_M(s2));

        String s3 = "abcabcabc";
        System.out.println(StringPeriods_M(s3));

        String s4 = "abcxabc";
        System.out.println(StringPeriods_M(s4));

        String s5 = "abcababcababcab";
        System.out.println(StringPeriods_M(s5));

    }

}