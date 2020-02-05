package com.gameoflife;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class World {

    private Map<Coordinates, Cell> cellMap;

    public World(boolean[][] board) {
        cellMap = new LinkedHashMap<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean alive = board[row][col];
                Coordinates coordinates = new Coordinates(row, col);
                Cell cell = new Cell(coordinates, alive);
                cellMap.put(coordinates, cell);
            }
        }
    }

    public World(Map<Coordinates, Cell> cellMap) {
        this.cellMap = cellMap;
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cellMap.values());
    }

    public World nextGen() {
        return new World(cellMap);
    }
}
