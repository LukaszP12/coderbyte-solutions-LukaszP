package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeConstructorTwo_M {

    public static boolean TreeConstructorTwo_M(String[] strArr) {
        if (strArr.length == 0) return true;

        HashMap<String, ArrayList<String>> connections = new HashMap<>();
        HashMap<String, String> parents = new HashMap<>();
        List<String> allChildren = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            String[] split = strArr[i].replaceAll("[^0-9,]", "").split(",");
            String child = split[0];
            String parent = split[1];

            if (parents.containsKey(child)) {
                return false;
            }

            if (connections.containsKey(parent)) {
                ArrayList<String> list = connections.get(parent);
                list.add(child);
                connections.put(parent, list);
                if (connections.get(parent).size() > 2) return false;
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(child);
                connections.put(parent, list);
            }
            parents.put(child, parent);
            allChildren.add(child);
        }
        String root = allChildren.get(0);
        for (String c : allChildren) {
            String parent = parents.get(c);
            int count = 0;
            while (parents.containsKey(parent)) {
                parent = parents.get(parent);
                count += 1;
                if (count > strArr.length) return false;
            }
            if (root != allChildren.get(0) && !parent.equals(root)) {
                return false;
            }
            root = parent;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        System.out.println(TreeConstructorTwo_M(strings));

        String[] strings1 = {"(1,2)", "(1,3)"};
        System.out.println(TreeConstructorTwo_M(strings1));

        String[] strings2 = {"(1,2)", "(3,2)", "(4,5)", "(6,5)", "(5,7)", "(2,7)"};
        System.out.println(TreeConstructorTwo_M(strings2));
    }

}