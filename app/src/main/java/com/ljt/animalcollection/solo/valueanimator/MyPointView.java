package com.ljt.animalcollection.solo.valueanimator;

import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by ${JT.L} on 2018/3/26.
 */

public class MyPointView  extends View {

    private Point mCurrent;
    private Paint mPaint;

    public MyPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        if(mCurrent!=null){

            canvas.drawCircle(300,300,mCurrent.getRadius(),mPaint);
            invalidate();
        }
    }
    public void doValueAnim(){
        ValueAnimator animator=ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(200));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
            mCurrent= (Point) animation.getAnimatedValue();
            }
        });
        animator.setInterpolator(new BounceInterpolator());
        animator.setDuration(3000);
        animator.start();
    }
}
