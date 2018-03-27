package com.ljt.animalcollection.solo.object;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ljt.animalcollection.R;

import java.util.ArrayList;

public class ObjectActivity extends AppCompatActivity {
    private Button btnOk;
    private Button btnCancel;
    private TextView tv;
    private MyPoint mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        btnOk = (Button) findViewById(R.id.object_ok);
        btnCancel = (Button) findViewById(R.id.objec_cancel);
        tv = (TextView) findViewById(R.id.objec_tvshow);
        mp = (MyPoint) findViewById(R.id.object_mp);
        ArrayList<String> strings = new ArrayList<>();
        initView2();
    }
    private void initView2() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "rotationY", 0, 180,0);
//                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", 0,200,-200,0);
//                animator.setDuration(2000);
//                animator.start();
                doPointViewAnimation();
            }
        });
    }
    public void doPointViewAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofInt(mp, "pointRadius", 100);
        animator.setDuration(1000);
        animator.start();
    }
}
