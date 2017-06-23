package com.strobertschs.finalprokect.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.strobertschs.finalprokect.finalproject.R.id.buttonLinks;
import static com.strobertschs.finalprokect.finalproject.R.id.buttonPlay;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializes the buttons
        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        Button buttonLinks = (Button)findViewById(R.id.buttonLinks);
        buttonLinks.setOnClickListener(this);
        Button buttonQuit = (Button)findViewById(R.id.buttonQuit);
        buttonQuit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){

        switch (view.getId()) {
            // if start is pressed, the game page is opened
            case R.id.buttonPlay:
                Intent i;
                i = new Intent(this, GameActivity.class);
                startActivity(i);
                Log.i("info", "The user entered the game");
                break;

            // if links is pressed, links page opens

            case R.id.buttonLinks:
                Intent j;
                j = new Intent(this, LinkActivity.class);
                startActivity(j);
                Log.i("info", "The user entered the links page");
                break;

                // if Quit is pressed, the game closes
            case R.id.buttonQuit:
                finish();
                System.exit(0);
                Log.i("info", "The user exited the game");
                break;

        }
    }
}

/*
public class MainActivity extends AppCompatActivity  {


     public Button buttonToPlay;
     public Button buttonForLinks;

     public void PlayButton(){
         buttonToPlay = (Button) findViewById(buttonPlay);

         buttonToPlay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent toy;
                 toy = new Intent(MainActivity.this, com.strobertschs.finalprokect.finalproject.GameActivity.class);
                 startActivity(toy);
                 Log.i("info", "The user entered the game");
             }
         });
     }
     public void LinkButton() {
         buttonForLinks = (Button) findViewById(buttonLinks);

         buttonForLinks.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i;
                 i = new Intent(MainActivity.this, LinkActivity.class);
                 startActivity(i);
                 Log.i("info", "The user opened the links page");
             }
         });
     }
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         PlayButton();
         LinkButton();
     }
 }
 */