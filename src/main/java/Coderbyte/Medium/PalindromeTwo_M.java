package Coderbyte.Medium;

public class PalindromeTwo_M {

    public static Boolean PalindromeTwo_M(String str) {
        String s = str.replaceAll("[^A-Za-z]", "").toLowerCase();

        if (isPalindrome(s)) {
            return true;
        }

        return false;
    }

    private static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "Noel - sees Leon";
        String s1 = "A war at Tarawa!";

        System.out.println(PalindromeTwo_M(s));
        System.out.println(PalindromeTwo_M(s1));
    }
}
