package Coderbyte.Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class TwoSum_M {

    public static String TwoSum(int[] arr) {
        int firstElement = arr[0];

        int[] newCopy = Arrays.copyOfRange(arr, 1, arr.length);

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < newCopy.length; i++) {
            for (int j = 0; j < newCopy.length; j++) {
                String num = newCopy[i] + "," + newCopy[j];
                String reverse = newCopy[j] + "," + newCopy[i];

                if (i != j && firstElement == (newCopy[i] + newCopy[j]) && !list.contains(reverse)) {
                    list.add(num);
                }
            }
        }

        return list.isEmpty() ? "-1" : list.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        int[] ints = {17, 4, 5, 6, 10, 11, 4, -3, -5, 3, 15, 2, 7};
        System.out.println(TwoSum(ints));

        int[] ints1 = {7, 6, 4, 1, 7, -2, 3, 12};
        System.out.println(TwoSum(ints1));

        // incorrect cases
        int[] ints2 = {8, 1, 2, 3, 4, 5, 7};
        System.out.println(TwoSum(ints2));

        int[] ints3 = {4, 5, 2, 1};
        System.out.println(TwoSum(ints3));
    }

}