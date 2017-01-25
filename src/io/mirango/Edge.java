package io.mirango;

class Edge<T> {
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;

    private float weight;

    Edge(Vertex<T> a, Vertex<T> b, float w) {
        this.vertex1 = a;
        this.vertex2 = b;
        this.weight = w; // a.distance(b)
    }

    boolean contains(Vertex<T> a) {
        return vertex1 == a || vertex2 == a;
    }
}
