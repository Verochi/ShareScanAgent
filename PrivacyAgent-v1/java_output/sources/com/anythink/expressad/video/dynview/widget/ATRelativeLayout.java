package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ATRelativeLayout extends android.widget.RelativeLayout {
    private boolean a;
    private android.animation.AnimatorSet b;
    private boolean c;

    public ATRelativeLayout(android.content.Context context) {
        super(context);
    }

    public ATRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.animation.AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.a) {
            this.a = true;
        }
        android.animation.AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void setAnimatorSet(android.animation.AnimatorSet animatorSet) {
        this.b = animatorSet;
    }
}
