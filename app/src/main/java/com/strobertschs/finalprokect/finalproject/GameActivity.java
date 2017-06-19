package com.strobertschs.finalprokect.finalproject;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;


import static com.strobertschs.finalprokect.finalproject.R.drawable.cntower2;

public class GameActivity extends AppCompatActivity {

    //    Bitmap bitmap;
    Display display;
    int screenWidth, screenHeight;
    Point size;
    GameView waterGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);

//        Resources res = getResources();
//        bitmap = BitmapFactory.decodeResource(res, cntower2);


        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        waterGame = new GameView(this, screenWidth, screenHeight);
        setContentView(waterGame);
    }

    @Override
    protected void onStop() {
        super.onStop();
        while (true) {
            waterGame.pause();
            break;
        }
        finish();
    }


    @Override
    protected void onPause() {
        super.onPause();
        waterGame.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        waterGame.resume();
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            waterGame.pause();
            finish();
            return true;
        }
        return false;
    }

}

