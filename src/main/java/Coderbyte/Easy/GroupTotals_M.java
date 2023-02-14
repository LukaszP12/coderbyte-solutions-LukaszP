package Coderbyte.Easy;

import java.util.TreeMap;

public class GroupTotals_M {

    public static String GroupTotals(String[] strArr) {
        TreeMap<String, Integer> map = new TreeMap<>();
        String result = "";

        for (int i = 0; i < strArr.length; i++) {
            String key = strArr[i].split(":")[0];
            String newValue = strArr[i].split(":")[1];

            Integer value = map.get(key);
            if (value == null) {
                map.put(key, Integer.parseInt(newValue));
            } else {
                map.put(key, map.get(key) + Integer.parseInt(newValue));
            }
        }

        while (map.values().remove(0)) ;

        for (String key : map.keySet()) {
            result += key + ":" + map.get(key) + ",";
        }

        result = result.substring(0, result.length() - 1);

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"X:-1", "Y:1", "X:-4", "B:3", "X:5"};
        System.out.println(GroupTotals(strings));

        String[] strings1 = {"Z:0", "A:-1"};
        System.out.println(GroupTotals(strings1));

        String[] strings2 = {"1:1", "2:1", "2:1", "10:3", "10:7"};
        System.out.println(GroupTotals(strings2));

        String[] strings3 = {"P:1", "N:1", "Z:1", "P:0", "N:-2", "Z:-1"};
        System.out.println(GroupTotals(strings3));
    }

}
