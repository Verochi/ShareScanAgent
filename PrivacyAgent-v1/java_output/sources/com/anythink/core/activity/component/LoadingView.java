package com.anythink.core.activity.component;

/* loaded from: classes12.dex */
public class LoadingView extends android.widget.ImageView {
    public LoadingView(android.content.Context context) {
        super(context);
        a();
    }

    public LoadingView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        setImageDrawable(getResources().getDrawable(com.anythink.core.common.o.i.a(getContext(), "core_loading", com.anythink.expressad.foundation.h.i.c)));
        try {
            setLayerType(2, null);
        } catch (java.lang.Exception unused) {
        }
        a(this);
    }

    private static void a(android.view.View view) {
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        android.view.animation.LinearInterpolator linearInterpolator = new android.view.animation.LinearInterpolator();
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(1000L);
        view.startAnimation(rotateAnimation);
    }

    public void startAnimation() {
        a(this);
    }
}
