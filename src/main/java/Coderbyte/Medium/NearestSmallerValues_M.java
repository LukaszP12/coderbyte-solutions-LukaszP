package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class NearestSmallerValues_M {

    public static String NearestSmallerValues_M(int[] arr) {

        List<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                results.add(-1);
                continue;
            }

            int num = findSmallestSoFar(i, arr);

            results.add(num);

        }

        return results.stream().map(String::valueOf).collect(Collectors.joining(" ")).trim();
    }

    private static int findSmallestSoFar(int i, int[] arr) {

        int smallest = arr[i];

        for (int j = i - 1; j >= 0; j--) {

            if (arr[j] <= smallest) {
                smallest = arr[j];
                return smallest;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 9, 7, 3, 4, 1};
        System.out.println(NearestSmallerValues_M(ints));

        int[] ints1 = {2, 4, 5, 1, 7};
        System.out.println(NearestSmallerValues_M(ints1));
    }

}
