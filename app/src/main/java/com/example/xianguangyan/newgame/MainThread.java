package com.example.xianguangyan.newgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by Derek on 7/16/2015.
 */
public class MainThread extends Thread {
    private int FPS = 30;
    private double averageFPS;
    private String avgFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;
    private Paint paint = new Paint();

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
        //sets text color
        paint.setColor(Color.BLUE);
        paint.setTextSize(24);

    }

    @Override
    public void run()
    {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000/FPS; //How many milliseconds for a loop

        while(running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    //game loop, updates and draws the canvas
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            }catch (Exception e) {}
            finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            // Time it took to draw and update the game once in milliseconds
            // nano time / 1000000 = milliseconds
            // note that nanotime is a huge number eg. 255073580723571
            timeMillis = (System.nanoTime() - startTime) / 1000000;

            // how long we wait before going to the next loop
            waitTime = targetTime - timeMillis;
            try {
                this.sleep(waitTime);
            } catch (Exception e) {}

            // total time for target FPS game loop (30)
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == FPS) {
                averageFPS = 1000 / ((totalTime / frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }

    public void setRunning(boolean b)
    {
        running = b;
    }

    public void update()
    {
        avgFPS = "" + averageFPS;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawText(avgFPS, 50, 50, paint);
    }


}
