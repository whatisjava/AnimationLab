package com.showtoyou.animationlab;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PropertyAnimationActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        textView = (TextView) findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PropertyAnimationActivity.this, "点上了", Toast.LENGTH_SHORT).show();
            }
        });

//        button = (Button) findViewById(R.id.button);

//        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animator_set);
//        set.setTarget(button);
//        set.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//                Toast.makeText(PropertyAnimationActivity.this, "start", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                Toast.makeText(PropertyAnimationActivity.this, "end", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//                Toast.makeText(PropertyAnimationActivity.this, "cancel", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//                Toast.makeText(PropertyAnimationActivity.this, "repeat", Toast.LENGTH_SHORT).show();
//            }
//        });
//        set.start();

        ValueAnimator xmlAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.animator);
        xmlAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                Log.d("update value", "" + animatedValue);
                textView.setTranslationX(animatedValue);
            }
        });

//        ValueAnimator animation = ValueAnimator.ofFloat(0f, 100f);
//        animation.setDuration(1000);
//        animation.start();
//        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                float animatedValue = (float) valueAnimator.getAnimatedValue();
//                textView.setTranslationX(animatedValue);
//                textView.setTranslationY(animatedValue);
//                textView.setTranslationZ(animatedValue);
//            }
//        });

//        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, translationX, 100f);
//        animator.setDuration(1000);
//        animator.start();
//
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(textView, translationX, 0f);
//        animator.setDuration(1000);
//        animator.start();

//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(animator).before(animator1);
//        animatorSet.start();

//        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
//        Keyframe kf1 = Keyframe.ofFloat(.5f, 360f);
//        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
//        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
//        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(textView, pvhRotation);
//        rotationAnim.setDuration(5000);
//        rotationAnim.start();

//        ObjectAnimator animX = ObjectAnimator.ofFloat(textView, "x", 50f);
//        ObjectAnimator animY = ObjectAnimator.ofFloat(textView, "y", 100f);
//        AnimatorSet animSetXY = new AnimatorSet();
//        animSetXY.playTogether(animX, animY);
//        animSetXY.start();

//        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("x", 50f);
//        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", 100f);
//        ObjectAnimator.ofPropertyValuesHolder(textView, pvhX, pvhY).start();

//        textView.animate().x(100f).y(100f);
    }

    Property<TextView, Float> translationX = new Property<TextView, Float>(Float.class, "translationX") {
        @Override
        public Float get(TextView object) {
            return object.getTranslationX();
        }

        @Override
        public void set(TextView object, Float value) {
            object.setTranslationX(value.floatValue());
        }
    };

    Property<TextView, Float> alpha = new Property<TextView, Float>(Float.class, "alpha") {
        @Override
        public Float get(TextView object) {
            return object.getAlpha();
        }

        @Override
        public void set(TextView object, Float value) {
            object.setAlpha(value.floatValue());
        }
    };

}
