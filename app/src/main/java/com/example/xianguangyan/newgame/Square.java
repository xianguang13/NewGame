package com.example.xianguangyan.newgame;

/**
 * Created by Derek on 7/26/2015.
 */
public class Square {

    public static final int SQUARE_SIZE = 196;
    private Occupant occupant;
    private boolean empty;
    private int row;
    private int col;

    public Square()
    {
        empty = true;
    }
    public Square(Occupant occupant, int row, int col)
    {
        empty = false;
        this.occupant = occupant;
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public boolean empty()
    {
        return empty;
    }
    public Occupant getOccupant()
    {
        return occupant;
    }

    public void setSquare(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
