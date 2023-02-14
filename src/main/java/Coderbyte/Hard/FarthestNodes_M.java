package Coderbyte.Hard;

import java.util.*;

public class FarthestNodes_M {

    public static String FarthestNodes_M(String[] strArr) {

        Map<String, Node> map = new HashMap<>();
        for (String st : strArr) {
            String[] s = st.split("-");
            if (!map.containsKey(s[0])) {
                map.put(s[0], new Node(s[0]));
            }
            if (!map.containsKey(s[1])) {
                map.put(s[1], new Node(s[1]));
            }

            map.get(s[0]).nodes.add(map.get(s[1]));
            map.get(s[1]).nodes.add(map.get(s[0]));
        }

        int max = 0;
        for (String origin : map.keySet()) {
            max = Math.max(max, dfs(map.get(origin), new HashSet<String>(), 0));
        }

        return "" + max;
    }

    private static int dfs(Node node, Set<String> visited, int depth) {
        int max = 0;
        visited.add(node.val);

        for (Node n : node.nodes) {
            if (!visited.contains(n.val)) {
                max = Math.max(max, dfs(n, new HashSet<>(visited), depth + 1));
            }
        }

        return Math.max(depth, max);
    }

    public static class Node {
        final List<Node> nodes = new ArrayList<>();
        final String val;

        public List<Node> getNodes() {
            return nodes;
        }

        public String getVal() {
            return val;
        }

        public Node(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }

    }

    public static void main(String[] args) {
        String[] strings = {"b-e", "b-c", "c-d", "a-b", "e-f"};
        System.out.println(FarthestNodes_M(strings));

        String[] strings1 = {"b-a", "c-e", "b-c", "d-c"};
        FarthestNodes_M(strings1);
    }

}
