package Coderbyte.Hard;


import java.util.Arrays;

public class KaprekarsConstant {

    static final int Kaprekars = 6174;

    public static int KaprekarsConstant(int num) {

        int currentNum = num;
        int i = 0;

        while (currentNum != Kaprekars) {
            currentNum = makeDesc(currentNum) - makeAsc(currentNum);
            i++;
        }

        return i;
    }


    private static int makeAsc(int currentNum) {
        String s = String.valueOf(currentNum);
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        String s1 = new String(chars);

        while (s1.length() < 4) {
            s1 = "0" + s1;
        }

        return Integer.parseInt(s1);
    }

    private static int makeDesc(int currentNum) {
        String s = String.valueOf(currentNum);
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        char[] descending = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            descending[i] = chars[chars.length - 1 - i];
        }

        String s1 = new String(descending);

        while (s1.length() < 4) {
            s1 = s1 + "0";
        }

        return Integer.parseInt(s1);
    }

    public static void main(String[] args) {
        System.out.println(KaprekarsConstant(2111));
//        System.out.println(KaprekarsConstant(3524));
//        System.out.println(KaprekarsConstant(9831));
//        System.out.println(KaprekarsConstant(4527));
    }

}
