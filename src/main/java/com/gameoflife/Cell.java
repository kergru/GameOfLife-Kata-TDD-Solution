package com.gameoflife;

import lombok.Value;

@Value
public class Cell {

    private final Coordinates coordinates;

    private final boolean alive;
}
