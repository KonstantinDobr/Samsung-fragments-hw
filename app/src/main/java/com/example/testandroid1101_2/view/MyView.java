package com.example.testandroid1101_2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testandroid1101_2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyView extends View {

    private Paint paint;
    private float x, y;
    private Path path;
    private Map<Path, Paint> pathMap;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        x = 150;
        y = 150;

        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.red));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6);

        path = new Path();
        path.setLastPoint(0, 0);
        pathMap = new HashMap<>();
        pathMap.put(path, paint);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {

        canvas.drawColor(getResources().getColor(R.color.my_color));

        for (Map.Entry<Path, Paint> entry : pathMap.entrySet()) {
            canvas.drawPath(entry.getKey(), entry.getValue());
        }

        canvas.drawCircle(x, y, 50, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        x = event.getX();
        y = event.getY();

        path.lineTo(x, y);

        invalidate();

        return true;
    }

    public void setPaintColor(int color) {

        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6);

        path = new Path();
        path.setLastPoint(x, y);
        pathMap.put(path, paint);
    }

    public void cancelLastPath() {
        pathMap.remove(path);
        invalidate();
    }
}
