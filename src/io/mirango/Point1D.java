package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Point1D extends Point<Point1D> {
    private int x;

    public Point1D(int x) {
        this.x = x;
    }

    // Cannot define abstract static methods within the interface
    private static Point1D randomNew(Random ints) {
        return new Point1D(ints.nextInt());
    }

    static List<Point1D> generatePoints(int n, Random ints) {
        List<Point1D> points = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            points.add(randomNew(ints));
        }
        return points;
    }

    public int getX() {
        return this.x;
    }

    public double distance(Point1D p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2));
    }
}
