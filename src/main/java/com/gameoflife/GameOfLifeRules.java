package com.gameoflife;

public class GameOfLifeRules {

    public static boolean apply(Cell cell, int countLivingNeighbors) {
        if (cell.isAlive() && (countLivingNeighbors < 2 || countLivingNeighbors > 3)) {
            return false;
        } else if (!cell.isAlive() && countLivingNeighbors != 3) {
            return false;
        } else {
            return true;
        }
    }
}
