package Coderbyte.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FarthestNodes_M2 {

    public static int FarthestNodes_M2(String[] strArr) {

        Map<String, Set<String>> connections = new HashMap<String, Set<String>>();
        Set<String> nodes = new HashSet<>();

        for (String s : strArr) {
            String[] split = s.split("-");
            String s1 = split[0];
            String s2 = split[1];

            nodes.add(s1);
            nodes.add(s2);

            if (connections.get(s1) == null) {
                HashSet<String> set = new HashSet<>();
                set.add(s2);
                connections.put(s1, set);
            } else {
                Set<String> set = connections.get(s1);
                set.add(s2);
                connections.put(s1, set);
            }

            if (connections.get(s2) == null) {
                HashSet<String> set = new HashSet<>();
                set.add(s1);
                connections.put(s2, set);
            } else {
                Set<String> set = connections.get(s2);
                set.add(s1);
                connections.put(s2, set);
            }
        }

        int maxDistance = 0;
        for (String n : nodes) {
            Set<String> visited = new HashSet<>();
            int max = dfs(n, visited, connections);
            if (max > maxDistance) {
                maxDistance = max;
            }
        }

        return maxDistance;
    }

    private static int dfs(String start, Set<String> visited, Map<String, Set<String>> connections) {
        visited.add(start);

        Set<String> neighbours = connections.get(start);

        if (neighbours == null || neighbours.isEmpty()) {
            return 0;
        }

        int maxDistance = 0;
        for (String neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                int max = 1 + dfs(neighbour, visited, connections);
                if (max > maxDistance) {
                    maxDistance = max;
                }
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        String[] strings = {"b-e", "b-c", "c-d", "a-b", "e-f"};
        System.out.println(FarthestNodes_M2(strings));

        String[] strings1 = {"b-a", "c-e", "b-c", "d-c"};
        System.out.println(FarthestNodes_M2(strings1));
    }

}
