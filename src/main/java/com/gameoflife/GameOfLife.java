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

    private void showLifecycle() {
        try {
            for (int i = 0; i < 100; i++) {
                Runtime.getRuntime().exec("clear");
                System.out.println(world);
                Thread.sleep(200);
                nextGen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int size = 20;
        float lifeFactor = 0.25f;
        boolean[][] board = initBoard(size, lifeFactor);

        GameOfLife gol = new GameOfLife(board);
        gol.showLifecycle();
    }

    private static boolean[][] initBoard(int size, float lifeFactor) {
        boolean[][] board = new boolean[size][size];
        int x = 0;
        while (x < board.length) {
            int y = 0;
            while (y < board.length) {
                if (Math.random() < lifeFactor) {
                    board[x][y] = true;
                }
                y++;
            }
            x++;
        }
        return board;
    }
}
