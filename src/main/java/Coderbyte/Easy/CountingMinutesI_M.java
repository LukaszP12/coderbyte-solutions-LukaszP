package Coderbyte.Easy;

public class CountingMinutesI_M {


    public static int CountingMinutesI(String str) {
        String[] times = str.split("-");
        String amPm1 = times[0].substring(times[0].length() - 2).toLowerCase();
        String amPm2 = times[1].substring(times[1].length() - 2).toLowerCase();

        int h1 = Integer.parseInt(times[0].substring(0, times[0].length() - 2).split(":")[0]);
        int h2 = Integer.parseInt(times[1].substring(0, times[1].length() - 2).split(":")[0]);

        int min1 = Integer.parseInt(times[0].substring(0, times[0].length() - 2).split(":")[1]);
        int min2 = Integer.parseInt(times[1].substring(0, times[1].length() - 2).split(":")[1]);

        int time1 = convertToMin(h1, amPm1) + min1;
        int time2 = convertToMin(h2, amPm2) + min2;


        if (time2 > time1) {
            return time2 - time1;
        } else {
            return (time2 + 1440) - time1;
        }

    }

    private static int convertToMin(int hour, String amPm1) {
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
        String s = "12:30pm-12:00am";
        System.out.println(CountingMinutesI(s));

        System.out.println(CountingMinutesI("9:00am-10:00am"));
        System.out.println(CountingMinutesI("1:00pm-11:00am"));
        System.out.println(CountingMinutesI("1:23am-1:08am"));

        System.out.println(CountingMinutesI("11:00am-2:10pm"));
    }

}