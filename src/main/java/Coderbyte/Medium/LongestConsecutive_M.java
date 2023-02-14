package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestConsecutive_M {

    public static int LongestConsecutive_M(int[] arr) {
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();

        for (int a : arr) {
            list.add(a);
        }

        int max_length = 0;

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i);
            int counter = 1;
            for (int j = 0; j < list.size(); j++) {
                if (list.contains(start + j + 1)) {
                    counter++;
                } else {
                    if (counter > max_length) {
                        max_length = counter;
                    }
                    break;
                }
            }

        }

        return max_length;
    }

    public static void main(String[] args) {
        int[] ints = {6, 7, 3, 1, 100, 102, 6, 12};
        System.out.println(LongestConsecutive_M(ints));

        int[] ints1 = {5, 6, 1, 2, 8, 9, 7};
        System.out.println(LongestConsecutive_M(ints1));

        int[] ints2 = {4, 3, 8, 1, 2, 6, 100, 9};
        // 1,2,3,4,6,8,9,100
        System.out.println(LongestConsecutive_M(ints2));
    }

}