package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleArea_M {

    public static int RectangleArea_5(String[] strArr) {
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].replaceAll("\\(", "").replaceAll("\\)", "");
            String[] split = strArr[i].split("\\s");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            listX.add(x);
            listY.add(y);
        }

        int minX = Collections.min(listX);
        int maxX = Collections.max(listX);

        int minY = Collections.min(listY);
        int maxY = Collections.max(listY);

        int width = maxX - minX;
        int height = maxY - minY;

        return width * height;
    }

    public static void main(String[] args) {
        String[] strings = {"(1 1)", "(1 3)", "(3 1)", "(3 3)"};
        System.out.println(RectangleArea_5(strings));
    }

}