package io.mirango;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
    private HashMap<Vertex<Point>, Vertex<Point>> parent = new HashMap<>();
    private HashMap<Vertex<Point>, Integer> rank = new HashMap<>();

    public UnionFind(List<Vertex<Point>> v) {
        v.forEach(x -> {
            parent.put(x, x);
            rank.put(x, 1);
        });
    }

    // Use path compression to keep trees small
    public Vertex<Point> find(Vertex<Point> a) {
        if (!parent.get(a).equals(a)) {
            parent.put(a, find(parent.get(a)));
        }
        return parent.get(a);
    }

    public void union(Vertex<Point> a, Vertex<Point> b) {
        Vertex<Point> aRoot = find(a);
        Vertex<Point> bRoot = find(b);

        // if a and b are already in the same set (same root) just return
        if (aRoot.equals(bRoot)) {
            return;
        }

        // if a and b are not in the same set (different root) merge into the larger tree
        if (rank.get(aRoot) < rank.get(bRoot)) {
            parent.put(aRoot, bRoot);
            rank.put(bRoot, rank.get(aRoot) + rank.get(bRoot));
        } else {
            parent.put(bRoot, aRoot);
            rank.put(aRoot, rank.get(bRoot) + rank.get(aRoot));
        }
    }
}
