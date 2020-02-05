package com.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeRulesTest {

    @Test
    void living_cell_no_living_neighbors_dies() {
        Cell cell = new Cell(new Coordinates(1, 1), true);

        boolean survive = GameOfLifeRules.apply(cell, 0);

        assertFalse(survive);
    }

    @Test
    void living_cell_one_living_neighbors_dies() {
        Cell cell = new Cell(new Coordinates(1, 1), true);

        boolean survive = GameOfLifeRules.apply(cell, 1);

        assertFalse(survive);
    }

    @Test
    void living_cell_two_living_neighbors_survives() {
        Cell cell = new Cell(new Coordinates(1, 1), true);

        boolean survive = GameOfLifeRules.apply(cell, 2);

        assertTrue(survive);
    }

    @Test
    void living_cell_three_living_neighbors_survives() {
        Cell cell = new Cell(new Coordinates(1, 1), true);

        boolean survive = GameOfLifeRules.apply(cell, 3);

        assertTrue(survive);
    }

    @Test
    void living_cell_four_living_neighbors_dies() {
        Cell cell = new Cell(new Coordinates(1, 1), true);

        boolean survive = GameOfLifeRules.apply(cell, 4);

        assertFalse(survive);
    }

    @Test
    void dead_cell_no_living_neighbors_keeps_dead() {
        Cell cell = new Cell(new Coordinates(1, 1), false);

        boolean reborn = GameOfLifeRules.apply(cell, 0);

        assertFalse(reborn);
    }

    @Test
    void dead_cell_two_living_neighbors_keeps_dead() {
        Cell cell = new Cell(new Coordinates(1, 1), false);

        boolean reborn = GameOfLifeRules.apply(cell, 2);

        assertFalse(reborn);
    }

    @Test
    void dead_cell_three_living_neighbors_is_reborn() {
        Cell cell = new Cell(new Coordinates(1, 1), true);

        boolean reborn = GameOfLifeRules.apply(cell, 3);

        assertTrue(reborn);
    }

    @Test
    void dead_cell_four_living_neighbors_is_reborn() {
        Cell cell = new Cell(new Coordinates(1, 1), true);

        boolean reborn = GameOfLifeRules.apply(cell, 3);

        assertTrue(reborn);
    }
}