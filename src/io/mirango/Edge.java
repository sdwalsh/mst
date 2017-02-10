package io.mirango;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Edge<T extends Point> implements Comparable<Edge<T>> {
    private Set<Vertex<T>> s = new HashSet<>();
    private double weight;

    public Edge(Vertex<T> a, Vertex<T> b, double weight) {
        this.s.add(a);
        this.s.add(b);
        this.weight = weight;
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

    public Set<Vertex<T>> getVertices() {
        return s;
    }

    public double getWeight() {
        return weight;
    }

    public boolean contains(Vertex<T> a) {
        return s.contains(a);
    }

    public Optional<Vertex<T>> other(Vertex<T> a) {
        return s.stream().filter(b -> b != a).findFirst();
    }
}