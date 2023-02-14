package Coderbyte.Medium;

public class ArithGeoII_M {

    public static String ArithGeoII_M(int[] arr) {

        int arithDif = arr[1] - arr[0];
        int geoDif = arr[1] / arr[0];
        boolean isArith = false;
        boolean isGeo = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != arithDif) {
                isArith = false;
                break;
            } else {
                isArith = true;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] / arr[i - 1] != geoDif) {
                isGeo = false;
                break;
            } else {
                isGeo = true;
            }
        }

        if (isArith) {
            return "Arithmetic";
        } else if (isGeo) {
            return "Geometric";
        } else {
            return "-1";
        }

    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 15};
        System.out.println(ArithGeoII_M(ints));

        int[] ints1 = {2, 4, 16, 24};
        System.out.println(ArithGeoII_M(ints1));
    }

}