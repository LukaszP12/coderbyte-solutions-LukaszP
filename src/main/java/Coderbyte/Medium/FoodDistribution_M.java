package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;

public class FoodDistribution_M {

    static int min_hunger = Integer.MAX_VALUE;

    public static int FoodDistribution_M(int[] arr) {
        int sandwitches = arr[0];

        List<Integer> levels = new ArrayList<>(arr.length - 1);

        for (int i = 1; i < arr.length; i++) {
            levels.add(i - 1, arr[i]);
        }

        feed(sandwitches, levels, 0);

        return min_hunger == Integer.MAX_VALUE ? -1 : min_hunger;
    }

    private static void feed(int sandwitches, List<Integer> levels, int i) {

        if (sandwitches == 0 || i == levels.size() - 1) {
            if (countHungerLevel(levels) < min_hunger) {
                min_hunger = countHungerLevel(levels);
            }

            return;
        }

        for (int j = 0; j <= Math.min(levels.get(i), sandwitches); j++) {
            levels.set(i, levels.get(i) - j);

            feed(sandwitches - j, levels, i + 1);

            levels.set(i, levels.get(i) + j);
        }

    }


    private static int countHungerLevel(List<Integer> levels) {
        int diff = 0;

        for (int i = 1; i < levels.size(); i++) {
            diff += Math.abs(levels.get(i) - levels.get(i - 1));
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] ints = {5, 2, 3, 4, 5};
        System.out.println(FoodDistribution_M(ints));

        int[] ints1 = {3, 2, 1, 0, 4, 1, 0};
        System.out.println(FoodDistribution_M(ints1));

        int[] ints2 = {5, 2, 3, 4, 5};
        System.out.println(FoodDistribution_M(ints2));

        int[] ints3 = {4, 5, 4, 5, 2, 3, 1, 2};
        System.out.println(FoodDistribution_M(ints3));
    }

}