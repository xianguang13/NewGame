package com.example.xianguangyan.newgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Derek on 7/16/2015.
 */
public class Background {
    private Bitmap image;
    private int x,y;

    public Background(Bitmap img)
    {
        image = img;
    }

    public void update()
    {

    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);
    }
}
