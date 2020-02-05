package com.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    @Test
    void should_create_world() {
        boolean board[][] = new boolean[0][0];

        GameOfLife gol = new GameOfLife(board);
        World world = gol.getWorld();

        assertNotNull(world);
    }
}