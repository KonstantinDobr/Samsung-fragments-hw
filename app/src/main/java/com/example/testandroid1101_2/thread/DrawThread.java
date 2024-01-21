package com.example.testandroid1101_2.thread;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.example.testandroid1101_2.R;

public class DrawThread extends Thread {
    private SurfaceHolder holder;
    private boolean working;
    private Context context;
    private Paint paint;
    private float x, y;

    public DrawThread(Context context, SurfaceHolder holder) {
        this.holder = holder;
        this.context = context;
        this.working = true;

        x = 0;
        y = 0;

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
    }

    @Override
    public void run() {
        while (working) {
            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawColor(Color.WHITE);
                    canvas.drawCircle(x, y, 150, paint);
                    x += 5;
                    y += 5;
                } finally {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void requestStop() {
        working = false;
    }
}
