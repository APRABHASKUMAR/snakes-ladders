package com.example.snakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BoxGrid {
   public static playerScore A = new playerScore(1, true);
  public static playerScore B = new playerScore(1, false);
    public List<Box> boxes1;
    private int size;



public BoxGrid(int size) {
    this.size = size;
    boxes1 = new ArrayList<>();
    for (int i = 0; i < size*size ; i++) {
        boxes1.add(new Box(Box.blank,i));

    }
}

public int toIndex (int x,int y) {
    return x + (y*size);
    }
    public int toX (int index) {

   int y = index/size;
        int x = index - (y*size);
        return x;
    }

    public int toY (int index) {

        int y = index/size;

        return y;
    }



    public List<Box> getBoxes() {
        return boxes1;
    }
    public int dice(int min, int max,List<Box> boxes) {
        int count = (int)(Math.random()*(max - min) + min);
        if(A.turn)
        {   if ((A.index + count) <= 36){
            A.index = A.index + count;}

            searchladderA(A.index,boxes);
            searchSnakeA(A.index,boxes);

            boolean temp = A.turn;
            A.turn = B.turn;
            B.turn = temp;
            return A.index;
        }
        else if(( B.index + count) <=36){
            B.index = B.index + count;
        }

        searchladderB(B.index,boxes);
        searchSnakeB(B.index,boxes);

        boolean temp = A.turn;
        A.turn = B.turn;
        B.turn = temp;
        return B.index;
    }
     public void searchladderA(int move,List<Box> boxes) {


         if (boxes.get(36-move).getValue() == 1) {

                 for (int i = move+1; i < 36; i++) {
                     System.out.println(i);
                     if (boxes.get(36-i).getValue() == Box.ladder) {
                         A.index = i;
                                break;
                     }

                 }

         }
     }
    public void searchladderB(int move,List<Box> boxes) {
        // System.out.println(boxes.get(36-(toX(move)+(toY(move)*6))).getValue());

        if (boxes.get(36-move).getValue() == 1) {

            for (int i = move+1; i < 36; i++) {

                if (boxes.get(36-i).getValue() == Box.ladder) {
                    B.index = i;
                    break;
                }

            }

        }
    }
    public void searchSnakeA(int move,List<Box> boxes) {

        if (boxes.get(36-move).getValue() == Box.snake) {

                for (int i = move-1; i > 0; i--) {

                    if (boxes.get(36-i).getValue() == Box.snake) {

                        A.index = i;
                        break;
                    }

                }

        }
    }
    public void searchSnakeB(int move,List<Box> boxes) {

        if (boxes.get(36-move).getValue() == Box.snake) {

            for (int i = move-1; i > 0; i--) {
                System.out.println(i);
                if (boxes.get(36-i).getValue() == Box.snake) {

                    B.index = i;
                    break;
                }

            }

        }
    }
    public int getA() {
        return A.index;
    }
    public int getB() {
        return B.index;
    }

}
