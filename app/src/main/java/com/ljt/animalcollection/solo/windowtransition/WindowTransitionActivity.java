package com.ljt.animalcollection.solo.windowtransition;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ljt.animalcollection.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${JT.L} on 2018/4/2.
 */

public class WindowTransitionActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitywindow_layout);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.text_fade_fast)
    public void startFadeFastTransition(){
        Intent intent = new Intent(WindowTransitionActivity.this,TransitionActivity.class);
        intent.putExtra(TransitionActivity.EXTRA_TRANSITION,TransitionActivity.TRANSITION_FADE_FAST);
        startActivityWithOptions(intent);
    }
    @OnClick(R.id.text_slide_right)
    public void startSlideRightTransition(){
        Intent intent = new Intent(WindowTransitionActivity.this,TransitionActivity.class);
        intent.putExtra(TransitionActivity.EXTRA_TRANSITION,TransitionActivity.TRANSITION_SLIDE_RIGHT);
        startActivityWithOptions(intent);
    }



    private void startActivityWithOptions(Intent intent){
        ActivityOptions transitionActivity=ActivityOptions.makeSceneTransitionAnimation(WindowTransitionActivity.this);
        startActivity(intent,transitionActivity.toBundle());
    }

}
