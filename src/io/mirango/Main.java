package io.mirango;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Time logging
        long startTime;
        long endTime;
        long duration;

        List<String> log = new ArrayList<>();
        Path file = Paths.get("max-edge-mst.txt");

        // Grab all arguments quit if too few arguments or arguments are unacceptable
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

        // Number of vertices
        for (int x = 5; x < 3000; x += 25) {
            // Number of trials per vertex #
            System.out.println(x);
            for (int y = 0; y < 10; y++) {
                Random rand = new Random(System.nanoTime());
                Graph<Point> graph = new Graph<>();

                Point.generatePoints(x, 2, rand)
                        .forEach(graph::addVertex);

                graph.addEdges();

                Set<Edge<Point>> s = Kruskal.run(graph);

                Double totalWeight = s.stream().mapToDouble(Edge::getWeight).sum();

                List<Edge<Point>> edgeList = new ArrayList<>();
                edgeList.addAll(s);
                Collections.sort(edgeList);

                // Create comma separated values of x and y
                log.add(x + "," + edgeList.get(edgeList.size() - 1).getWeight());
                System.out.println(edgeList.get(edgeList.size() - 1).getWeight());
            }
        }

        try {
            Files.write(file, log, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.err.println("Error writing to file");
        }
    }
}
