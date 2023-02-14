package Coderbyte.Medium;

import java.util.Arrays;

public class ThreePoints_M {

    //    https://www.toppr.com/guides/maths/straight-lines/distance-of-point-from-a-line/
// Collinearity of three points

    public static String ThreePoints_M(String[] strArr) {
        int[] A = Arrays.stream(strArr[0].replaceAll("[^0-9,-]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(strArr[1].replaceAll("[^0-9,-]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int[] C = Arrays.stream(strArr[2].replaceAll("[^0-9,-]", "").split(",")).mapToInt(Integer::parseInt).toArray();


        int result = (B[0] - A[0]) * (C[1] - A[1]) - (B[1] - A[1]) * (C[0] - A[0]);
        return result == 0 ? "neither" : result > 0 ? "left" : "right";
    }


    public static void main(String[] args) {
        String[] strings = {"(0,-3)", "(-2,0)", "(0,0)"};
        System.out.println(ThreePoints_M(strings));

        String[] strings1 = {"(0,0)", "(0,5)", "(0,2)"};
        System.out.println(ThreePoints_M(strings1));

        // incorrect
        String[] strings2 = {"(0,0)", "(0,5)", "(-2,2)"};
        System.out.println(ThreePoints_M(strings2));
    }

}
