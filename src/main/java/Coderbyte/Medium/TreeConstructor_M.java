package Coderbyte.Medium;

import java.util.HashMap;

public class TreeConstructor_M {

    public static String TreeConstructor_M(String[] strArr) {
        HashMap<String, Integer> parentCount = new HashMap<>();
        HashMap<String, Integer> childCount = new HashMap<>();

        for (String s : strArr) {
            String[] split = s.replaceAll("[^0-9,]", "").split(",");
            String child = split[0];
            String parent = split[1];

            Integer count = parentCount.get(child);

            if (count == null) {
                parentCount.put(child, 1);
            } else if (count != null) {
                if (count + 1 > 1) {
                    return "false";
                }
                parentCount.put(child, count + 1);
            }

            Integer count2 = childCount.get(parent);
            if (count2 == null) {
                childCount.put(parent, 1);
            } else if (count2 != null) {
                if (count2 + 1 > 2) {
                    return "false";
                }
                childCount.put(parent, count2 + 1);
            }

        }

        return "true";
    }


    public static void main(String[] args) {
        String[] strings = {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        System.out.println(TreeConstructor_M(strings));

        String[] strings1 = {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        System.out.println(TreeConstructor_M(strings1));

        String[] strings2 = {"(1,2)", "(2,4)", "(7,2)"};
        System.out.println(TreeConstructor_M(strings2));

        String[] strings3 = {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        System.out.println(TreeConstructor_M(strings3));
    }

}