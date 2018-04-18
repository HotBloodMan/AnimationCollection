package com.ljt.animalcollection.solo.windowtransition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ljt.animalcollection.R;

import static android.os.Build.VERSION_CODES.M;

public class MainAnimalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMorph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animal);
        btnMorph = (Button) findViewById(R.id.btn_anim_morph);
        btnMorph.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_anim_morph:
//               startIntents(MorphTransitionsActivity.class);
                break;

        }
    }
    public void startIntents(Class c){
        Intent intent = new Intent(MainAnimalActivity.this, c);
        startActivity(intent);
    }
}
