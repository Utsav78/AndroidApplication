package com.example.tttgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{2,5,8},{0,4,8},{2,4,6},{1,4,7},{0,3,6}};
    int[] gameState={3,3,3,3,3,3,3,3,3};
    int activePlayer=1;
    boolean gameActive=true;


    public void playerTap(View view){
        ImageView img=(ImageView)view;
        int tappedImage=Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==3){
            gameState[tappedImage]=activePlayer;
            if(activePlayer==1){
                img.setImageResource(R.drawable.x);
                activePlayer=2;
                TextView status=(TextView)findViewById(R.id.status);
                status.setText("O's turn tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer=1;
                TextView status=(TextView)findViewById(R.id.status);
                status.setText("X's turn tap to play");
            }
        }
        //check if any player has won;
        for(int[] winPosition:winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]] &&
                    gameState[winPosition[1]]==gameState[winPosition[2]]
            && gameState[winPosition[0]]!=3){
                String winnerBro;
                gameActive=false;

                if(gameState[winPosition[0]]==1){
                    winnerBro="X has Won";
                }
                else{
                    winnerBro="O's has Won";
                }
                TextView status=(TextView)findViewById(R.id.status);
                status.setText(winnerBro);
            }
        }
    }
    public void gameReset(View view){
        gameActive=true;
        activePlayer=1;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=3;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
