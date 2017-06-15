package com.strobertschs.finalprokect.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.strobertschs.finalprokect.finalproject.R.id.buttonLinks;
import static com.strobertschs.finalprokect.finalproject.R.id.buttonPlay;

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
