package Coderbyte.Medium;

import java.util.Arrays;
import java.util.LinkedList;

public class SimpleMode_M {

    public static int SimpleMode_M(int[] arr) {
        int maxMode = 0;
        int maxCounter = 0;

        LinkedList<Integer> list = new LinkedList<>();

        for (int a : arr) {
            list.add(a);
        }

        Arrays.sort(arr);
        int lastIndex = arr.length - 1;

        int counter = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                counter++;
            } else {
                if (counter != 1 && counter == maxCounter && list.lastIndexOf(arr[i - 1]) < lastIndex) {
                    maxCounter = counter;
                    maxMode = arr[i - 1];
                    counter = 1;
                    lastIndex = list.lastIndexOf(arr[i - 1]);
                } else if (counter > maxCounter) {
                    maxCounter = counter;
                    maxMode = arr[i - 1];
                    counter = 1;
                    lastIndex = list.lastIndexOf(arr[i - 1]);
                }
            }
        }

        if (counter > maxCounter) {
            maxMode = arr[arr.length - 1];
        }

        if (counter != 1 && counter == maxCounter && list.lastIndexOf(arr[arr.length - 1]) < lastIndex) {
            maxMode = arr[arr.length - 1];
        }


        return maxCounter == 1 ? -1 : maxMode;
    }

    public static void main(String[] args) {
        int[] ints = {5, 5, 2, 2, 1};
        System.out.println(SimpleMode_M(ints));

        int[] ints1 = {3, 4, 1, 6, 10};
        System.out.println(SimpleMode_M(ints1));

        int[] ints2 = {1, 2, 2, 3};
        System.out.println(SimpleMode_M(ints2));

        int[] ints3 = {1};
        System.out.println(SimpleMode_M(ints3));
    }

}