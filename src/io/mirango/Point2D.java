package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Point2D extends Point<Point2D> {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Cannot define abstract static methods within the interface
    private static Point2D randomNew(Random ints) {
        return new Point2D(ints.nextInt(), ints.nextInt());
    }

    static List<Point2D> generatePoints(int n, Random ints) {
        List<Point2D> points = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            points.add(randomNew(ints));
        }
        return points;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double distance(Point2D p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2));
    }
}
