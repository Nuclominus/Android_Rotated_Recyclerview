package com.nuclominus.fliprecycle.Utils;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;

public class AnimationUtil {

    public static void run(View child, int state) {
        if (state == 0) {
            child.startAnimation(applyRotation(child.getWidth() / 2, child.getHeight() / 5, 0, 0, -35));
            child.startAnimation(applyRotation(child.getWidth() / 2, child.getHeight() / 5, 0, 0, -35));
            child.setEnabled(false);
        } else if (state == 1) {
            child.startAnimation(applyRotation(child.getWidth() / 2, child.getHeight() / 5, -35, -35, 0));
        }
    }

    private static Rotate3dAnimation applyRotation(float centerX, float centerY, int position, float start, float end) {
        final Rotate3dAnimation rotation = new Rotate3dAnimation(start, end, centerX, centerY, 0.0f, true);
        rotation.setDuration(200);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(position));
        return rotation;
    }

    private final static class DisplayNextView implements Animation.AnimationListener {
        private final int mPosition;

        private DisplayNextView(int position) {
            mPosition = position;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

}
