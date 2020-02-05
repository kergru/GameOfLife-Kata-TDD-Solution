package com.gameoflife;

public class GameOfLife {

    private World world;

    public GameOfLife(boolean[][] board) {
        world = World.createWorld(board);
    }

    public void nextGen() {
        world = world.nextGen();
    }

    public World getWorld() {
        return world;
    }
}
