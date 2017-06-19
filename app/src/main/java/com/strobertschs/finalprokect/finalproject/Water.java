package com.strobertschs.finalprokect.finalproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by Santiago Neymar Jr on 2017-06-17.
 */

public class Water{

    private Bitmap bitmap; // the water image

    private int screenHeight; // used to calculate actual waterHeight
    private int waterHeight; // waterHeight is reversed, since top of screen is y=0
    private int waterIncreaseRate = 10; // how fast the water rises
    private int waterDecreaseHitRate = 50; // how much the water lowers if user clicks objects
    private int minWaterLevel = 10; // this ensures objects will always be on screen

    public Water(Bitmap bitmap, int screenHeight, int height) {
        this.bitmap = bitmap;

        //this.screenHeight = screenHeight - height;
        //this.waterHeight = screenHeight;
        this.screenHeight = screenHeight;
        this.waterHeight = screenHeight - height;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getHeight() {
        return waterHeight;
    }

    public void setHeight(int height) {
        this.waterHeight = screenHeight - height;
        //this.waterHeight = height;
    }

    public void increaseWater() {
        waterHeight -= waterIncreaseRate;
        if (waterHeight < minWaterLevel) {
            waterHeight = minWaterLevel;
        }
    }

    public void decreaseHitWater() {
        waterHeight += waterDecreaseHitRate;
        if (waterHeight > screenHeight - minWaterLevel) {
            waterHeight = screenHeight - minWaterLevel;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, waterHeight, null);
    }
}