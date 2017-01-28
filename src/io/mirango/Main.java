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

        Point.generatePoints(numpoints, dimension, rand)
                .forEach(graph::addVertex);

        graph.getVertexList().forEach(x -> x.addEdges(graph.getVertexList()));
    }
}
