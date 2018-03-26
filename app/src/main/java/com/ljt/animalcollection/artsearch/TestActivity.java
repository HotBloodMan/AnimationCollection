package com.ljt.animalcollection.artsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ljt.animalcollection.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
    }
}
