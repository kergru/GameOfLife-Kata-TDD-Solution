package com.gameoflife;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class World {

    private final Map<Coordinates, Cell> cellMap;

    private final int rows;

    private final int cols;

    private World(Map<Coordinates, Cell> cellMap, int rows, int cols) {
        this.cellMap = cellMap;
        this.rows = rows;
        this.cols = cols;
    }

    public static World createWorld(boolean[][] board) {
        Map<Coordinates, Cell> cellMap = new LinkedHashMap<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean alive = board[row][col];
                Coordinates coordinates = new Coordinates(row, col);
                Cell cell = new Cell(coordinates, alive);
                cellMap.put(coordinates, cell);
            }
        }
        return new World(cellMap, board.length, board[0].length);
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cellMap.values());
    }

    public World nextGen() {
        Map<Coordinates, Cell> newCellMap = new LinkedHashMap<>();
        for (Cell cell : cellMap.values()) {
            Coordinates coordinates = cell.getCoordinates();
            int countLivingNeighbors = getCountLivingNeighbors(cell);
            boolean alive = GameOfLifeRules.apply(cell, countLivingNeighbors);
            newCellMap.put(coordinates, new Cell(coordinates, alive));
        }
        return new World(newCellMap, this.rows, this.cols);
    }

    private int getCountLivingNeighbors(Cell cell) {
        Coordinates coordinates = cell.getCoordinates();
        List<Coordinates> neighbors = NeighborCalculator.getNeighbors(coordinates, this.rows, this.cols);
        return (int) cellMap.values().stream().filter(c -> c.isAlive() && neighbors.contains(c.getCoordinates())).count();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Cell current = null;
        for (Cell cell : cellMap.values()) {
            if (current != null && current.getCoordinates().getX() != cell.getCoordinates().getX()) {
                sb.append("\n");
            }
            sb.append(cell.isAlive() ? " #" : " .");
            current = cell;
        }
        sb.append("\n");
        return sb.toString();
    }
}
