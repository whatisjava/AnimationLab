package com.showtoyou.animationlab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by whatisjava on 17-7-18.
 */

public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button alpha, scale, translate, rotate;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        alpha = (Button) findViewById(R.id.alpha);
        alpha.setOnClickListener(this);
        scale = (Button) findViewById(R.id.scale);
        scale.setOnClickListener(this);
        translate = (Button) findViewById(R.id.translate);
        translate.setOnClickListener(this);
        rotate = (Button) findViewById(R.id.rotate);
        rotate.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.text_view);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alpha:
                Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
                textView.startAnimation(alpha);
                break;
            case R.id.scale:
                Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
                textView.startAnimation(scale);
                break;
            case R.id.translate:
                Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
                textView.startAnimation(translate);
                break;
            case R.id.rotate:
                Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
                textView.startAnimation(rotate);
                break;

        }
    }
}
