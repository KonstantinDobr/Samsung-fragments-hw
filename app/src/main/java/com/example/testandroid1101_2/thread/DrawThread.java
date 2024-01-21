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
    private float x, y, radius;
    private float x_change, y_change;

    public DrawThread(Context context, SurfaceHolder holder) {
        this.holder = holder;
        this.context = context;
        this.working = true;

        x = 150;
        y = 150;
        radius = 150;
        x_change = 10;
        y_change = 10;

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
                    canvas.drawCircle(x, y, radius, paint);
                    x += x_change;
                    y += y_change;
                    if (x - radius < 0 || x + radius > canvas.getWidth()) {
                        x_change = - x_change;
                    }
                    if (y - radius < 0 || y + radius > canvas.getHeight()) {
                        y_change = - y_change;
                    }
                } finally {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void requestStop() {
        Canvas canvas = holder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        holder.unlockCanvasAndPost(canvas);
        working = false;
    }

}
