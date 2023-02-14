package Coderbyte.Easy;

import java.util.ArrayList;

public class Superincreasing_M2 {

    public static boolean Superincreasing(int[] arr) {
        ArrayList<Integer> sums = new ArrayList<Integer>(arr.length);

        sums.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > sums.get(i - 1)) {
                sums.add(sums.get(i - 1) + arr[i]);
            } else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        System.out.println(Superincreasing(ints));

        int[] ints1 = {1, 2, 5, 10};
        System.out.println(Superincreasing(ints1));
    }

}
