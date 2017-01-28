package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Point {
    private double x;
    private double y;
    private double z;
    private double w;

    public Point(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    private static Point randomNew(Random rand, int d) {
        switch (d) {
            case 1:
                return new Point(rand.nextDouble(), 0.0, 0.0, 0.0);
            case 2:
                return new Point(rand.nextDouble(), rand.nextDouble(), 0.0, 0.0);
            case 3:
                return new Point(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), 0.0);
            case 4:
                return new Point(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
            default:
                return new Point(0.0, 0.0, 0.0, 0.0);
        }
    }

    public static List<Point> generatePoints(int n, int d, Random rand) {
        List<Point> points = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            points.add(randomNew(rand, d));
        }
        return points;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getW() {
        return this.w;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2) + Math.pow((this.z - p.getZ()), 2) + Math.pow((this.w - p.getW()), 2));
    }
}
