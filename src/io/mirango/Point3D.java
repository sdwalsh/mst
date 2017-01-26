package io.mirango;

public class Point3D extends Point<Point3D> {
    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() { return this.z; }

    public double distance(Point3D p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2) + Math.pow((this.z - p.getZ()), 2));
    }
}
