package com.ljt.animalcollection.solo.windowtransition;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;

import com.ljt.animalcollection.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransitionActivity extends AppCompatActivity {

    public static final String EXTRA_TRANSITION = "EXTRA_TRANSITION";
    public static final String TRANSITION_FADE_FAST = "FADE_FAST";
    public static final String TRANSITION_FADE_SLOW = "FADE_SLOW";
    public static final String TRANSITION_SLIDE_RIGHT = "SLIDE_RIGHT";
    public static final String TRANSITION_SLIDE_BOTTOM = "SLIDE_BOTTOM";
    public static final String TRANSITION_EXPLODE = "EXPLODE";
    public static final String TRANSITION_EXPLODE_BOUNCE = "EXPLODE_BOUNCE";

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        ButterKnife.bind(this);

        String transition = getIntent().getStringExtra(EXTRA_TRANSITION);
        switch (transition){
            case TRANSITION_FADE_FAST:
                Transition transitionFadeFast= TransitionInflater.from(this).inflateTransition(R.transition.fade_fast);
                getWindow().setEnterTransition(transitionFadeFast);
                break;
            case TRANSITION_SLIDE_RIGHT:
                Transition transitionSlideRight= TransitionInflater.from(this).inflateTransition(R.transition.slide_right);
                getWindow().setEnterTransition(transitionSlideRight);
                break;
        }
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.text_close)
    public void onCloseTextClicked(){
        finishAfterTransition();
    }
}
