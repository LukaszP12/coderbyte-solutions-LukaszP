package pl;

import java.text.ParseException;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class PeselChecker {

    public static boolean isOverAge(String age) {

        String year = age.substring(0, 2);
        String month = age.substring(2, 4);
        String day = age.substring(4, 6);

        System.out.println("year " + year);
        System.out.println("month " + month);
        System.out.println("day " + day);

        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);

        long between = 0;
        if (monthInt >= 81 && monthInt <= 92) { // do 1899
            String extractedYear = "18" + year;
            int extractedYearInt = Integer.parseInt(extractedYear);
            LocalDate localDate = LocalDate.of(extractedYearInt, monthInt, dayInt);

            between = YEARS.between(LocalDate.now(), localDate);

        } else if (monthInt >= 1 && monthInt <= 12) { // do 1999
            String extractedYear = "19" + year;
            int extractedYearInt = Integer.parseInt(extractedYear);
            LocalDate localDate = LocalDate.of(extractedYearInt, monthInt, dayInt);

            between = YEARS.between(LocalDate.now(), localDate);
        } else if (monthInt >= 21 && monthInt <= 32) { // do 2099
            String extractedYear = "20" + year;
            int extractedYearInt = Integer.parseInt(extractedYear);
            int extractedMonthInt = monthInt - 20;
            LocalDate localDate = LocalDate.of(extractedYearInt, extractedMonthInt, dayInt);

            between = YEARS.between(LocalDate.now(), localDate);
        } else if (monthInt >= 41 && monthInt <= 52) {
            String extractedYear = "21" + year;
            int extractedYearInt = Integer.parseInt(extractedYear);
            int extractedMonthInt = monthInt - 40;
            LocalDate localDate = LocalDate.of(extractedYearInt, extractedMonthInt, dayInt);

            between = YEARS.between(LocalDate.now(), localDate);

        } else if (monthInt >= 61 && monthInt <= 72) {
            String extractedYear = "22" + year;
            int extractedYearInt = Integer.parseInt(extractedYear);
            int extractedMonthInt = monthInt - 60;
            LocalDate localDate = LocalDate.of(extractedYearInt, extractedMonthInt, dayInt);

            between = YEARS.between(LocalDate.now(), localDate);
        }
        return Math.abs(between) > 18;
    }

    public static void main(String[] args)  {
        System.out.println(isOverAge("950101"));
        System.out.println(isOverAge("841229"));
        System.out.println(isOverAge("043229"));
        System.out.println(isOverAge("002224"));
        System.out.println(isOverAge("002224"));
    }

}
