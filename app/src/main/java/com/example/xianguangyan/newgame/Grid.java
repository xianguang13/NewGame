package com.example.xianguangyan.newgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Derek on 7/26/2015.
 */
public class Grid {

    private Square[][] squares; //2D array of all squares on the grid
    private Bitmap tile0;
    private Bitmap tileSelected;
    private static int rows = 7;
    private static int cols = 5;
    private static int size = 196;
    private float touchX;
    private float touchY;


    public Grid(ArrayList<Bitmap> images)
    {
        tile0 = images.get(0);
        tileSelected = images.get(1);

        tile0 = tile0.createScaledBitmap(tile0, size, size, false);
        tileSelected = tileSelected.createScaledBitmap(tileSelected, size, size, false);
        //setGrid();
    }

    private void setGrid()
    {
        squares = new Square[rows][cols];

        // fill grid with empty squares
        for( int row = 0; row < rows; row++)
        {
            for( int col = 0; col < cols; cols++)
            {
                squares[row][col] = new Square();
            }
        }
    }

    public void touchRespond(float x, float y)
    {
        touchX = x;
        touchY = y;
    }

    private int findSquareX()
    {
        float factor = size/6;
        int gridX = (int)((touchX - (Background.xMargin + factor))/size);
        if(gridX >= cols) gridX = cols - 1;
        return gridX;
    }

    private int findSquareY()
    {
        float factor = size/6;
        int gridY = (int)((touchY - (Background.yMargin + factor))/size);
        return gridY;
    }

    public void update()
    {

    }

    public void draw(Canvas canvas)
    {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col ++) {
                if(findSquareX() == col && findSquareY() == row)
                {
                    canvas.drawBitmap(tileSelected, Background.xMargin + (col * size), Background.yMargin + (row * size), null);
                }
                else {
                    canvas.drawBitmap(tile0, Background.xMargin + (col * size), Background.yMargin + (row * size), null);
                }
            }
        }

    }

}
