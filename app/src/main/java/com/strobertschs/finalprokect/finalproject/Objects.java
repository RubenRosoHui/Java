package com.strobertschs.finalprokect.finalproject;

import android.graphics.Canvas;
import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Santiago Neymar Jr on 2017-06-17.
 */

public class Objects{

    private Bitmap bitmap; // an object image
    protected ArrayList<Bitmap> objectImages; // a list of all object images
    private int x, y, screenWidth, screenHeight; // the position of the object and the screen dimensions
    private boolean touched; // was the object touched by the user
    //    private boolean visible;
    private int numObjects; // the number of object images in the objectImages list

    public Objects(ArrayList<Bitmap> objectImages, int waterTop, int screenWidth, int screenHeight){
        this.objectImages = objectImages;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        numObjects = objectImages.size();
        Random random = new Random();
        bitmap = objectImages.get(random.nextInt(numObjects));
        x = bitmap.getWidth() + random.nextInt(screenWidth - 2*bitmap.getWidth());
        y = waterTop - 2*bitmap.getHeight() + random.nextInt(screenHeight - waterTop);
        touched = false;
//        visible = true;
    }
    public Bitmap getBitmap(){
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }
    public void nextBitmap(){
        Random random = new Random();
        setBitmap(objectImages.get(random.nextInt(numObjects)));
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public boolean isTouched(){
        return touched;
    }
    public void setTouched(boolean touched){
        this.touched = touched;
    }
    public void setNewPosition(int waterTop){
        Random random = new Random();
        x = bitmap.getWidth() + random.nextInt(screenWidth - 2*bitmap.getWidth());
        y = waterTop - 2*bitmap.getHeight() + random.nextInt(screenHeight - waterTop);
    }
//    public boolean isVisible(){
    //       return touched;
//    }
    //   public void setVisible(boolean visible){
    //       this.visible = visible;
//    }

    public void draw(Canvas canvas){
        if(!touched) {
            canvas.drawBitmap(bitmap, x, y, null);
        }
    }
    public void checkTouched(int hitX, int hitY){
        //       if(hitX >= (x-bitmap.getWidth()/2) && (hitX <= (x + bitmap.getWidth()/2))){
        //           if(hitY >= (y-bitmap.getHeight()/2) && (hitY <= (y + bitmap.getHeight()/2))){
        if((hitX >= x) && (hitX <= (x + bitmap.getWidth()))){
            if((hitY >= y) && (hitY <= (y + bitmap.getHeight()))){
                setTouched(true);
            }else{
                setTouched(false);
            }
        }else{
            setTouched(false);
        }
    }
}


