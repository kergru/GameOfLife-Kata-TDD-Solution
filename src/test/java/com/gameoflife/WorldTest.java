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

    @Test
    void cells_should_have_coordinates() {
        boolean board[][] = new boolean[2][2];
        board[0][0] = false;
        board[1][0] = false;
        board[0][1] = false;
        board[1][1] = false;

        World world = new World(board);
        List<Cell> cells = world.getCells();

        assertNotNull(cells);
        assertTrue(cells.size() == 4);
        assertEquals(cells.get(0).getCoordinates(), new Coordinates(0,0));
        assertEquals(cells.get(1).getCoordinates(), new Coordinates(0,1));
        assertEquals(cells.get(2).getCoordinates(), new Coordinates(1,0));
        assertEquals(cells.get(3).getCoordinates(), new Coordinates(1,1));
    }
}