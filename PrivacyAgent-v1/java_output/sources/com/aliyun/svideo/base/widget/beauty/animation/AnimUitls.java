package com.aliyun.svideo.base.widget.beauty.animation;

/* loaded from: classes.dex */
public class AnimUitls {

    /* renamed from: com.aliyun.svideo.base.widget.beauty.animation.AnimUitls$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view) {
            this.val$view = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            android.view.View view = this.val$view;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    public static void startAppearAnimOnTop(android.view.View view) {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(250L);
        view.startAnimation(translateAnimation);
    }

    public static void startAppearAnimY(android.view.View view) {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(250L);
        view.startAnimation(translateAnimation);
    }

    public static void startDisappearAnimOnTop(android.view.View view) {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setAnimationListener(new com.aliyun.svideo.base.widget.beauty.animation.AnimUitls.AnonymousClass1(view));
        view.startAnimation(translateAnimation);
    }

    public static void startDisappearAnimY(android.view.View view) {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(250L);
        view.startAnimation(translateAnimation);
    }
}
