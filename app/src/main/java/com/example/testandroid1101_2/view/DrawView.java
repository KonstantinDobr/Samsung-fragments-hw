package com.example.testandroid1101_2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.testandroid1101_2.thread.DrawThread;

public class DrawView extends SurfaceView implements SurfaceHolder.Callback {

    private Context context;
    private DrawThread drawThread;

    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
        this.context = context;
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        this.context = context;
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        drawThread = new DrawThread(context, surfaceHolder);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int format, int width, int height) {
        //При изменении view
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        drawThread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
}
