package io.mirango;

import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Time logging
        long startTime;
        long endTime;
        long duration;

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

        System.out.println("Begin Generation of Points");
        startTime = System.nanoTime();
        Point.generatePoints(numpoints, dimension, rand)
                .forEach(graph::addVertex);
        endTime = System.nanoTime();
        System.out.println("End Generation of Points");
        duration = endTime - startTime;
        System.out.print(duration / 1000000);
        System.out.println("ms");

        System.out.println("Add Edges");
        startTime = System.nanoTime();
        graph.addEdges();
        endTime = System.nanoTime();
        System.out.println("Finished Adding Edges");
        duration = endTime - startTime;
        System.out.print(duration / 1000000);
        System.out.println("ms");

        System.out.println(graph.getVertexList().size());

        System.out.println("Run Kruskal to find MST");
        startTime = System.nanoTime();
        Set<Edge<Point>> s = Kruskal.run(graph);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.print(duration / 1000000);
        System.out.println("ms");
        System.out.println();
        System.out.println(s.size());

        Double totalWeight = s.stream().mapToDouble(Edge::getWeight).sum();
        System.out.println(totalWeight);

        //List<Double> weights = new ArrayList<>();
        //s.forEach(x -> weights.add(x.getWeight()));
    }
}
