package Coderbyte.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestEnemyII_M {


    public static int ClosestEnemyII_M(String[] strArr) {
        int boardLength = strArr[0].length();

        int onePositionX = 0;
        int onePositionY = 0;

        List<Point> enemies = new ArrayList<Point>();

        for (int i = 0; i < strArr.length; i++) {

            for (int j = 0; j < strArr[0].length(); j++) {
                if (strArr[i].charAt(j) == '1') {
                    onePositionX = j;
                    onePositionY = i;
                }
            }
        }

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[0].length(); j++) {
                if (strArr[i].charAt(j) == '2') {
                    enemies.add(new Point(j, i));
                }
            }
        }

        if (enemies.isEmpty()) {
            return 0;
        }

        List<Integer> distances = new ArrayList<>();

        for (Point e : enemies) {
            int enemyX = e.getX();
            int enemyY = e.getY();

            int xDistance = Math.abs((onePositionX - enemyX));
            int xDistanceWrapped = Math.abs(boardLength - xDistance);

            int yDistance = Math.abs((onePositionY - enemyY));
            int yDistanceWrapped = Math.abs(boardLength - yDistance);

            int distance = Math.min(xDistance, xDistanceWrapped) + Math.min(yDistance, yDistanceWrapped);

            distances.add(distance);
        }

        Collections.sort(distances);

        return distances.get(0);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[] strings = {"000", "100", "200"};
        System.out.println(ClosestEnemyII_M(strings));

        String[] strings1 = {"0000", "2010", "0000", "2002"};
        System.out.println(ClosestEnemyII_M(strings1));

        String[] strings2 = {"0000", "1000", "0002", "0002"};
        System.out.println(ClosestEnemyII_M(strings2));

        String[] strings3 = {"01000", "00020", "00000", "00002", "02002"};
        System.out.println(ClosestEnemyII_M(strings3));

        // incorrect cases
        String[] strings4 = {"01000", "00000", "00000", "00000", "00000"};
        System.out.println(ClosestEnemyII_M(strings4));
    }

}