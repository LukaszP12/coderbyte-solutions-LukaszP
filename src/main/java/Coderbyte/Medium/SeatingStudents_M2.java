package Coderbyte.Medium;

public class SeatingStudents_M2 {

    public static int SeatingStudents_M2(int[] arr) {
        int numberOfSeats = arr[0];
        int counter = 0;

        boolean[] seating = new boolean[numberOfSeats];

        for (int i = 1; i < arr.length; i++) {
            seating[arr[i] - 1] = true;
        }

        for (int i = 0; i < seating.length; i++) {
            if (i % 2 == 0) {
                if (seating[i] == false && seating[i + 1] == false) {
                    counter++;
                }
                if (i >= 2) {
                    if (seating[i] == false && seating[i - 2] == false) {
                        counter++;
                    }
                }

            }

            if (i % 2 != 0) {
                if (i >= 3) {
                    if (seating[i] == false && seating[i - 2] == false) {
                        counter++;
                    }
                }
            }

        }

        return counter;
    }

    public static void main(String[] args) {
        int[] ints = {6, 4};
        System.out.println(SeatingStudents_M2(ints));

        int[] ints1 = {8, 1, 8};
        System.out.println(SeatingStudents_M2(ints1));
    }

}