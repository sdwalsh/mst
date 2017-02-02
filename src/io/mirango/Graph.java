package io.mirango;

import java.util.*;

public class Graph<T extends Point> {
    private List<Vertex<T>> vertexList;
    private Set<Edge<T>> s = new HashSet<>();

    public Graph() {
        this.vertexList = new ArrayList<>();
    }

    public boolean addVertex(T type) {
        Vertex<T> v = new Vertex<>(type);
        vertexList.add(v);
        return true;
    }

    public boolean hasEdge(Vertex<T> a, Vertex<T> b) {
        return s.stream().anyMatch(x -> (x.contains(a) && x.contains(b)));
    }

    public boolean addEdge(Vertex<T> a, Vertex<T> b) {
        Optional<Edge<T>> z = s.stream().filter(x -> (x.contains(a) && x.contains(b))).findFirst();
        if (z.isPresent()) {
            return false;
        }
        Edge<T> edge = new Edge<>(a, b);
        s.add(edge);
        return true;
    }

    public void addEdges() {
        vertexList.forEach(x -> {
            vertexList.forEach(y -> {
                if (!x.equals(y)) {
                    addEdge(x, y);
                }
            });
        });
    }

    public List<Vertex<T>> getAdjList(Vertex<T> a) {
        List<Vertex<T>> v = new ArrayList<>();
        s.iterator().forEachRemaining(x -> {
            Optional<Vertex<T>> ov = x.other(a);
            ov.ifPresent(v::add);
        });
        return v;
    }

    public Set<Edge<T>> getEdgeSet() {
        return s;
    }

    public List<Vertex<T>> getVertexList() {
        return vertexList;
    }
}
