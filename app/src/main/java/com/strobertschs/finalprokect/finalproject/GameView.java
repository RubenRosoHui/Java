package com.strobertschs.finalprokect.finalproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.lang.Math;

import static android.R.attr.bitmap;
import static android.R.attr.width;
import static android.R.attr.x;
import static android.R.attr.y;
import static com.strobertschs.finalprokect.finalproject.R.attr.height;
import static com.strobertschs.finalprokect.finalproject.R.drawable.cntower2;
import static com.strobertschs.finalprokect.finalproject.R.drawable.pausebutton;

/**
 * Created by Santiago Neymar Jr on 18/06/2017.
 */



class GameView extends SurfaceView implements Runnable{



    private Objects object; // the object; there's only 1, but it can change image and position to appear as many different objects
    private Bitmap tower;
    // the background image
    protected ArrayList<Bitmap> objectImages; // list of object images
    //    private int numObjects;
    //    private Random random;
    int screenWidth, screenHeight; // screen dimensions
    volatile boolean playingGame; // is the game running?
    Thread ourThread = null;
    Canvas canvas;
    SurfaceHolder ourHolder;
    long lastFrameTime;
    int fps; // may not need this if not testing fps
    Paint paint;
    Water water; // the water
    int waterHeight = 100; // starting water height
    int objectSize; // size of objects; this is used to make all object images the same size

    public GameView(Context context, int sScreenWidth, int sScreenHeight){
        super(context);
        ourHolder = getHolder();
        screenWidth = sScreenWidth;
        screenHeight = sScreenHeight;
        paint = new Paint();
        objectSize = Math.min(screenWidth, screenHeight)/5; // size object sizes to 1/5 of smallest dimension

        Resources res = getResources();



        objectImages = new ArrayList<Bitmap>();
        objectImages.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res,
                R.drawable.beer),objectSize, objectSize, false));
        objectImages.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res,
                R.drawable.box),objectSize, objectSize, false));
        objectImages.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res,
                R.drawable.plasticduck),objectSize, objectSize, false));
        objectImages.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res,
                R.drawable.sixpackrings),objectSize, objectSize, false));
        objectImages.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res,
                R.drawable.waterbottlenestle),objectSize, objectSize, false));

        // all object images are stored in this list and scaled to the same size

 /*       objectImages.add(BitmapFactory.decodeResource(res,
                R.drawable.beer));
        objectImages.add(BitmapFactory.decodeResource(res,
                R.drawable.box));
        objectImages.add(BitmapFactory.decodeResource(res,
                R.drawable.plasticduck));
        objectImages.add(BitmapFactory.decodeResource(res,
                R.drawable.sixpackrings));
        objectImages.add(BitmapFactory.decodeResource(res,
                R.drawable.waterbottlenestle));
*/ //       numObjects = objectImages.size();

        tower = BitmapFactory.decodeResource(res, cntower2);

        water = new Water(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res,
                R.drawable.water),screenWidth, waterHeight, false),
                screenHeight, waterHeight);
        // to make the image the same size as the screen, change this to new Water
        //(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.water),screenWidth, screenHeight, false), screenHeight, waterHeight)

        object = new Objects(objectImages, water.getHeight(), screenWidth, screenHeight);


    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // did the user touch the object
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            object.checkTouched((int)motionEvent.getX(), (int)motionEvent.getY());
        }
        return true;
    }

    public void controlFPS() {
        long timeThisFrame = (System.currentTimeMillis() - lastFrameTime);
        long timeToSleep = 100 - timeThisFrame; // adjust 100 to make it faster/slower
        if (timeThisFrame > 0) {
            fps = (int) (1000 / timeThisFrame);
        }
        if (timeToSleep > 0) {
            try {
                ourThread.sleep(timeToSleep);
            } catch (InterruptedException e) {
            }
        }
        lastFrameTime = System.currentTimeMillis();
    }

    public void updateGame(){
        if(object.isTouched()) {
            // if the object was touched, then decrease the water level, move the object, change its image and reset the touched variable
            water.decreaseHitWater();
            object.nextBitmap();
            object.setNewPosition(water.getHeight());
            object.setTouched(false);
        }else{
            // if the object was not touched, increase water level
            water.increaseWater();
        }
    }

    public void drawGame(){
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();
            canvas.drawColor(0, PorterDuff.Mode.CLEAR); // clear the previous canvas before drawing new
            canvas.drawBitmap(tower,(screenWidth - tower.getWidth())/2,0, null);
            paint.setColor(Color.argb(255, 255, 255, 255));
            water.draw(canvas);
            object.draw(canvas);
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run() {
        while (playingGame) {
            updateGame();
            drawGame();
            controlFPS();
        }

    }

    public void pause() {
        playingGame = false;
        try {
            ourThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        playingGame = true;
        ourThread = new Thread(this);
        ourThread.start();
    }
}
