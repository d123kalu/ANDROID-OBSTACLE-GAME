package com.example.dk.tutorial;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by DK on 2017-12-21.
 */

public interface Scene {
    public void update();
    public void draw(Canvas canvas);
    public void terminate();

    public void recieveTouch(MotionEvent event);

}
