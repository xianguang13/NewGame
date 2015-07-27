package com.example.xianguangyan.newgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by Derek on 7/16/2015.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 1920;
    private MainThread thread;
    private Background bg;
    private Grid grid;
    private ArrayList<Bitmap> images;
    public GamePanel(Context context)
    {
        super(context);

        //add the callback to the surface holder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        //make gamePanel focusable so it can handle events
        setFocusable(true);
        images = new ArrayList<Bitmap>();
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.tile0));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.tile1));


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    public void surfaceDestroyed(SurfaceHolder holder)
    {
        // Attempts to block the thread might require multiple tries
        boolean retry = true;
        int counter = 0;
        while(retry && counter < 1000) {
            try {
                thread.join();
                retry = false;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        bg = new Background();
        grid = new Grid(images);
        //Safely starts the game loop
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            float x = event.getX();
            float y = event.getY();
            System.out.println("X at: " + x*event.getXPrecision() + "Y at: " + y*event.getYPrecision() );
            grid.touchRespond(x, y);
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void update()
    {
        bg.update();
        grid.update();
        thread.update();
    }

    @Override
    public void draw(Canvas canvas)
    {
        //creates a float scale factor
        final float scaleFactorX = getWidth()/(WIDTH * 1.f);
        final float scaleFactorY = getHeight()/(HEIGHT * 1.f);

        if(canvas != null)
        {

            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);
            grid.draw(canvas);
            thread.draw(canvas);
            canvas.restoreToCount(savedState); //prevents scaling loop with a save

        }
    }

}
