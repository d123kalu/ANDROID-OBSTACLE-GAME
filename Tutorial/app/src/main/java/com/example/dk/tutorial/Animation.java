package com.example.dk.tutorial;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by DK on 2017-12-21.
 */

public class Animation {
    private Bitmap[] frames;
    private int frameIndex;

    private boolean isPlaying = false;
    public boolean isPlaying()
    {
        return isPlaying;
    }

    public void play()
    {
        isPlaying = true;
        frameIndex = 0;
        lastframe = System.currentTimeMillis();
    }

    public void stop()
    {
        isPlaying = false;
    }
    private float frameTime;

    private long lastframe;
    public Animation(Bitmap[] frames, float animTime)
    {
        this.frames = frames;
        frameIndex = 0;

        frameTime = animTime/frames.length;

        lastframe = System.currentTimeMillis();
    }

    public void draw(Canvas canvas, Rect destination)
    {
        if(!isPlaying)
            return;

        scaleRect(destination);

        canvas.drawBitmap(frames[frameIndex], null, destination, new Paint());
    }

    private void scaleRect(Rect rect)
    {
        float whRatio = (float)(frames[frameIndex].getWidth())/frames[frameIndex].getHeight();
        if(rect.width() > rect.height())
            rect.left = rect.right - (int)(rect.height()* whRatio);
        else
        rect.top = rect.bottom - (int)(rect.width()* (1/whRatio));
    }

    public void update()
    {
        if(!isPlaying)
        {
            return;
        }
        if(System.currentTimeMillis() - lastframe > frameTime*1000)
        {
            frameIndex++;
            frameIndex = frameIndex >= frames.length ? 0 : frameIndex;
            lastframe = System.currentTimeMillis();
        }
    }
}
