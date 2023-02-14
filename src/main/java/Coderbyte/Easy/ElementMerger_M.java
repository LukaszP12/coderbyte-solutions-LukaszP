package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.List;

public class ElementMerger_M {

    public static int ElementMerger_M(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }

        List<Integer> list = new ArrayList<>(arr.length);

        for (int a : arr) {
            list.add(a);
        }

        List<Integer> newList = new ArrayList<>(arr.length - 1);

        for (int i = 1; i < list.size(); i++) {
            newList.add(Math.abs(list.get(i - 1) - list.get(i)));
        }


        int[] ints = new int[newList.size()];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = newList.get(i);
        }

        return ElementMerger_M(ints);
    }

    public static void main(String[] args) {
        int[] ints = {5, 7, 16, 1, 2};
        System.out.println(ElementMerger_M(ints));

        int[] ints1 = {1, 1, 1, 2};
        System.out.println(ElementMerger_M(ints1));
    }

}