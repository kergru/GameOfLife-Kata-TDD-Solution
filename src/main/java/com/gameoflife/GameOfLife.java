package com.gameoflife;

public class GameOfLife {

    private World world;

    public GameOfLife(boolean[][] board) {
        world = new World(board);
    };

    public void nextGen() {};

    public World getWorld() {
        return world;
    }
}
