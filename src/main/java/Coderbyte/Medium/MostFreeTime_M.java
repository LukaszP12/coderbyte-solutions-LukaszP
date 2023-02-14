package Coderbyte.Medium;

import java.util.Arrays;

public class MostFreeTime_M {

    public static String MostFreeTime_M(String[] times) {

        int[] beginTimes = new int[times.length];
        int[] endTimes = new int[times.length];

        for (int i = 0; i < times.length; i++) {

            String hour1 = times[i].split("-")[0].split(":")[0];
            String hour2 = times[i].split("-")[1].split(":")[0];

            String am1 = times[i].split("-")[0].substring(times[i].split("-")[0].length() - 2).toLowerCase();
            String am2 = times[i].split("-")[1].substring(times[i].split("-")[1].length() - 2).toLowerCase();

            String min1 = times[i].split("-")[0].split(":")[1].substring(0, times[i].split("-")[0].split(":")[1].length() - 2);
            String min2 = times[i].split("-")[1].split(":")[1].substring(0, times[i].split("-")[0].split(":")[1].length() - 2);

            beginTimes[i] = convertToMin(hour1, am1) + Integer.parseInt(min1);
            endTimes[i] = convertToMin(hour2, am2) + Integer.parseInt(min2);

        }

        Arrays.sort(beginTimes);
        Arrays.sort(endTimes);

        int max = 0;

        int j = 0;

        for (int i = 0; i < beginTimes.length; i++) {

            if (beginTimes[i] >= endTimes[j]) {
                int diff = CountingMinutes(endTimes[j], beginTimes[i]);
                if (diff > max) {
                    max = diff;
                }
                j++;
            }

        }

        return minToTime(max);
    }

    private static String minToTime(int max) {
        String result = "";

        int hour = max / 60;
        int min = max % 60;

        if (hour < 10) {
            result += "0" + hour;
        } else {
            result += hour;
        }

        result += ":";

        if (min < 10) {
            result += "0" + min;
        } else {
            result += min;
        }

        return result;
    }

    private static int CountingMinutes(int endTime, int beginTime) {

        if (beginTime > endTime) {
            return beginTime - endTime;
        } else {
            return 0;
        }

    }

    private static int convertToMin(String h, String amPm1) {
        int hour = Integer.parseInt(h);

        if (amPm1.equals("am") && hour == 12) {
            return 0;
        }
        if (amPm1.equals("am") && hour != 12) {
            return hour * 60;
        }

        if (amPm1.equals("pm") && hour == 12) {
            return hour * 60;
        }

        if (amPm1.equals("pm") && hour != 12) {
            return (hour + 12) * 60;
        }

        return 0;
    }

    public static void main(String[] args) {
        String[] strings = {"12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"};
        System.out.println(MostFreeTime_M(strings));

        String[] strings1 = {"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};
        System.out.println(MostFreeTime_M(strings1));

        System.out.println(minToTime(30));
    }

}