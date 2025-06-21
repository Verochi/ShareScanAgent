package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ScanningAnimButton extends android.widget.Button {
    android.animation.ValueAnimator a;

    /* renamed from: com.anythink.basead.ui.ScanningAnimButton$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.anythink.basead.ui.ScanningAnimButton.this.setScaleX(floatValue);
            com.anythink.basead.ui.ScanningAnimButton.this.setScaleY(floatValue);
        }
    }

    public ScanningAnimButton(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void a() {
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    public void startAnimation() {
        if (this.a == null) {
            android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.95f);
            this.a = ofFloat;
            ofFloat.setDuration(500L);
            this.a.addUpdateListener(new com.anythink.basead.ui.ScanningAnimButton.AnonymousClass1());
            this.a.setRepeatMode(2);
            this.a.setRepeatCount(-1);
        }
        if (this.a.isStarted()) {
            return;
        }
        this.a.start();
    }

    public void stopAnimation() {
        android.animation.ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
