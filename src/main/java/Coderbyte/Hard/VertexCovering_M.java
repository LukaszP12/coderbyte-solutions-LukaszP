package Coderbyte.Hard;

import java.util.*;
import java.util.stream.Collectors;

public class VertexCovering_M {

    public static String VertexCovering(String[] strArr) {
        String[] verticesArray = strArr[0].substring(1, strArr[0].length() - 1).split(",");

        HashMap<String, Set<String>> connections = new HashMap<>();

        for (String v : verticesArray) {
            connections.put(v, new HashSet<String>());
        }


        String[] connectionsArray = strArr[1].substring(1, strArr[1].length() - 1).split(",");

        LinkedList<LinkedList<String>> vConns = new LinkedList<>();

        for (String c : connectionsArray) {
            String[] conn = c.split("-");
            LinkedList<String> list = new LinkedList<>();
            // we need to keep insertion order
            list.add(conn[0]);
            list.add(conn[1]);

            vConns.add(list);
        }

        String vertex2 = strArr[2].substring(1, strArr[2].length() - 1);
        String[] vertex2Array = vertex2.split(",");

        List<String> leftOut = new LinkedList<>();


        Set<String> finalV = new HashSet<>();

        for (String v : vertex2Array) {
            finalV.add(v);
        }


        for (List<String> list : vConns) {
            if (list.stream().anyMatch(x -> finalV.contains(x))) {
                continue;
            } else {
                String missing = list.stream().collect(Collectors.joining("-"));
                leftOut.add(missing);
            }
        }

        return leftOut.isEmpty() ? "yes" : "(" + leftOut.stream().collect(Collectors.joining(",")) + ")";
    }

    public static void main(String[] args) {
        String[] strings = {"(A,B,C,D)", "(A-B,A-D,B-D,A-C)", "(C)"};
        System.out.println(VertexCovering(strings));

        String[] strings1 = {"(X,Y,Z,Q)", "(X-Y,Y-Q,Y-Z)", "(Z,Y,Q)"};
        System.out.println(VertexCovering(strings1));

        // incorrect cases
        String[] strings2 = {"(X,Y,Z,Q)", "(X-Y,Y-Q,Y-Z,X-Q)", "(X)"};
        System.out.println(VertexCovering(strings2));

        String[] strings3 = {"(X,Y,Z,Q)", "(X-Y,Y-Q,Y-Z,X-Q)", "()"};
        System.out.println(VertexCovering(strings3));
    }

}