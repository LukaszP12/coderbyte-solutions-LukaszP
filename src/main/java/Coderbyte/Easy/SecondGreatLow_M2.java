package Coderbyte.Easy;

import java.util.TreeSet;

public class SecondGreatLow_M2 {

    public static String SecondGreatLow(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();

        int initialLength = arr.length;

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        if (set.size() > 2) {
            set.pollFirst();
            set.pollLast();
        }

        if (initialLength == 2) {
            return set.last() + " " + set.first();
        }

        return set.first() + " " + set.last();
    }

    public static void main(String[] args) {
        int[] ints = {1, 42, 42, 180};
        System.out.println(SecondGreatLow(ints));

        int[] ints1 = {4, 90};
        System.out.println(SecondGreatLow(ints1));

        int[] ints2 = {78, 90, 100, 1, 2};
        System.out.println(SecondGreatLow(ints2));

        // incorrect cases
        int[] ints3 = {-4, -5, 10, 2};
        System.out.println(SecondGreatLow(ints3));

        int[] ints4 = {4, 60, 7, 188};
        System.out.println(SecondGreatLow(ints4));
    }

}