package com.ljt.animalcollection.solo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljt.animalcollection.R;

public class ViewActivity extends AppCompatActivity {
    public static String TAG= ViewActivity.class.getSimpleName();
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initView();
//        PropertyValuesHolder
    }
    private void initView() {
        tv = (TextView) findViewById(R.id.tv_solo);
        iv = (ImageView) findViewById(R.id.iv_solo);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.animate()
                        .rotationX(180.f)
                        .alpha(0.5f)
                        .scaleX(0.5f)
                        .scaleY(0.5f)
                        .setDuration(2000)
                        .setInterpolator(new LinearInterpolator())
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                Log.d(TAG,"aaaa--->>>animation end");
                                iv.setAlpha(1.0f);
                                iv.setRotationX(0.f);

                            }
                            @Override
                            public void onAnimationCancel(Animator animation) {
                                super.onAnimationCancel(animation);
                                onAnimationEnd(animation);
                            }
                            @Override
                            public void onAnimationRepeat(Animator animation) {
                                super.onAnimationRepeat(animation);
                            }
                            @Override
                            public void onAnimationStart(Animator animation) {
                                super.onAnimationStart(animation);
                            }
                        })
                        .withStartAction(new Runnable() {
                            @Override
                            public void run() {
                                Log.d(TAG,"with start action");
                                iv.setRotationY(0.8f);
                            }
                        })
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                Log.d(TAG,"with end action");
                                iv.setScaleX(0.5f);
                                iv.setScaleY(0.5f);
                            }
                        }).start();
            }
        });
    }
}
