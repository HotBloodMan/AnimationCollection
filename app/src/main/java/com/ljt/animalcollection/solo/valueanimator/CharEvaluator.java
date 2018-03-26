package com.ljt.animalcollection.solo.valueanimator;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by ${JT.L} on 2018/3/26.
 */

public class CharEvaluator implements TypeEvaluator<Character> {
    public static String TAG= CharEvaluator.class.getSimpleName();
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt=(int)startValue;
        int endInt=(int)endValue;
        int curInt=(int)(startInt+fraction*(endInt-startInt));
        char result=(char)curInt;
         Log.d(TAG,TAG+" ----->>> result="+result);
        return result;
    }
}
