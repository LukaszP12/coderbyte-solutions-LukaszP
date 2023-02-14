package Coderbyte.Medium;

import java.util.Arrays;

public class SeatingStudents_M {

    public static int SeatingStudents_M(int[] arr) {
        int numOfSeats = arr[0];
        int count = 0;

        boolean[] occupied = new boolean[numOfSeats];
        Arrays.fill(occupied, false);

        for (int i = 1; i < arr.length; i++) {
            occupied[arr[i] - 1] = true;
        }

        for (int i = 0; i < occupied.length - 2; i++) {
            if ((i % 2 == 0) && !occupied[i] && !occupied[i + 1]) {
                count++;
            }

            if ((i % 2 == 0) && !occupied[i] && !occupied[i + 2]) {
                count++;
            }

            if ((i % 2 == 0) && !occupied[i + 1] && !occupied[i + 3]) {
                count++;
            }
        }
        // better way to capture this
        if (!occupied[occupied.length - 2] && !occupied[occupied.length - 1]) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ints = {12, 2, 6, 7, 11};
        System.out.println(SeatingStudents_M(ints));


        int[] ints1 = {6, 4};
        System.out.println(SeatingStudents_M(ints1));

        int[] ints2 = {4};
        System.out.println(SeatingStudents_M(ints2));

        int[] ints3 = {2};
        System.out.println(SeatingStudents_M(ints3));

        int[] ints4 = {20, 3, 4, 7, 9, 12, 14, 17};
        System.out.println(SeatingStudents_M(ints4));
    }
}
