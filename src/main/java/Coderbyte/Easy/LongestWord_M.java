package Coderbyte.Easy;

public class LongestWord_M {

    public static String LongestWord_M(String sen) {

        int max_length = 0;
        String longest_word = "";

        String result = "";

        for (int i = 0; i < sen.length(); i++) {
            if (Character.isLetterOrDigit(sen.charAt(i))) {
                result += sen.charAt(i);
            } else {
                if (result.length() > max_length) {
                    max_length = result.length();
                    longest_word = result;
                }
                result = "";
            }
        }

        if (result.length() > max_length) {
            max_length = result.length();
            longest_word = result;
        }

        return longest_word;
    }

    public static void main(String[] args) {
        String s = "fun&!! time";
        System.out.println(LongestWord_M(s));

        String s1 = "I love dogs";
        System.out.println(LongestWord_M(s1));

        String s2 = "Hello world123 567";
        System.out.println(LongestWord_M(s2));
    }

}
