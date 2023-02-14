package Coderbyte.Medium;

import java.util.Arrays;

public class Consecutive_M {

    public static int Consecutive_M(int[] arr) {

        int length = arr.length;

        Arrays.sort(arr);

        return arr[arr.length - 1] - arr[0] - length + 1;
    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 15};
        System.out.println(Consecutive_M(ints));

        int[] ints1 = {-2, 10, 4};
        System.out.println(Consecutive_M(ints1));
    }

}