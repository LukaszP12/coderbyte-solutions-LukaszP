package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;

public class PairSearching_M {

    static int minCount = Integer.MAX_VALUE;

    public static int PairSearching_M(int num) {

        List<Integer> list = new ArrayList<>();
        list.add(num);

        search(list, 1);

        return minCount;
    }

    private static void search(List<Integer> list, int count) {
        if (count >= minCount) {
            return;
        }

        if (count == 1 && hasPair(list)) {
            if (count < minCount) {
                minCount = count;
            }
        }

        int num = list.get(list.size() - 1);
        String s = String.valueOf(num);

        for (int i = 0; i < s.length(); i++) {
            int i1 = (int) s.charAt(i) - 48;
            int numNumber = num * i1;
            list.add(numNumber);

            if (hasPair(list)) {
                if (count < minCount) {
                    minCount = count;
                }
            } else {
                count++;
                search(list, count);
            }

        }

    }

    private static boolean hasPair(List<Integer> list) {
        String newList = "";

        for (int l : list) {
            newList += "" + l;
        }

        for (int i = 1; i < newList.length(); i++) {
            if (newList.charAt(i) == newList.charAt(i - 1)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
//        System.out.println(PairSearching_M(8));
        System.out.println(PairSearching_M(134));
//        System.out.println(PairSearching_M(46));
//        System.out.println(PairSearching_M(198));

    }

}