package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ATTextView extends android.widget.TextView {
    private android.animation.ObjectAnimator a;

    public ATTextView(android.content.Context context) {
        super(context);
    }

    public ATTextView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATTextView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.animation.ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setObjectAnimator(android.animation.ObjectAnimator objectAnimator) {
        this.a = objectAnimator;
    }
}
