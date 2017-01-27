package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Point3D implements Point<Point3D> {
    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Cannot define abstract static methods within the interface
    static Point<Point3D> randomNew(Random ints) {
        return new Point3D(ints.nextInt(), ints.nextInt(), ints.nextInt());
    }

    static List<Point<Point3D>> generatePoints(int n, Random ints) {
        List<Point<Point3D>> points = new ArrayList<>();

        for (int x = 0; x <= n; x++) {
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

    @Override
    public double distance(Point3D p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2) + Math.pow((this.z - p.getZ()), 2));
    }
}
