package io.mirango;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Number of arguments error");
            System.exit(-1);
        }
        String flag = args[0];
        int numpoints = Integer.parseInt(args[1]);
        int numtrials = Integer.parseInt(args[2]);
        int dimension = Integer.parseInt(args[3]);

        if (dimension < 0 || dimension > 4) {
            System.err.println("Dimension error");
            System.exit(-1);
        }

        Random rand = new Random();
        Graph<Point> graph = new Graph<>();


        // Generate points and add to graph as a vertex
        Point.generatePoints(numpoints, dimension, rand)
                .forEach(graph::addVertex);

        //ListIterator lit = graph.getVertexList().listIterator();

        // Generate edges for each vertex (complete graph)
        graph.getVertexList().forEach(x -> x.addEdges(graph.getVertexList()));

        graph.getVertexList().forEach
                (x -> x.getAdjList().forEach
                        (u -> System.out.println(u.getWeight())));

        int count = 0;
        graph.getVertexList().forEach
                (x -> System.out.println(x.getAdjList().size()));
        System.out.println(graph.getVertexList().size());

    }

}
