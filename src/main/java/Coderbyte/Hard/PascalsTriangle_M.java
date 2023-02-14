package Coderbyte.Hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_M {

    public static int PascalsTriangle_M(int[] arr) {
        int level = arr[1];
        List<Integer> triangle = generateTriangle(level);

        int length = arr.length;

        return (arr.length == triangle.size()) ? -1 : triangle.get(length);
    }

    public static List<Integer> generateTriangle(int num) {

        List<Integer> prevPas = new ArrayList<>();
        prevPas.add(1);
        prevPas.add(1);

        List<Integer> newPas = new ArrayList<>();

        for (int i = 2; i <= num; i++) {
            newPas.add(1);
            for (int j = 1; j < prevPas.size(); j++) {
                newPas.add(prevPas.get(j - 1) + prevPas.get(j));
            }
            newPas.add(1);

            if (i == num) {
                return newPas;
            }

            prevPas = newPas;
            newPas = new ArrayList<>();
        }

        return newPas;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3};
        System.out.println(PascalsTriangle_M(ints));

        int[] ints1 = {1, 5, 10, 10};
        System.out.println(PascalsTriangle_M(ints1));

        int[] ints2 = {1, 4, 6, 4};
        System.out.println(PascalsTriangle_M(ints2));

        int[] ints3 = {1, 8, 28, 56};
        System.out.println(PascalsTriangle_M(ints3));

        int[] ints4 = {1, 5, 10};
        System.out.println(PascalsTriangle_M(ints4));

        int[] ints5 = {1, 5, 10, 10, 5, 1};
        System.out.println(PascalsTriangle_M(ints5));

        int[] ints6 = {1, 7, 21, 35};
        System.out.println(PascalsTriangle_M(ints6));

        int[] ints7 = {1, 12, 66, 220};
        System.out.println(PascalsTriangle_M(ints7));

        int[] ints8 = {1, 12, 66, 220, 495, 792};
        System.out.println(PascalsTriangle_M(ints8));

    }

}