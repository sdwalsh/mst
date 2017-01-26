package io.mirango;

public class Edge<T> {
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;

    private Comparable<T> weight;

    public Edge(Vertex<T> a, Vertex<T> b, Comparable<T> w) {
        this.vertex1 = a;
        this.vertex2 = b;
        this.weight = w;
    }

    public Comparable getWeight() {
        return weight;
    }

    public boolean contains(Vertex<T> a) {
        return vertex1.equals(a) || vertex2.equals(a);
    }
}
