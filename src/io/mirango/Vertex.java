package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vertex<T extends Point> {
    private T vertex;
    private List<Edge<T>> adjList = new ArrayList<Edge<T>>();

    public T getVertex() {
        return vertex;
    }

    public Vertex(T vertex) {
        this.vertex = vertex;
    }

    public boolean hasEdge(Vertex<T> v) {
        return adjList.stream()
                .anyMatch(x -> x.contains(v));
    }

    public Optional<Edge<T>> edge(Vertex<T> v) {
        return adjList.stream()
                .filter(x -> x.contains(v))
                .findFirst();
    }

    public boolean addEdge(Vertex<T> v) {
        if (this.hasEdge(v)) {
            return false;
        }
        Edge<T> edge = new Edge<>(this, v);
        adjList.add(edge);
        return true;
    }

    public List<Edge<T>> getAdjList() {
        return adjList;
    }

    public boolean removeEdge(Vertex<T> v) {
        Optional<Edge<T>> e = this.edge(v);
        if (!e.isPresent()) {
            return false;
        }
        adjList.remove(e.get());
        return true;
    }
}
