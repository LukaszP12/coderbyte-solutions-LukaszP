package Coderbyte.Hard;

import java.util.*;

public class LineOrdering_M {

    static int totalCount = 0;

    public static int LineOrdering_M(String[] strArr) {

        Set<String> letters = new HashSet<>();
        Map<String, HashSet<String>> proced = new HashMap<>();
        Map<String, HashSet<String>> preced = new HashMap<>();

        for (String s : strArr) {
            String[] split = s.split("[\\>\\<]");
            letters.add(split[0]);
            letters.add(split[1]);

            int index = s.indexOf(">");
            if (index == -1) {
                index = s.indexOf("<");
            }

            String sign = s.charAt(index) + "";

            if (s.charAt(index) == '>') {
                HashSet<String> set = proced.get(split[1]);
                HashSet<String> set1 = preced.get(split[1]);

                if (set == null) {
                    set = new HashSet<>();
                    set.add(split[0]);
                    proced.put(split[1], set);
                } else {
                    set.add(split[0]);
                    proced.put(split[1], set);
                }

//                if (set1 == null) {
//                    set = new HashSet<>();
//                    set.add(split[1]);
//                    preced.put(split[0], set);
//                } else {
//                    set.add(split[1]);
//                    preced.put(split[0], set);
//                }


            } else {
                HashSet<String> set = proced.get(split[0]);
                HashSet<String> set1 = preced.get(split[1]);

                if (set == null) {
                    set = new HashSet<>();
                    set.add(split[1]);
                    proced.put(split[0], set);
                } else {
                    set.add(split[1]);
                    proced.put(split[0], set);
                }

//                if (set1 == null) {
//                    set1 = new HashSet<>();
//                    set1.add(split[0]);
//                    preced.put(split[1], set1);
//                } else {
//                    set1.add(split[0]);
//                    preced.put(split[1], set1);
//                }

            }

        }

        for (String l : letters) {
            explore(l, proced, 0, "");
        }


        return totalCount;
    }

    private static void explore(String l, Map<String, HashSet<String>> proced, int count, String line) {

        if (line.contains(l)) {
            return;
        }

        if (count == proced.size()) {
            totalCount++;
        }


        Set<String> set = proced.get(l);
        if (set != null) {
            for (String s : set) {
                explore(s, proced, count + 1, line + l);
            }
        } else {
            if (count < proced.size()) {
                for (char c : line.toCharArray()) {
                    Set<String> set1 = proced.get("" + c);

                    for (String s : set1) {
                        if (!line.contains(s)) {
                            explore(s, proced, count + 1, line + l);
                        }
                    }
                }

            }
        }


    }

    public static void main(String[] args) {
//        String[] strings = {"A>B", "A<C", "C<Z"};
//        System.out.println(LineOrdering_M(strings));

        // incorrect cases

//        String[] strings1 = {"A>B", "B<R", "R<G"};
//        System.out.println(LineOrdering_M(strings1));

        String[] strings2 = {"J>B", "B<S", "D>J"};
        System.out.println(LineOrdering_M(strings2));

//        String[] strings3 = {"A>B", "B>C", "C>D", "G>D"};
//        System.out.println(LineOrdering_M(strings3));

//        String[] strings4 = {"A>B", "B>C", "C>D", "D>E", "G>E"};
//        System.out.println(LineOrdering_M(strings4));

//        String[] strings5 = {"A>B", "C>B", "A<Q"};
//        System.out.println(LineOrdering_M(strings5));
    }

}