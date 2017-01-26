package io.mirango;

public abstract class Point<T>{

    public double weight(T p) {
        return this.distance(p);
    }
    public abstract double distance(T p);

}
