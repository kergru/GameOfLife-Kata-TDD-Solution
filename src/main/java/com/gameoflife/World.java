package com.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Cell> cells;

    public World(boolean[][] board) {
        cells = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean alive = board[row][col];
                Coordinates coordinates = new Coordinates(row, col);
                Cell cell = new Cell(coordinates, alive);
                cells.add(cell);
            }
        }
    }

    public List<Cell> getCells() {
        return cells;
    }
}
