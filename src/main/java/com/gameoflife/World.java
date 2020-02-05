package com.gameoflife;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class World {

    private Map<Coordinates, Cell> cellMap;

    private World(Map<Coordinates, Cell> cellMap) {
        this.cellMap = cellMap;
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
        return new World(cellMap);
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cellMap.values());
    }

    public World nextGen() {
        Map<Coordinates, Cell> newCellMap = new LinkedHashMap<>();
        for (Cell cell : cellMap.values()) {
            Coordinates coordinates = cell.getCoordinates();
            newCellMap.put(coordinates, new Cell(coordinates, cell.isAlive()));
        }
        return new World(newCellMap);
    }
}
