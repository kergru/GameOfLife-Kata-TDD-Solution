package com.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void should_have_living_cell() {
        boolean board[][] = new boolean[1][1];
        board[0][0] = true;

        World world = new World(board);
        List<Cell> cells = world.getCells();

        assertNotNull(cells);
        assertTrue(cells.size() == 1);
        assertTrue(cells.get(0).isAlive());
    }

    @Test
    void should_have_dead_cell() {
        boolean board[][] = new boolean[1][1];
        board[0][0] = false;

        World world = new World(board);
        List<Cell> cells = world.getCells();

        assertNotNull(cells);
        assertTrue(cells.size() == 1);
        assertFalse(cells.get(0).isAlive());
    }
}