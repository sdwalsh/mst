package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Point4D extends Point<Point4D> {
    private int x;
    private int y;
    private int z;
    private int w;

    public Point4D(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    // Cannot define abstract static methods within the interface
    private static Point4D randomNew(Random ints) {
        return new Point4D(ints.nextInt(), ints.nextInt(), ints.nextInt(), ints.nextInt());
    }

    static List<Point4D> generatePoints(int n, Random ints) {
        List<Point4D> points = new ArrayList<>();

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

    public int getZ() { return this.z; }

    public int getW() { return this.w; }

    public double distance(Point4D p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2) + Math.pow((this.z - p.getZ()), 2) + Math.pow((this.w - p.getW()), 2));
    }
}
