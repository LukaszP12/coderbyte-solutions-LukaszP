package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class OtherProducts_M {

    public static String OtherProducts(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    list.add(arr[j]);
                }
            }
            int product = list.stream().reduce(1, (a, b) -> a * b);
            results.add(product);
            list = new ArrayList<Integer>();
        }

        return results.stream().map(String::valueOf).collect(Collectors.joining("-"));
    }

    public static void main(String[] args) {
        int[] ints = {1, 4, 3};
        System.out.println(OtherProducts(ints));

        int[] ints1 = {3, 1, 2, 6};
        System.out.println(OtherProducts(ints1));

    }

}
