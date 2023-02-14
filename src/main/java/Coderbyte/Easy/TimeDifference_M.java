package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeDifference_M {

    public static int TimeDifference(String[] strArr) {
        List<Integer> listInMins = new ArrayList<>();
        int smallestDiff = 1440;

        for (int i = 0; i < strArr.length; i++) {
            String pmAm = strArr[i].substring(strArr[i].length() - 2);
            String[] split = strArr[i].substring(0, strArr[i].length() - 2).split(":");
            int hours = Integer.parseInt(split[0]);
            int mins = Integer.parseInt(split[1]);

            if (hours == 12) {
                hours = hours - 12;
            }

            if (pmAm.equals("pm")) {
                hours = hours + 12;
            }

            mins += (hours * 60);
            listInMins.add(mins);
        }

        List<Integer> sortedList = listInMins.stream().sorted().collect(Collectors.toList());

        for (int i = 1; i < sortedList.size(); i++) {
            if ((sortedList.get(i) - sortedList.get(i - 1)) < smallestDiff) {
                smallestDiff = (sortedList.get(i) - sortedList.get(i - 1));
            }
        }

        if (Math.abs((1440 - sortedList.get(sortedList.size() - 1)) + sortedList.get(0)) < smallestDiff) {
            smallestDiff = Math.abs((1440 - sortedList.get(sortedList.size() - 1)) + sortedList.get(0));
        }

        return smallestDiff;
    }

    public static void main(String[] args) {
        String[] strings = {"1:10pm", "4:40am", "5:00pm"};
        System.out.println(TimeDifference(strings));

        String[] strings1 = {"10:00am", "11:45pm", "5:00am", "12:01am"};
        System.out.println(TimeDifference(strings1));
    }

}