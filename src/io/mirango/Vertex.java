package io.mirango;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Vertex<T> {
    private T vertex;
    private List<Edge<T>> adjList = new ArrayList<>();

    Vertex(T vertex) {
        this.vertex = vertex;
    }

    private boolean hasEdge(Vertex<T> v) {
        return adjList.stream()
                .anyMatch(x -> x.contains(v));
    }

    private Optional<Edge<T>> containsEdge(Vertex<T> v) {
        return adjList.stream()
                .filter(x -> x.contains(v))
                .findFirst();
    }

    boolean addEdge(Vertex<T> v, T weight) {
        if (this.hasEdge(v)) {
            return false;
        }
        Edge<T> edge = new Edge<>(this, v, weight);
        adjList.add(edge);
        return true;
    }

    boolean removeEdge(Vertex<T> v) {
        if (!this.hasEdge(v)) {
            return false;
        }
        adjList.remove(this.containsEdge(v));
        return true;
    }
}
