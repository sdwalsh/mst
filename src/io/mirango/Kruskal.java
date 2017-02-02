package io.mirango;

import java.util.*;

public class Kruskal {
    public static Set<Edge<Point>> run(Graph<Point> graph) {
        Set<Edge<Point>> s = new HashSet<>();
        List<Edge<Point>> edgeList = new ArrayList<>();
        UnionFind u = new UnionFind(graph.getVertexList());

        edgeList.addAll(graph.getEdgeSet());
        Collections.sort(edgeList);

        edgeList.forEach(x -> {
            Iterator<Vertex<Point>> v = x.getVertices().iterator();
            Vertex<Point> v1 = v.next();
            Vertex<Point> v2 = v.next();
            if (!(u.find(v1).equals(u.find(v2)))) {
                s.add(x);
                u.union(v1, v2);
            }
        });
        return s;
    }
}
