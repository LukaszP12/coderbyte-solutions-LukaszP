package Coderbyte.Medium;

import java.util.HashSet;

public class DistinctList_M {

    public static int DistinctList_M(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            } else {
                counter++;
            }

        }

        return counter;
    }


    public static void main(String[] args) {
        int[] ints = {0, -2, -2, 5, 5, 5};
        System.out.println(DistinctList_M(ints));

        int[] ints1 = {100, 2, 101, 4};
        System.out.println(DistinctList_M(ints1));
    }

}