package io.mirango;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String flag = args[0];
        int numpoints = Integer.parseInt(args[1]);
        int numtrials = Integer.parseInt(args[2]);
        int dimension = Integer.parseInt(args[3]);

        Graph graph;
        switch (dimension) {
            case 1:  graph = new Graph<Point1D>();
                     break;
            case 2:  graph = new Graph<Point2D>();
                     break;
            case 3:  graph = new Graph<Point3D>();
                     break;
            case 4:  graph = new Graph<Point4D>();
                     break;
            default:
        }
    }
}
