package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class OffLineMinimum_M {

    public static String OffLineMinimum(String[] strArr) {
        ArrayList<String> result = new ArrayList<>();
        TreeSet<Integer> integers = new TreeSet<>();

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != "E") {
                integers.add(Integer.parseInt(strArr[i]));
            }

            if (strArr[i] == "E") {
                int first = integers.first();
                result.add("" + integers.first());
                integers.remove(first);
            }

        }

        return result.stream().collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        String[] strings = {"1", "2", "E", "E", "3"};
        System.out.println(OffLineMinimum(strings));

        String[] strings1 = {"4", "E", "1", "E", "2", "E", "3", "E"};
        System.out.println(OffLineMinimum(strings1));
    }

}