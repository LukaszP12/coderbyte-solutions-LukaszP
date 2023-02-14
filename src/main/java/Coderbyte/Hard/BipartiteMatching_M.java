package Coderbyte.Hard;

import java.util.*;
import java.util.stream.Collectors;

public class BipartiteMatching_M {

    static int maxMatch = 0;

    public static int BipartiteMatching_M(String[] strArr) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            String[] split = strArr[i].split("->");
            if (!map.containsKey(split[0])) {
                ArrayList<String> list = new ArrayList<>();
                list.add(split[1]);
                map.put(split[0], list);
                continue;
            }
            List<String> list1 = map.get(split[0]);
            list1.add(split[1]);
            map.put(split[0], list1);
        }

        Set<String> visitors = new HashSet<>();
        explore(map, visitors);

        return maxMatch;
    }

    private static void explore(Map<String, List<String>> map, Set<String> visitors) {

        while (!map.isEmpty()) {

            String key = map.keySet().iterator().next();

            List<String> list = map.remove(key);

            if (list != null) {
                for (String s : list) {
                    if (!visitors.contains(s)) {
                        Set<String> visitors1 = visitors.stream().collect(Collectors.toSet());
                        visitors1.add(s);
                        explore(new HashMap<>(map), visitors1);
                    }

                }
            }
        }


        if (visitors.size() > maxMatch) {
            maxMatch = visitors.size();
        }

    }

    public static void main(String[] args) {
        String[] strings = {"a->w", "a->x", "b->x", "b->y", "c->x", "c->z", "d->w"};
        System.out.println(BipartiteMatching_M(strings));

        String[] strings1 = {"a->b", "c->b", "c->d", "e->b"};
        System.out.println(BipartiteMatching_M(strings1));

        String[] strings2 = {"a->w", "a->x", "b->y", "c->y", "d->z", "d->r", "e->z", "f->y"};
        System.out.println(BipartiteMatching_M(strings2));
    }

}