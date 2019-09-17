package classWork;

import java.util.HashSet;
import java.util.Set;

public class Point {
    private int x;
    private int y;
    public static int b;

    static {
        b = 4;

    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object o) {
        Point that = (Point) o;

        return this.x == that.x && this.y == that.y;
    }

    public int hashCode() {
        return x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Set<Point> points = new HashSet<>();
        Point test = new Point(1, 2);
        for ( int i = 0; i < 10; i++ ) {
            points.add(new Point(1 , i + 2));
        }
        points.add(new Point(1, 2));
        System.out.println(points.toString());
        points.contains(test);
        System.out.println(points.contains(test));

    }
}
