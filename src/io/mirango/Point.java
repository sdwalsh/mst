package io.mirango;

import java.util.ArrayList;
import java.util.List;

public interface Point<T>{

    default double weight(T p) {
        return this.distance(p);
    }

    double distance(T p);

}
