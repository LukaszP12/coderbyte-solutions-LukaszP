package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.List;

public class TriangleRow_M {

    public static int TriangleRow_M(int num) {
        int sum = 0;

        if (num == 0) {
            return 1;
        }

        if (num == 1) {
            return 2;
        }


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
            sum = newPas.stream().reduce(0, Integer::sum);
            prevPas = newPas;
            newPas = new ArrayList<>();
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(TriangleRow_M(1));
        System.out.println(TriangleRow_M(2));
        System.out.println(TriangleRow_M(3));
        System.out.println(TriangleRow_M(4));
        System.out.println(TriangleRow_M(6));
        System.out.println(TriangleRow_M(7));
    }

}