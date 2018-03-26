package com.ljt.animalcollection.solo.valueanimator;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.ljt.animalcollection.R;

public class ValueActivity extends AppCompatActivity {

    private Button btnOk;
    private Button btnCancel;
    private TextView tv;
    private ValueAnimator animator;
    private MyPointView mpv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);
        btnOk = (Button) findViewById(R.id.value_ok);
        btnCancel = (Button) findViewById(R.id.value_cancel);
        initView2();
//        initView();
    }

    private void initView2() {
        mpv = (MyPointView) findViewById(R.id.value_mypointview);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpv.doValueAnim();
            }
        });
    }

    private void initView() {

        tv = (TextView) findViewById(R.id.value_tvshow);
        animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        char text= (char) animation.getAnimatedValue();
                        tv.setText(String.valueOf(text));
                    }
                });

            }
        });
        animator.setDuration(5000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();

    }
}
