package io.mirango;

public class Edge<T extends Point> {
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;

    private double weight;

    public Edge(Vertex<T> a, Vertex<T> b) {
        this.vertex1 = a;
        this.vertex2 = b;
        this.weight = a.getVertex().distance(b.getVertex());
    }

    private double getDistance(Point a, Point b) {
        return a.distance(b);
    }

    public Comparable getWeight() {
        return weight;
    }

    public boolean contains(Vertex<T> a) {
        return vertex1.equals(a) || vertex2.equals(a);
    }
}
