package com.example.xianguangyan.newgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Derek on 7/16/2015.
 */
public class Background {
    private Bitmap image;
    private int rows;
    private int cols;
    private int x,y;
    private int size = 216;

    public Background(Bitmap img)
    {
        image = img.createScaledBitmap(img, 216, 216, false);
        rows = 7;
        cols = 5;
    }

    public void update()
    {

    }

    public void draw(Canvas canvas)
    {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col ++) {
                canvas.drawBitmap(image, 150 + (col * size), 150 + (row * size), null);
            }
        }

    }
}
