package io.mirango;

import java.util.ArrayList;
import java.util.List;

public class Graph<T extends Point> {
    private List<Vertex<T>> vertexList;

    public Graph() {
        this.vertexList = new ArrayList<>();
    }

    public boolean addVertex(T type) {
        Vertex<T> v = new Vertex<>(type);
        vertexList.add(v);
        return true;
    }

    public List<Vertex<T>> getVertexList() {
        return vertexList;
    }
}
