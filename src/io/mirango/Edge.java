package io.mirango;

import org.jetbrains.annotations.NotNull;

public class Edge<T extends Point> implements Comparable<Edge<T>> {
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private double weight;

    public Edge(Vertex<T> a, Vertex<T> b) {
        this.vertex1 = a;
        this.vertex2 = b;
        this.weight = getDistance(a.getVertex(), b.getVertex());
    }

    private double getDistance(Point a, Point b) {
        return a.distance(b);
    }

    public int compareTo(@NotNull Edge e) {
        if (this.getWeight() > e.getWeight()) {
            return 1;
        } else if (this.getWeight() < e.getWeight()) {
            return -1;
        } else {
            return 0;
        }
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public double getWeight() {
        return weight;
    }

    public boolean contains(Vertex<T> a) {
        return vertex1.equals(a) || vertex2.equals(a);
    }
}
