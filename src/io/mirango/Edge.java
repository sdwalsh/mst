package io.mirango;

class Edge<T> {
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;

    // float, point2D, point3D, point4D
    private T weight;

    Edge(Vertex<T> a, Vertex<T> b, T w) {
        this.vertex1 = a;
        this.vertex2 = b;
        this.weight = w;
    }

    boolean contains(Vertex<T> a) {
        return vertex1.equals(a) || vertex2.equals(a);
    }
}
