package com.example.snakeandladder;

public class Game {
    private BoxGrid boxGrid;

    public Game(int size,int numberOfLadders, int numberOfSnakes) {
        boxGrid = new BoxGrid(size);

    }

    public BoxGrid getBoxGrid() {
        return boxGrid;
    }
}
