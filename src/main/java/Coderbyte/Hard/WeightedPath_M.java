package Coderbyte.Hard;

import java.util.*;

public class WeightedPath_M {

    static int shortestPath = Integer.MAX_VALUE;
    static String stringResult = "";

    public static String WeightedPath_M(String[] strArr) {
        int numNodes = Integer.parseInt(strArr[0]);
        Set<String> nodes = new HashSet<>();
        Map<String, Integer> connections = new HashMap<>();
        Map<String, Set<String>> neighbours = new HashMap<>();


        for (int i = 1; i < strArr.length; i++) {

            if (i <= numNodes) {
                nodes.add(strArr[i]);
            } else {
                Integer num = Integer.parseInt(strArr[i].substring(strArr[i].length() - 1));

                String[] split = strArr[i].substring(0, strArr[i].length() - 1).split("\\|");
                String s = split[0] + "-" + split[1];
                String s1 = split[1] + "-" + split[0];

                connections.put(s, num);
                connections.put(s1, num);

                Set<String> set = neighbours.get(split[0]);
                if (set == null) {
                    Set<String> nextNodes = new HashSet<>();
                    nextNodes.add(split[1]);
                    neighbours.put(split[0], nextNodes);
                } else {
                    set.add(split[1]);
                    neighbours.put(split[0], set);
                }

                Set<String> set1 = neighbours.get(split[1]);
                if (set1 == null) {
                    Set<String> nextNodes = new HashSet<>();
                    nextNodes.add(split[0]);
                    neighbours.put(split[1], nextNodes);
                } else {
                    set1.add(split[0]);
                    neighbours.put(split[1], set1);
                }

            }
        }

        Set<String> visited = new HashSet<>();

        explore(strArr[1], strArr[numNodes], connections, neighbours, 0, visited, "" + strArr[1]);


        return shortestPath == Integer.MAX_VALUE ? "-1" : stringResult;
    }

    private static void explore(String start, String end, Map<String, Integer> connections, Map<String, Set<String>> neighbours, int count, Set<String> visited, String result) {

        if (visited.contains(start)) {
            return;
        } else {
            visited.add(start);
        }

        if (start.equals(end)) {
            if (shortestPath > count) {
                shortestPath = count;
                stringResult = result;
            }
        }


        Set<String> nextNodes = neighbours.get(start);

        if (nextNodes == null) {
            return;
        }


        if (nextNodes != null) {
            for (String node : nextNodes) {

                String nextNode = start + "-" + node;
                int distance = connections.get(nextNode);

                explore(node, end, connections, neighbours, count + distance, new HashSet<>(visited), result + "-" + node);
            }
        }

    }

    public static void main(String[] args) {
//        String[] strings = {"4", "A", "B", "C", "D", "A|B|2", "C|B|11", "C|D|3", "B|D|2"};
//        System.out.println(WeightedPath_M(strings));

//        String[] strings1 = {"4", "x", "y", "z", "w", "x|y|2", "y|z|14", "z|y|31"};
//        System.out.println(WeightedPath_M(strings1));

//        String[] strings2 = {"6", "A", "B", "C", "D", "E", "F", "B|A|2", "A|F|12", "A|C|4", "B|D|1", "D|E|1", "C|D|4", "F|E|1"};
//        System.out.println(WeightedPath_M(strings2));

        // incorrect cases

        String[] strings3 = {"6", "D", "B", "C", "A", "E", "F", "B|A|2", "A|F|3", "A|C|4", "B|D|1", "D|E|12", "C|D|4", "F|E|1"};
        System.out.println(WeightedPath_M(strings3));

        String[] strings4 = {"6", "D", "B", "C", "A", "E", "F", "B|A|2", "A|F|3", "A|C|4", "B|D|1", "D|E|12", "C|D|4", "F|E|1"};
        System.out.println(WeightedPath_M(strings4));

        String[] strings5 = {"8", "C", "B", "A", "D", "E", "F", "G", "H", "C|D|1", "D|F|2", "G|F|2", "G|E|1", "E|B|1", "H|B|1", "C|A|13", "B|A|2", "C|E|9"};
        System.out.println(WeightedPath_M(strings5));

        String[] strings6 = {"5", "c", "a", "b", "d", "e", "c|a|3", "a|b|2", "a|d|34", "b|e|15", "e|d|2"};
        System.out.println(WeightedPath_M(strings6));
    }

}
