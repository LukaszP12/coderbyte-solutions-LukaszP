package Coderbyte.Hard;

import java.util.*;

public class ShortestPath_M {

    public static String ShortestPath_M(String[] strArr) {

        Map<String, List<String>> connections = new HashMap<>();

        int num = Integer.parseInt(strArr[0]);
        String source = strArr[1];
        String destination = strArr[num];

        Set<String> graphNodes = new HashSet<>();

        for (int i = 1; i <= num; i++) {
            graphNodes.add(strArr[i]);
        }

        for (int i = num + 1; i < strArr.length; i++) {
            String[] split = strArr[i].split("-");
            if (!connections.containsKey(split[0])) {
                LinkedList<String> nodes = new LinkedList<>();
                nodes.add(split[1]);
                connections.put(split[0], nodes);
            } else {
                List<String> nodes = connections.get(split[0]);
                nodes.add(split[1]);
                connections.put(split[0], nodes);
            }
        }

        for (int i = num + 1; i < strArr.length; i++) {
            String[] split = strArr[i].split("-");
            if (!connections.containsKey(split[1])) {
                LinkedList<String> nodes = new LinkedList<>();
                nodes.add(split[0]);
                connections.put(split[1], nodes);
            } else {
                List<String> nodes = connections.get(split[1]);
                nodes.add(split[0]);
                connections.put(split[1], nodes);
            }
        }

        return shortestDistance(source, destination, num, graphNodes, connections);
    }

    private static String shortestDistance(String source, String destination, int num, Set<String> graphNodes, Map<String, List<String>> connections) {
        Map<String, String> previous = new HashMap<>();

        // breath first search always finds shortest
        // path in a undirected graph
        if (bfs(connections, previous, source, destination, num, graphNodes) == false) {
            return "-1";
        }


        Stack<String> pathFromSourceToDest = new Stack<>();
        String workerNode = destination;
        pathFromSourceToDest.push(workerNode);


        while (previous.get(workerNode) != null) {
            pathFromSourceToDest.push(previous.get(workerNode));
            workerNode = previous.get(workerNode);
        }

        StringBuilder resultantPath = new StringBuilder();
        String loopDelimiter = "";
        String actualDelimiter = "-";
        while (!pathFromSourceToDest.isEmpty()) {
            resultantPath.append(loopDelimiter);
            resultantPath.append(pathFromSourceToDest.pop());
            loopDelimiter = actualDelimiter;
        }

        return resultantPath.toString();
    }

    public static boolean bfs(Map<String, List<String>> connections, Map<String, String> previous, String start, String destination, int v, Set<String> graphNodes) {
        Map<String, Boolean> visited = new HashMap<>();

        for (String gn : graphNodes) {
            visited.put(gn, false);
            previous.put(gn, null);
        }

        visited.put(start, true);

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            String currentNode = queue.remove();

            List<String> neighbours = connections.get(currentNode);

            if (neighbours != null) {
                for (String neighbour : neighbours) {
                    if (visited.get(neighbour) == false) {
                        visited.put(neighbour, true);
                        previous.put(neighbour, currentNode);
                        queue.add(neighbour);

                        if (neighbour.equals(destination)) {
                            return true;
                        }

                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
//        String[] strings = {"5", "A", "B", "C", "D", "F", "A-B", "A-C", "B-C", "C-D", "D-F"};
//        System.out.println(ShortestPath_M(strings));

//        String[] strings1 = {"4", "X", "Y", "Z", "W", "X-Y", "Y-Z", "X-W"};
//        System.out.println(ShortestPath_M(strings1));

        String[] strings2 = {"6", "Z", "B", "C", "A", "Y", "Q", "B-C", "A-B", "A-Z", "C-Y", "Z-Y", "C-Q"};
        System.out.println(ShortestPath_M(strings2));
    }

}