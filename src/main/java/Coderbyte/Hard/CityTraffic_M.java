package Coderbyte.Hard;

import java.util.*;

public class CityTraffic_M {


    public static String CityTraffic_M(String[] strArr) {
        Map<Integer, List<Integer>> cities = new HashMap<Integer, List<Integer>>();

        for (String s : strArr) {
            String[] split = s.split(":");
            String[] split1 = split[1].substring(1, split[1].length() - 1).split(",");

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                list.add(Integer.parseInt(split1[i]));
            }
            cities.put(Integer.parseInt(split[0]), list);
        }

        String result = "";

        for (Integer city : cities.keySet()) {
            result += city + ":" + getPopulation(city, cities) + ",";
        }

        return result.substring(0, result.length() - 1);
    }

    private static int getPopulation(Integer city, Map<Integer, List<Integer>> cities) {
        int[] children = new int[cities.get(city).size()];
        int i = 0;
        for (Integer child : cities.get(city)) {
            children[i] = getSumAllChildren(child, cities, child, new HashSet<>());
            i++;
        }
        Arrays.sort(children);
        return children[children.length - 1];
    }


    private static int getSumAllChildren(int start, Map<Integer, List<Integer>> cities, Integer city, HashSet<Integer> visited) {
        List<Integer> neighbours = cities.get(city);

        visited.add(city);

        int sum = 0;
        for (int neighbour : neighbours) {
            if (neighbour != start && !visited.contains(neighbour)) {
                sum += getSumAllChildren(start, cities, neighbour, new HashSet<>(visited));
            } else {
                sum += city;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        String[] strings = {"1:[5]", "2:[5]", "3:[5]", "4:[5]", "5:[1,2,3,4]"};
        System.out.println(CityTraffic_M(strings));

        String[] strings1 = {"1:[5]", "2:[5,18]", "3:[5,12]", "4:[5]", "5:[1,2,3,4]", "18:[2]", "12:[3]"};
        System.out.println(CityTraffic_M(strings1));
    }

}
