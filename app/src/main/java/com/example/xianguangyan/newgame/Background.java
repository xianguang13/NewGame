package com.example.xianguangyan.newgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Derek on 7/16/2015.
 */
public class Background {
    private Bitmap image0;
    private Bitmap image1;
    private int size = 196;
    public static final int xMargin = 50;
    public static final int yMargin = 50;
    private Paint paint;

    public Background()
    {
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
    }

    public void update()
    {

    }

    public void draw(Canvas canvas)
    {
        canvas.drawRect(0,0,1080,1920,paint);
    }
}
