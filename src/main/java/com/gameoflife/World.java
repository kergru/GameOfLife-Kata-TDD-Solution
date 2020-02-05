package com.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Cell> cells;

    public World(boolean[][] board) {
        cells = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Cell cell = new Cell();
                cells.add(cell);
            }
        }
    }

    public List<Cell> getCells() {
        return cells;
    }
}
