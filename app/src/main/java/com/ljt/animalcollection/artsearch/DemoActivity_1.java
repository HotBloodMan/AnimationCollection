package com.ljt.animalcollection.artsearch;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ljt.animalcollection.R;

public class DemoActivity_1 extends Activity {
public static String TAG= DemoActivity_1.class.getSimpleName();
//    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_1);
        initView();
    }

    private void initView() {
         Log.d(TAG,TAG+" ----->>>initView() ");
        button1 = (Button) findViewById(R.id.button1_demo1);
//        performAnimate(button,button.getWidth(),500);
    }
    public void onClicks(View v){
        if(v==button1){
            Log.d(TAG,TAG+" ----->>> onClicks(View v) ");
            performAnimate(button1,button1.getWidth(),500);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
             Log.d(TAG,TAG+" ----->>> hasFocus="+hasFocus);
//            button = (Button) findViewById(R.id.button1);
            //没效果
            // 2
//            performAnimate();
        }
    }

    private void performAnimate() {
        ViewWrapper viewWrapper = new ViewWrapper(button1);
        ObjectAnimator.ofInt(viewWrapper,"width",500).setDuration(5000).start();
    }

        private void performAnimate(final View target,final int start,final int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            IntEvaluator evaluator = new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue= (Integer) animation.getAnimatedValue();
                 Log.d(TAG,TAG+" ----->>> currentValue= "+currentValue);
                float fraction = animation.getAnimatedFraction();
                target.getLayoutParams().width=evaluator.evaluate(fraction,start,end);
                target.requestLayout();
            }
        });
        valueAnimator.setDuration(5000).start();
    }
    private static class ViewWrapper{
        private View mTarget;

        public ViewWrapper(View mTarget) {
            this.mTarget = mTarget;
        }
        public int getWidth(){
            return mTarget.getLayoutParams().width;
        }
        public void setWidth(int width){
            mTarget.getLayoutParams().width=width;
            mTarget.requestLayout();
        }
    }
}
