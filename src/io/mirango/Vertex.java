package io.mirango;

public class Vertex<T extends Point> {
    private T vertex;

    public Vertex(T vertex) {
        this.vertex = vertex;
    }

    public T getVertex() {
        return vertex;
    }
}
