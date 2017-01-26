package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vertex<T> {
    private T vertex;
    private List<Edge<T>> adjList = new ArrayList<>();

    Vertex(T vertex) {
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

    public boolean addEdge(Vertex<T> v, Comparable<T> weight) {
        if (this.hasEdge(v)) {
            return false;
        }
        Edge<T> edge = new Edge<>(this, v, weight);
        adjList.add(edge);
        return true;
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
