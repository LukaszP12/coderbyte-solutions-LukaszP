package Coderbyte.Easy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindIntersection_M {

    public static String FindIntersection(String[] strArr) {
        String s = strArr[0];
        String s1 = strArr[1];
        String result = "";

        String[] split = s.split(", ");
        String[] split1 = s1.split(", ");

        List<String> list1 = Arrays.asList(split);
        List<String> list2 = Arrays.asList(split1);

        Set<String> intersection = list1.stream()
                .distinct()
                .filter(list2::contains)
                .collect(Collectors.toSet());

        List<Integer> resultList = intersection.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());

        for (int i : resultList) {
            result += i + ",";
        }

        if (result.length() == 0) {
            return "false";
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String[] strings = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(FindIntersection(strings));

        String[] strings1 = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"};
        System.out.println(FindIntersection(strings1));

        // incorrect cases
        String[] strings2 = {"1, 2, 3, 4, 5", "6, 7, 8, 9, 10"};
        System.out.println(FindIntersection(strings2));
    }

}