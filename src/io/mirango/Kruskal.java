package io.mirango;

import java.util.*;

public class Kruskal {
    public static Set<Edge<Point>> run(Graph<Point> graph) {
        Set<Edge<Point>> s = new HashSet<>();
        List<Edge<Point>> edgeList = new ArrayList<>();
        UnionFind u = new UnionFind(graph.getVertexList().stream());

        graph.getVertexList().forEach(x -> {
            edgeList.addAll(x.getAdjList());

        });
        Collections.sort(edgeList);

        edgeList.forEach(x -> {
            if (u.find(x.getVertex1()).equals(x.getVertex2())) {
                s.add(x);
                u.union(x.getVertex1(), x.getVertex2());
            }
        });
        return s;
    }
}
