package com.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeTest {

    @Test
    void should_create_world() {
        boolean board[][] = new boolean[1][1];

        GameOfLife gol = new GameOfLife(board);
        World world = gol.getWorld();

        assertNotNull(world);
    }

    @Test
    void nextGen_should_create_new_world() {
        boolean board[][] = new boolean[3][3];
        board[0][0] = false;
        board[0][1] = true;
        board[0][2] = false;
        board[1][0] = false;
        board[1][1] = true;
        board[1][2] = false;
        board[2][0] = false;
        board[2][1] = true;
        board[2][2] = false;
        GameOfLife gol = new GameOfLife(board);
        World world = gol.getWorld();

        gol.nextGen();
        World newWorld = gol.getWorld();

        assertWorld(newWorld);
    }

    private void assertWorld(World newWorld) {
        List<Coordinates> coordsOfLivingCells = newWorld.getCells().stream()
                .filter(c -> c.isAlive())
                .map(c -> c.getCoordinates())
                .collect(toList());
        assertTrue(coordsOfLivingCells.size() == 3);
        assertEquals(coordsOfLivingCells.get(0), new Coordinates(1, 0));
        assertEquals(coordsOfLivingCells.get(1), new Coordinates(1, 1));
        assertEquals(coordsOfLivingCells.get(2), new Coordinates(1, 2));
    }
}