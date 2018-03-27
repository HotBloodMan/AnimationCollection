package com.ljt.animalcollection.solo.object;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by ${JT.L} on 2018/3/26.
 */

public class MyPoint extends View{

    private Point mPoint=new Point(100);

    public MyPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mPoint !=null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mPoint.getRadius(),paint);
        }
        super.onDraw(canvas);
    }

    public int getPointRadius(){
        return 5;
    }
    public void setPointRadius(int radius){
        mPoint.setRadius(radius);
        invalidate();
    }
}
