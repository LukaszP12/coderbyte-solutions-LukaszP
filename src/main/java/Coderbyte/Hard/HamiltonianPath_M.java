package Coderbyte.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HamiltonianPath_M {

    public static String HamiltonianPath_2(String[] strArr) {
        String wrongString = "";

        String[] vertices = strArr[0].substring(1, strArr[0].length() - 1).split(",");

        HashMap<String, Set<String>> connections = new HashMap<>();

        for (String v : vertices) {
            connections.put(v, new HashSet<String>());
        }

        String[] connectionsArray = strArr[1].substring(1, strArr[1].length() - 1).split(",");

        for (String s : connectionsArray) {
            String[] split2 = s.split("-");

            String key = split2[0];
            String value = split2[1];

            if (connections.containsKey(key)) {
                Set<String> set = connections.get(key);
                set.add(value);

                if (connections.containsKey(value)) {
                    Set<String> set1 = connections.get(value);
                    set1.add(key);
                }

            }

        }

        String[] path = strArr[2].substring(1, strArr[2].length() - 1).split(",");
        Set<String> visited = new HashSet<>();

        for (int i = 1; i < path.length; i++) {
            String v1 = path[i - 1];
            String v2 = path[i];

            if (!visited.contains(v1) && connections.containsKey(v1)) {
                visited.add(v1);
                Set set = connections.get(v1);
                if (set.contains(v2)) {
                    continue;
                } else {
                    wrongString = v1;
                    break;
                }
            } else {
                break;
            }

        }

        return wrongString.equals("") ? "yes" : wrongString;
    }

    public static void main(String[] args) {
//        String[] strings = {"(A,B,C)", "(B-A,C-B)", "(C,B,A)"};
//        System.out.println(HamiltonianPath_2(strings));

        String[] strings1 = {"(X,Y,Z,Q)", "(X-Y,Y-Q,Y-Z)", "(Z,Y,Q,X)"};
        System.out.println(HamiltonianPath_2(strings1));
    }

}
