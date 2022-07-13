package com.example.snakeandladder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BoxGridRecyclerAdapter boxGridRecyclerAdapter;
    BoxGrid boxGrid;
   public Game game;
    TextView  smiley;
    TextView dice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smiley = findViewById(R.id.activity_main_smiley);
        dice = findViewById(R.id.dice);

        recyclerView  =  findViewById(R.id.activity_main_grid);
        recyclerView.setLayoutManager(new GridLayoutManager(this,6));
        game = new Game(6,3,3);
        boxGridRecyclerAdapter = new BoxGridRecyclerAdapter(game.getBoxGrid().getBoxes(), game.getBoxGrid());






        dice.setOnClickListener(new View.OnClickListener() {


            @Override
                                    public void onClick(View view) {
                recyclerView.setAdapter(boxGridRecyclerAdapter);
                         game.getBoxGrid().dice(1,6,game.getBoxGrid().getBoxes());
                System.out.println(game.getBoxGrid().getA());
                         if(game.getBoxGrid().getA() == 36){
                             smiley.setText("CONGRATULATIONS Player A you won");
                         }
                if(game.getBoxGrid().getB() ==  36){
                    smiley.setText("CONGRATULATIONS Player B you won");
                }
            }
                                    });




        System.out.println("lololol");
        int size = 6;
        int laddersPlaced = 0;
        int snakesPlaced = 0;
        System.out.println("lololol");
        while (laddersPlaced <3) {

            int x = new Random().nextInt(size);
            int y = new Random().nextInt(size);


            if (game.getBoxGrid().getBoxes().get(x+(y*6)).getValue() == Box.blank) {
                game.getBoxGrid().getBoxes().set(x + (y * size), new Box(Box.ladder,x + (y * size)));
                laddersPlaced++;
            }
        }

        while (snakesPlaced < 3) {
            int x = new Random().nextInt(size);
            int y = new Random().nextInt(size);

            if (game.getBoxGrid().getBoxes().get(x+(y*6)).getValue() == Box.blank
            && game.getBoxGrid().getBoxes().get(x+(y*6)).getValue() != 36) {
                game.getBoxGrid().getBoxes().set(x + (y * size), new Box(Box.snake,x + (y * size)));

                snakesPlaced++;
            }
        }


    }
}