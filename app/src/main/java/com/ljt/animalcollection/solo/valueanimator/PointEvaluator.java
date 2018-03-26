package com.ljt.animalcollection.solo.valueanimator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by ${JT.L} on 2018/3/26.
 */

public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();
        int current = (int) (start + (end - start) * fraction);
        return new Point(current);
    }
}
