package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OverlappingRectangles_M {

    public static int OverlappingRectangles_M(String[] strArr) {

        List<Point> points1 = new ArrayList<Point>();
        List<Point> points2 = new ArrayList<Point>();


        Matcher m = Pattern.compile("\\(-?\\d{1,2},-?\\d{1,2}\\)").matcher(strArr[0]);

        int i = 0;
        while (i < 4 && m.find()) {
            String[] split = m.group().replaceAll("(\\(|\\))", "").split(",");
            points1.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            i++;
        }

        while (i < 8 && m.find()) {
            String[] split = m.group().replaceAll("(\\(|\\))", "").split(",");
            points2.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            i++;
        }

        Rectangle rectangle = new Rectangle(points1);
        rectangle.calcExtremes();

        Rectangle rectangle2 = new Rectangle(points2);
        rectangle2.calcExtremes();

        return rectangle.getOverlap(rectangle2);
    }

    public static class Rectangle {
        List<Point> points = new ArrayList<Point>();

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        int height = 0;
        int base = 0;

        int area = 0;

        public Rectangle(List<Point> points) {
            this.points = points;
        }

        public void calcExtremes() {
            minX = this.points.stream().min(Comparator.comparing(Point::getX)).get().getX();

            maxX = this.points.stream().max(Comparator.comparing(Point::getX)).get().getX();

            minY = this.points.stream().min(Comparator.comparing(Point::getY)).get().getY();

            maxY = this.points.stream().max(Comparator.comparing(Point::getY)).get().getY();

            this.setBase();
            this.setHeight();
            this.calcArea();
        }

        public void calcArea() {
            this.area = base * height;
        }

        public int getArea() {
            return area;
        }

        public List<Point> getPoints() {
            return points;
        }

        public void setPoints(List<Point> points) {
            this.points = points;
        }

        public int getMinX() {
            return minX;
        }

        public void setMinX(int minX) {
            this.minX = minX;
        }

        public int getMaxX() {
            return maxX;
        }

        public void setMaxX(int maxX) {
            this.maxX = maxX;
        }

        public int getMinY() {
            return minY;
        }

        public void setMinY(int minY) {
            this.minY = minY;
        }

        public int getMaxY() {
            return maxY;
        }

        public void setMaxY(int maxY) {
            this.maxY = maxY;
        }

        public int getHeight() {
            return maxY - minY;
        }

        public void setHeight() {
            this.height = maxY - minY;
        }

        public int getBase() {
            return maxX - minX;
        }

        public void setBase() {
            this.base = maxX - minX;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "points=" + points +
                    '}';
        }

        // toDo make it differ
        public int getOverlap(Rectangle rectangle2) {
            int width = Math.min(this.getMaxX(), rectangle2.getMaxX()) - Math.max(this.getMinX(), rectangle2.getMinX());
            width = Math.max(0, width);
            int height = Math.min(this.getMaxY(), rectangle2.getMaxY()) - Math.max(this.getMinY(), rectangle2.getMinY());
            height = Math.max(0, height);
            int area = width * height;
            return area == 0 ? 0 : this.getArea() / area;
        }

    }

    public static class Point {
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
        String[] strings = {"(0,0),(0,-2),(3,0),(3,-2),(2,-1),(3,-1),(2,3),(3,3)"};
        System.out.println(OverlappingRectangles_M(strings));

        String[] strings1 = {"(0,0),(5,0),(0,2),(5,2),(2,1),(5,1),(2,-1),(5,-1)"};
        System.out.println(OverlappingRectangles_M(strings1));
    }

}
