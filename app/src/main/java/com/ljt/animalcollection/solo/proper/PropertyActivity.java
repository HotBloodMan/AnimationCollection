package com.ljt.animalcollection.solo.proper;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.ljt.animalcollection.R;

public class PropertyActivity extends AppCompatActivity {

    private Button btnOk;
    private Button btnCancel;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        btnOk = (Button) findViewById(R.id.proper_ok);
        btnCancel = (Button) findViewById(R.id.proper_cancel);
        tvShow = (TextView) findViewById(R.id.proper_tvshow);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //----------1---------------
//                PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
//                PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
//                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tvShow, rotationHolder, colorHolder);
//                animator.setDuration(3000);
//                animator.setInterpolator(new AccelerateInterpolator());
//                animator.start();
                //-----------2-----------------------

                doKeyFloatAnima();

            }
        });
    }
    private void doKeyFloatAnima() {
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        frame3.setInterpolator(new BounceInterpolator());
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        frame7.setInterpolator(new AccelerateDecelerateInterpolator());
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10);

        Animator animator = ObjectAnimator.ofPropertyValuesHolder(tvShow, frameHolder);
        animator.setDuration(1000);
        animator.start();

    }
}















