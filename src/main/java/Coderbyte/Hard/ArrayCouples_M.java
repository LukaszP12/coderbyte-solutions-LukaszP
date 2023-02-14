package Coderbyte.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayCouples_M {

    public static String ArrayCouples(int[] arr) {

        List<String> pairs = toPairsList(arr);
        List<String> newPairs = new ArrayList<>();
        String result = "";

        for (String p : pairs) {
            if (newPairs.contains(p)) {
                continue;
            }

            String reversePair = new StringBuilder(p).reverse().toString();
            String[] split = p.split(",");

            if (pairs.contains(reversePair) && !split[0].equals(split[1])) {
                newPairs.add(p);
                newPairs.add(reversePair);
            } else if (pairs.contains(reversePair) && (split[0].equals(split[1]))) {
                long count = pairs.stream().filter(s -> s.equals(p)).count();

                if (count % 2 == 0) {
                    for (int i = 0; i < count; i += 2) {
                        newPairs.add(p);
                        newPairs.add(reversePair);
                    }
                }

            }

        }


        if (newPairs.containsAll(pairs)) {
            result = "yes";
        } else {
            List<String> diff = new ArrayList<>(pairs);
            diff.removeAll(newPairs);
            result = diff.stream().collect(Collectors.joining(","));
        }


        return result;
    }

    private static void removePair(String p, List<String> pairs) {
        String reversed = new StringBuilder(p).reverse().toString();

        if (pairs.contains(reversed)) {
            pairs.remove(reversed);
            pairs.remove(p);
        }

    }

    private static List<String> toPairsList(int[] arr) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i += 2) {
            int i1 = arr[i];
            int i2 = arr[i + 1];
            String s = i1 + "," + i2;
            list.add(s);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] ints = {2, 1, 1, 2, 3, 3};
        System.out.println(ArrayCouples(ints));

        int[] ints1 = {5, 4, 6, 7, 7, 6, 4, 5};
        System.out.println(ArrayCouples(ints1));

        int[] ints2 = {2, 1, 1, 2, 3, 5};
        System.out.println(ArrayCouples(ints2));

        int[] ints3 = {6, 2, 2, 6, 5, 14, 14, 1};
        System.out.println(ArrayCouples(ints3));

    }

}
