package com.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NeighborCalculator {

    public static List<Coordinates> getNeighbors(Coordinates coordinates, int rows, int cols) {
        List<Coordinates> neighbors = new ArrayList<>();
        neighbors.add(new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1));
        neighbors.add(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
        neighbors.add(new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1));
        neighbors.add(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        neighbors.add(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        neighbors.add(new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1));
        neighbors.add(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
        neighbors.add(new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1));
        return neighbors.stream().filter(c -> isInsideWorld(c, rows, cols)).collect(Collectors.toList());
    }

    private static boolean isInsideWorld(Coordinates coordinates, int rows, int cols) {
        return coordinates.getX() >= 0 && coordinates.getX() < rows
                && coordinates.getY() >= 0 && coordinates.getY() < cols;
    }
}
