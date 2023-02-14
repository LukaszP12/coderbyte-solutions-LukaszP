package Coderbyte.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ArrayRotation_M {

    public static String ArrayRotation_M(int[] arr) {
        int first = arr[0];

        List<Integer> result = new ArrayList<Integer>();

        Stack<Integer> stack = new Stack<>();

        for (int i = first - 1; i >= 0; i--) {
            stack.add(arr[i]);
        }

        for (int i = first; i < arr.length; i++) {
            result.add(arr[i]);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }


        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 6};
        System.out.println(ArrayRotation_M(ints));

        int[] ints1 = {4, 3, 4, 3, 1, 2};
        System.out.println(ArrayRotation_M(ints1));
    }

}