package io.mirango;

import java.util.HashMap;
import java.util.stream.Stream;

public class UnionFind {
    private Stream<Vertex<Point>> v;
    private HashMap<Vertex<Point>, Vertex<Point>> parent;
    private HashMap<Vertex<Point>, Integer> rank;

    public UnionFind(Stream<Vertex<Point>> pts) {
        v = pts;
        v.forEach(x -> {
            parent.put(x, x);
            rank.put(x, 1);
        });
    }

    public Vertex<Point> Find(Vertex<Point> a) {
        if (parent.get(a).equals(a)) {
            return a;
        } else {
            return Find(parent.get(a));
        }
    }

    public void Union(Vertex<Point> a, Vertex<Point> b) {
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
