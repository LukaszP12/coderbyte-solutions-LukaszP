package Coderbyte.Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ArrayMatching_M {

    public static String ArrayMatching(String[] strArr) {
        String s1 = strArr[0];
        String s2 = strArr[1];

        s1 = s1.replaceAll("\\]", "").replaceAll("\\[", "").replaceAll("\\s", "");
        s2 = s2.replaceAll("\\]", "").replaceAll("\\[", "").replaceAll("\\s", "");

        String[] split = s1.split(",");
        String[] split1 = s2.split(",");


        LinkedList<Integer> list = new LinkedList<>();

        int arrayLen = split.length > split1.length ? split.length : split1.length;

        int[] ints = new int[arrayLen];
        int[] ints1 = new int[arrayLen];

        Arrays.fill(ints, 0);
        Arrays.fill(ints1, 0);

        for (int i = 0; i < arrayLen; i++) {

            if (i < split.length) {
                ints[i] = Integer.parseInt(split[i]);
            }

            if (i < split1.length) {
                ints1[i] = Integer.parseInt(split1[i]);
            }

        }

        for (int i = 0; i < arrayLen; i++) {
            list.add(ints[i] + ints1[i]);
        }

        return list.stream().map(String::valueOf).collect(Collectors.joining("-"));
    }

    public static void main(String[] args) {
        String[] strings = {"[5, 2, 3]", "[2, 2, 3, 10, 6]"};
        System.out.println(ArrayMatching(strings));

        String[] strings1 = {"[1, 2, 1]", "[2, 1, 5, 2]"};
        System.out.println(ArrayMatching(strings1));
    }

}