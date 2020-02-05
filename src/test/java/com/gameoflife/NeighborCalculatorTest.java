package com.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gameoflife.NeighborCalculator.getNeighbors;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NeighborCalculatorTest {

    private boolean[][] board;

    @BeforeEach
    void setup() {
        board = new boolean[3][3];
        board[0][0] = false;
        board[0][1] = false;
        board[0][2] = false;
        board[1][0] = false;
        board[1][1] = false;
        board[1][2] = false;
        board[2][0] = false;
        board[2][1] = false;
        board[2][2] = false;
    }

    @Test
    void neighbors_for_upper_left_cell() {

        List<Coordinates> neighbors = getNeighbors(new Coordinates(0, 0), 3, 3);

        assertNotNull(neighbors);
        assertTrue(neighbors.size() == 3);
    }

    @Test
    void neighbors_for_lower_right_cell() {

        List<Coordinates> neighbors = getNeighbors(new Coordinates(2, 2), 3, 3);

        assertNotNull(neighbors);
        assertTrue(neighbors.size() == 3);
    }

    @Test
    void neighbors_for_center() {
        List<Coordinates> neighbors = getNeighbors(new Coordinates(1, 1), 3, 3);

        assertNotNull(neighbors);
        assertTrue(neighbors.size() == 8);
    }

    @Test
    void neighbors_for_middle_left_cell() {

        List<Coordinates> neighbors = getNeighbors(new Coordinates(1, 0), 3, 3);

        assertNotNull(neighbors);
        assertTrue(neighbors.size() == 5);
    }

    @Test
    void neighbors_for_middle_right_cell() {

        List<Coordinates> neighbors = getNeighbors(new Coordinates(1, 2), 3, 3);

        assertNotNull(neighbors);
        assertTrue(neighbors.size() == 5);
    }
}