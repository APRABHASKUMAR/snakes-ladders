package com.example.snakeandladder;

public class Box {
    public static final int ladder = 1;
    public static final int snake = -1;
    public static final int blank = 0;

    private int value;
    private int i;


    public Box(int value, int i) {
        this.value = value;
        this.i = i;
    }

    public int getValue() {
        return value;
    }
    public int geti() {
        return 36-i;
    }
}
