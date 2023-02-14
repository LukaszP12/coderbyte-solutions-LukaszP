package Coderbyte.Hard;

public class PatternChaser_M {

    public static String PatternChaser(String str) {

        String result = "no null";

        int longest = 0;
        int j = 0;

        String patternCand = "";

        while (j < str.length()) {
            for (int i = j; i < str.length(); i++) {
                patternCand = str.substring(j, i);

                String leftString = str.substring(i);
                if (leftString.contains(patternCand)) {
                    if (patternCand.length() > 1 && patternCand.length() > longest) {
                        longest = patternCand.length();
                        result = "yes " + patternCand;
                    }

                }
            }
            j++;
        }

        return result;
    }


    public static void main(String[] args) {
        String da2kr32a2 = "da2kr32a2";
        System.out.println(PatternChaser(da2kr32a2));

        String sskfssbbb9bbb = "sskfssbbb9bbb";
        System.out.println(PatternChaser(sskfssbbb9bbb));
    }

}
