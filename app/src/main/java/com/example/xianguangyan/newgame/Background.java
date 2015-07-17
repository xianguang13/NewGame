package com.example.xianguangyan.newgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Derek on 7/16/2015.
 */
public class Background {
    private Bitmap image0;
    private Bitmap image1;
    private int rows;
    private int cols;
    private int x,y;
    private int size = 216;

    public Background(Bitmap img0, Bitmap img1)
    {
        image0 = img0;
        image1 = img1;
        image0 = image0.createScaledBitmap(image0, 216, 216, false);
        image1 = image1.createScaledBitmap(image1, 216, 216, false);
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
                canvas.drawBitmap(image0, 150 + (col * size), 150 + (row * size), null);
            }
        }

    }
}
