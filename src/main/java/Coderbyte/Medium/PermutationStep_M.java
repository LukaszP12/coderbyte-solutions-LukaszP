package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationStep_M {

    public static int PermutationStep_M(int num) {
        int initNumber = num;

        char c = String.valueOf(num).charAt(0);
        if (String.valueOf(num).replaceAll("" + c, "").length() == 0) {
            return -1;
        }

        if (restNumSmaller(c, String.valueOf(num).substring(1))) {
            return -1;
        }

        while (true) {
            int newNum = ++num;
            if (hasSameDigits(newNum, initNumber)) {
                return newNum;
            }
        }

    }

    private static boolean restNumSmaller(char c, String substring) {
        int num = c - 48;

        char[] nums = substring.toCharArray();

        for (int i = 0; i < nums.length; i++) {
            int num2 = nums[i] - 48;
            if (num < num2) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasSameDigits(int newNum, int initNumber) {
        String result1 = "";
        char[] digits1 = String.valueOf(initNumber).toCharArray();
        Arrays.sort(digits1);

        for (int i = 0; i < digits1.length; i++) {
            result1 += "" + digits1[i];
        }


        String result2 = "";
        char[] digits2 = String.valueOf(newNum).toCharArray();
        Arrays.sort(digits2);

        for (int i = 0; i < digits2.length; i++) {
            result2 += "" + digits2[i];
        }


        return result1.equals(result2);
    }

    public static void main(String[] args) {
        System.out.println(PermutationStep_M(123));
        System.out.println(PermutationStep_M(11121));
        System.out.println(PermutationStep_M(41352));
        System.out.println(PermutationStep_M(897654321));
        System.out.println(PermutationStep_M(44444444));
        System.out.println(PermutationStep_M(76666666));
    }

}