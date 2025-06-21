package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ATFramLayout extends android.widget.FrameLayout {
    private android.animation.AnimatorSet a;

    public ATFramLayout(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
    }

    public ATFramLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATFramLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.animation.AnimatorSet animatorSet = this.a;
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
        android.animation.AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setAnimatorSet(android.animation.AnimatorSet animatorSet) {
        this.a = animatorSet;
    }
}
