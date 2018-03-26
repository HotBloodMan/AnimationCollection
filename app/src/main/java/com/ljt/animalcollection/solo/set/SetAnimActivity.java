package com.ljt.animalcollection.solo.set;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljt.animalcollection.R;

public class SetAnimActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView iv_set;
    private TextView tv_together;
    private TextView tv_sync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_anim);
        findView();
        setOnClick();
    }
    private void findView() {
        iv_set = (ImageView) findViewById(R.id.iv_set);
        tv_together = (TextView) findViewById(R.id.tv_together);
        tv_sync = (TextView) findViewById(R.id.tv_sync);
    }
    private void setOnClick() {
        tv_together.setOnClickListener(this);
        tv_sync.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_together:
                SetAnim.startAnim(iv_set);
                break;
            case R.id.tv_sync:
                SetAnim.startAnimSync(iv_set);
                break;
        }
    }
}
