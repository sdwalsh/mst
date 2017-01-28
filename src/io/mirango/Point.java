package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Point {
    private int x;
    private int y;
    private int z;
    private int w;

    public Point(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    private static Point randomNew(Random ints, int d) {
        switch (d) {
            case 1:
                return new Point(ints.nextInt(), 0, 0, 0);
            case 2:
                return new Point(ints.nextInt(), ints.nextInt(), 0, 0);
            case 3:
                return new Point(ints.nextInt(), ints.nextInt(), ints.nextInt(), 0);
            case 4:
                return new Point(ints.nextInt(), ints.nextInt(), ints.nextInt(), ints.nextInt());
            default:
                return new Point(0, 0, 0, 0);
        }
    }

    static List<Point> generatePoints(int n, int d, Random ints) {
        List<Point> points = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            points.add(randomNew(ints, d));
        }
        return points;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public int getW() {
        return this.w;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2) + Math.pow((this.z - p.getZ()), 2) + Math.pow((this.w - p.getW()), 2));
    }
}
