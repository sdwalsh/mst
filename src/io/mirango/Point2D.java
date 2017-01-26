package io.mirango;

public class Point2D extends Point<Point2D> {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
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
