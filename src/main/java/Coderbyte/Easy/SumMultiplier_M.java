package Coderbyte.Easy;

import java.util.Arrays;
import java.util.List;

public class SumMultiplier_M {

    public static String SumMultiplier(int[] arr) {

//        List<int[]> ints = Arrays.asList(arr); ?

        int sum = Arrays.stream(arr).sum();
        int doubleSum = sum * 2;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (i != j) {
                    if (arr[i] * arr[j] > doubleSum) {
                        return "true";
                    }
                }

            }
        }

        return "false";
    }

    public static void main(String[] args) {
        int[] ints = {2, 2, 2, 2, 4, 1};
        System.out.println(SumMultiplier(ints));

        int[] ints1 = {1, 1, 2, 10, 3, 1, 12};
        System.out.println(SumMultiplier(ints1));
    }

}
