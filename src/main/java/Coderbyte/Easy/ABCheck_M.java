package Coderbyte.Easy;

public class ABCheck_M {

    public static String ABCheck(String str) {
        return Boolean.toString(str.matches(".*[ab].{3}[ab].*"));
    }

    public static void main(String[] args) {
        String s = "after badly";
        System.out.println(ABCheck(s));

        String s1 = "Laura sobs";
        System.out.println(ABCheck(s1));

        String s2 = "bzzza";
        System.out.println(ABCheck(s2));
    }

}
