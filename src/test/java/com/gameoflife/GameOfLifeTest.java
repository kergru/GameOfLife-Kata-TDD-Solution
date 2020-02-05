package com.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeTest {

    @Test
    void should_create_world() {
        boolean board[][] = new boolean[0][0];

        GameOfLife gol = new GameOfLife(board);
        World world = gol.getWorld();

        assertNotNull(world);
    }

    @Test
    void nextGen_should_create_new_world() {
        boolean board[][] = new boolean[0][0];
        GameOfLife gol = new GameOfLife(board);
        World world = gol.getWorld();

        gol.nextGen();
        World newWorld = gol.getWorld();

        assertNotNull(world);
        assertNotNull(newWorld);
        assertNotEquals(world, newWorld);
        assertTrue(world.getCells().size() == newWorld.getCells().size());
    }
}