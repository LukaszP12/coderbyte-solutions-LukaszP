package Coderbyte.Medium;

import java.util.*;

public class ArrayAddition_M {

    static boolean result = false;

    public static boolean ArrayAddition_M(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            list.add(arr[i]);
        }

        int sum = list.stream().reduce(0, Integer::sum);
        if (sum == max) {
            return true;
        }

        subtract(list, max);

        return result;
    }

    private static void subtract(List<Integer> list, int max) {

        int sum = list.stream().reduce(0, Integer::sum);

        if (sum == max) {
            result = true;
        }

        for (int i = 0; i < list.size(); i++) {
            int removed = list.remove(i);
            subtract(list, max);
            list.add(removed);
            Collections.sort(list);
        }

        return;
    }

    public static void main(String[] args) {
        int[] ints = {5, 7, 16, 1, 2};
//        System.out.println(ArrayAddition_M(ints));

        int[] ints1 = {3, 5, -1, 8, 12};
//        System.out.println(ArrayAddition_M(ints1));

        int[] ints2 = {1, 2, 3, 4};
        System.out.println(ArrayAddition_M(ints2));
    }

}