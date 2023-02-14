package Coderbyte.Medium;

public class PalindromicSubstring_M {

    public static String PalindromicSubstring_M(String str) {
        int longest = 0;
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isPalindrome(str.substring(i, j))) {
                    String substring = str.substring(i, j);
                    int length = substring.length();
                    if (length > longest) {
                        longest = length;
                        result = substring;
                    }
                }
            }
        }

        return result.length() > 2 ? result : "none";
    }

    private static boolean isPalindrome(String substring) {

        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(PalindromicSubstring_M("hellosannasmith"));
//        System.out.println(PalindromicSubstring_M("abcdefgg"));
//        System.out.println(PalindromicSubstring_M("dogcatfish"));
//        System.out.println(PalindromicSubstring_M("acaaca"));
//        System.out.println(PalindromicSubstring_M("aabcdcbaa"));

        System.out.println(PalindromicSubstring_M("abcdefgg"));
    }

}
