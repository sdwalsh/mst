package io.mirango;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String flag = args[0];
        int numpoints = Integer.parseInt(args[1]);
        int numtrials = Integer.parseInt(args[2]);
        int dimension = Integer.parseInt(args[3]);

        Random rand = new Random();

        ListIterator lit;

        switch (dimension) {
            case 1:
                Graph<Point1D> g1 = new Graph<>();
                Point1D.generatePoints(numpoints, rand)
                        .forEach(g1::addVertex);
                lit = g1.getVertexList().listIterator();
                break;

            case 2:
                Graph<Point2D> g2 = new Graph<>();
                Point2D.generatePoints(numpoints, rand)
                        .forEach(g2::addVertex);
                lit = g2.getVertexList().listIterator();
                break;

            case 3:
                Graph<Point3D> g3 = new Graph<>();
                Point3D.generatePoints(numpoints, rand)
                        .forEach(g3::addVertex);
                lit = g3.getVertexList().listIterator();
                break;

            case 4:
                Graph<Point4D> g4 = new Graph<>();
                Point4D.generatePoints(numpoints, rand)
                        .forEach(g4::addVertex);
                lit = g4.getVertexList().listIterator();
                break;
        }
    }

}
