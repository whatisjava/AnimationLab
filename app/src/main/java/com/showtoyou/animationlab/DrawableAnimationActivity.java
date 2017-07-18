package com.showtoyou.animationlab;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by whatisjava on 17-7-18.
 */

public class DrawableAnimationActivity extends Activity {

    private AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);

        ImageView rocketImage = findViewById(R.id.image_view);
        rocketImage.setImageResource(R.drawable.drawable_animation);
        rocketAnimation = (AnimationDrawable) rocketImage.getDrawable();
    }

    @Override
    protected void onResume() {
        super.onResume();
        rocketAnimation.start();

// It's important to note that the start() method called on the AnimationDrawable cannot be
// called during the onCreate() method of your Activity, because the AnimationDrawable is not yet
// fully attached to the window. If you want to play the animation immediately, without requiring
// interaction, then you might want to call it from the onWindowFocusChanged() method in your
// Activity, which will get called when Android brings your window into focus.

    }
}
