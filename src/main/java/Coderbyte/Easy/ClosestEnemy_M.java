package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class ClosestEnemy_M {

    public static int ClosestEnemy_M(int[] arr) {
        int oneIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                oneIndex = i;
            }
        }


        ArrayList<Integer> enemies = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                enemies.add(i);
            }
        }

        if (enemies.isEmpty()) {
            return 0;
        }

        int finalOneIndex = oneIndex;
        Set<Integer> set = enemies.stream().map(x -> Math.abs((finalOneIndex - x))).collect(Collectors.toSet());
        int first = set.stream().sorted().findFirst().get();

        return first;
    }

    public static void main(String[] args) {
        int[] ints = {1, 0, 0, 0, 2, 2, 2};
        System.out.println(ClosestEnemy_M(ints));

        int[] ints1 = {2, 0, 0, 0, 2, 2, 1, 0};
        System.out.println(ClosestEnemy_M(ints1));
    }

}