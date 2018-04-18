package com.ljt.animalcollection.solo.object2;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterViewAnimator;

import com.ljt.animalcollection.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Test2Activity extends AppCompatActivity {

    @Bind(R.id.flipper_content)
     AdapterViewAnimator mContentFlipper;

    private boolean isAnimatingUp;
    private int mContentCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);

        isAnimatingUp=true;
        mContentCount=20;
        mContentFlipper.setAdapter(new FrameAdapter(this,mContentCount));
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null) actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void showNext(){
        if(mContentCount >1){
            setAnimations();
            mContentFlipper.showNext();
            isAnimatingUp=!isAnimatingUp;
            mContentCount--;
        }else{
            finish();
        }
    }

    private void setAnimations() {
        mContentFlipper.setInAnimation(this,isAnimatingUp
                ? R.animator.slide_in_bottom:R.animator.slide_in_left);
        mContentFlipper.setOutAnimation(this,isAnimatingUp?R.animator.slide_out_top:R.animator.slide_out_right);
    }
}
