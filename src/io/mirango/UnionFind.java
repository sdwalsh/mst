package io.mirango;

import java.util.HashMap;
import java.util.stream.Stream;

public class UnionFind {
    private HashMap<Vertex<Point>, Vertex<Point>> parent;
    private HashMap<Vertex<Point>, Integer> rank;

    public UnionFind(Stream<Vertex<Point>> pts) {
        pts.forEach(x -> {
            parent.put(x, x);
            rank.put(x, 1);
        });
    }

    public Vertex<Point> find(Vertex<Point> a) {
        if (parent.get(a).equals(a)) {
            return a;
        } else {
            return find(parent.get(a));
        }
    }

    public void union(Vertex<Point> a, Vertex<Point> b) {
        if (rank.get(a) > rank.get(b)) {
            parent.put(b, a);
        } else if (rank.get(b) > rank.get(a)) {
            parent.put(a, b);
        } else {
            parent.put(a, b);
            Integer i = rank.get(b);
            rank.put(b, ++i);
        }

    }

}
