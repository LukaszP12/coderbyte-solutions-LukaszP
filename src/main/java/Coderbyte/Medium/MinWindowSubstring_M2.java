package Coderbyte.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinWindowSubstring_M2 {

    public static String MinWindowSubstring_M2(String[] strArr) {
        String[] split = strArr[1].split("");
        List<String> stringList = Arrays.stream(split).sorted().collect(Collectors.toList());
        Map<String, Long> mapSearch = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        String baseWord = strArr[0];

        int smallest = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i < baseWord.length(); i++) {
            for (int j = i + 1; j < baseWord.length() + 1; j++) {
                String wordSubString = baseWord.substring(i, j);

                String[] split1 = wordSubString.split("");
                List<String> strings = Arrays.stream(split1).sorted().collect(Collectors.toList());
                Map<String, Long> wordMap = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                if (wordMapAreSame(mapSearch, wordMap)) {

                    if (strings.size() < smallest) {
                        smallest = strings.size();
                        result = wordSubString;
                    }

                }

            }

        }


        return result;
    }

    private static boolean wordMapAreSame(Map<String, Long> mapSearch, Map<String, Long> wordMap) {

        for (String s : mapSearch.keySet()) {
            if (wordMap.containsKey(s)) {
                long value = wordMap.get(s);
                long value2 = mapSearch.get(s);
                if (value >= value2) {
                    continue;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        }

        return true;
    }


    public static void main(String[] args) {
//        String[] strings = {"ahffaksfajeeubsne", "jefaa"};
//        System.out.println(MinWindowSubstring_M2(strings));

//        String[] strings1 = {"aaffhkksemckelloe", "fhea"};
//        System.out.println(MinWindowSubstring_6(strings1));

//        String[] strings2 = {"aabdccdbcacd", "aad"};
//        System.out.println(MinWindowSubstring_M2(strings2));

        String[] strings3 = {"caae", "cae"};
        System.out.println(MinWindowSubstring_M2(strings3));
    }

}