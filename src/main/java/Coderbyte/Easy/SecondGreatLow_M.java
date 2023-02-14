package Coderbyte.Easy;

import java.util.Arrays;
import java.util.TreeSet;

public class SecondGreatLow_M {

    public static String SecondGreatLow(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        String result = "";

        for (int a : arr) {
            treeSet.add(a);
        }

        Integer[] integers = treeSet.toArray(new Integer[treeSet.size()]);

        if (integers.length < 2) {
            result += integers[0] + " " + integers[0];
        } else {
            result += "" + integers[1] + " " + integers[integers.length - 2];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 42, 42, 180};
        System.out.println(SecondGreatLow(ints));

        int[] ints1 = {4, 90};
        System.out.println(SecondGreatLow(ints1));

        // incorrect
        int[] ints2 = {80, 80};
        System.out.println(SecondGreatLow(ints2));
    }

}
