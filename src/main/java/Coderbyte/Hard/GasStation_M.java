package Coderbyte.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GasStation_M {

    static List<Integer> listOfIndex = new ArrayList<>();

    public static String GasStation(String[] strArr) {
        int numOfSt = Integer.parseInt(strArr[0]);

        String[] stations = new String[numOfSt];

        for (int i = 1; i < strArr.length; i++) {
            stations[i - 1] = strArr[i];
        }

        for (int i = 0; i < stations.length; i++) {
            explore(i, 0, stations, numOfSt, 0);
        }

        Collections.sort(listOfIndex);

        return listOfIndex.isEmpty() ? "impossible" : String.valueOf(listOfIndex.get(0));
    }

    private static void explore(int startingPoint, int i, String[] stations, int numOfSt, int gas) {

        int currentPoint = (startingPoint + i) % numOfSt;

        if (gas < 0) {
            return;
        }

        if (i == numOfSt) {
            listOfIndex.add(startingPoint + 1);
            return;
        }

        String[] split = stations[currentPoint].split(":");

        gas += Integer.valueOf("" + split[0]) - Integer.valueOf("" + split[1]);

        explore(startingPoint, i + 1, stations, numOfSt, gas);

    }

    public static void main(String[] args) {
//        String[] strings = {"4", "1:1", "2:2", "1:2", "0:1"};
//        System.out.println(GasStation(strings));

//        String[] strings1 = {"4", "0:1", "2:2", "1:2", "3:1"};
//        System.out.println(GasStation(strings1));

//        String[] strings2 = {"5", "3:3", "1:2", "2:2", "3:2", "4:3"};
//        System.out.println(GasStation(strings2));

        String[] strings3 = {"6", "3:2", "2:2", "10:6", "0:4", "1:1", "30:10"};
        System.out.println(GasStation(strings3));

    }

}
