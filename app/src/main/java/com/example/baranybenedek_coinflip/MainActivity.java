package com.example.baranybenedek_coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ImageView coinImage;
    private Button headsButton;
    private Button tailsButton;
    private TextView throwCounter;
    private TextView victoryCounter;
    private TextView loseCounter;
    private int playerInt;
    private int computerInt;
    private int throwCounterx;
    private int victoryCounterx;
    private int loseCounterx;
    private AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Random r=new Random();
        headsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerInt=0;
                throwCounterx++;
                throwCounter.setText("Dobások: "+throwCounterx);
                computerInt=r.nextInt(2);
                if (computerInt==0){
                    coinImage.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this,"Fej!",Toast.LENGTH_SHORT).show();
                    victoryCounterx++;
                    victoryCounter.setText("Győzelem: "+victoryCounterx);
                }
                else{
                    coinImage.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this,"Írás!",Toast.LENGTH_SHORT).show();
                    loseCounterx++;
                    loseCounter.setText("Vereség: "+loseCounterx);
                }
                if (throwCounterx>=5){
                    gameControl();
                }
            }
        });
        tailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerInt=1;
                throwCounterx++;
                throwCounter.setText("Dobások: "+throwCounterx);
                computerInt=r.nextInt(2);
                if (computerInt==0){
                    coinImage.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this,"Fej!",Toast.LENGTH_SHORT).show();
                    loseCounterx++;
                    loseCounter.setText("Vereség: "+loseCounterx);
                }
                else{
                    coinImage.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this,"Írás!",Toast.LENGTH_SHORT).show();
                    victoryCounterx++;
                    victoryCounter.setText("Győzelem: "+victoryCounterx);
                }
                if (throwCounterx>=5){
                    gameControl();
                }
            }
        });
    }
    private void init(){
        linearLayout=findViewById(R.id.linearLayout);
        coinImage=findViewById(R.id.coinImage);
        headsButton=findViewById(R.id.headsButton);
        tailsButton=findViewById(R.id.tailsButton);
        throwCounter=findViewById(R.id.throwCounter);
        victoryCounter=findViewById(R.id.victoryCounter);
        loseCounter=findViewById(R.id.loseCounter);
        alertDialog=new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                })
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }
    private void gameControl(){
        if (victoryCounterx>loseCounterx){
            alertDialog.setTitle("Győzelem").create();
            alertDialog.show();
        }
        else{
            alertDialog.setTitle("Veszteség").create();
            alertDialog.show();
        }
    }
    private void newGame(){
        throwCounterx=0;
        victoryCounterx=0;
        loseCounterx=0;
        coinImage.setImageResource(R.drawable.heads);
        throwCounter.setText("Dobások: "+throwCounterx);
        victoryCounter.setText("Győzelem: "+victoryCounterx);
        loseCounter.setText("Vereség: "+loseCounterx);
    }
}