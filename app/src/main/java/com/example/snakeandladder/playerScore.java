package com.example.snakeandladder;

public class playerScore {
    public int index;
    public boolean turn;
    public playerScore(int index, boolean turn) {
        this.index = index;
        this.turn = turn;

    }
    public int getIndex() {
        return index;
    }
}