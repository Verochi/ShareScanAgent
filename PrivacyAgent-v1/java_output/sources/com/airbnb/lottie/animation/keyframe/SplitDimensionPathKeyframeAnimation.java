package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> {
    public final android.graphics.PointF g;
    public final android.graphics.PointF h;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> i;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> j;

    @androidx.annotation.Nullable
    protected com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> xValueCallback;

    @androidx.annotation.Nullable
    protected com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> yValueCallback;

    public SplitDimensionPathKeyframeAnimation(com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation2) {
        super(java.util.Collections.emptyList());
        this.g = new android.graphics.PointF();
        this.h = new android.graphics.PointF();
        this.i = baseKeyframeAnimation;
        this.j = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public android.graphics.PointF getValue() {
        return getValue((com.airbnb.lottie.value.Keyframe<android.graphics.PointF>) null, 0.0f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public android.graphics.PointF getValue(com.airbnb.lottie.value.Keyframe<android.graphics.PointF> keyframe, float f) {
        java.lang.Float f2;
        com.airbnb.lottie.value.Keyframe<java.lang.Float> currentKeyframe;
        com.airbnb.lottie.value.Keyframe<java.lang.Float> currentKeyframe2;
        java.lang.Float f3 = null;
        if (this.xValueCallback == null || (currentKeyframe2 = this.i.getCurrentKeyframe()) == null) {
            f2 = null;
        } else {
            float interpolatedCurrentKeyframeProgress = this.i.getInterpolatedCurrentKeyframeProgress();
            java.lang.Float f4 = currentKeyframe2.endFrame;
            com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> lottieValueCallback = this.xValueCallback;
            float f5 = currentKeyframe2.startFrame;
            f2 = lottieValueCallback.getValueInternal(f5, f4 == null ? f5 : f4.floatValue(), currentKeyframe2.startValue, currentKeyframe2.endValue, f, f, interpolatedCurrentKeyframeProgress);
        }
        if (this.yValueCallback != null && (currentKeyframe = this.j.getCurrentKeyframe()) != null) {
            float interpolatedCurrentKeyframeProgress2 = this.j.getInterpolatedCurrentKeyframeProgress();
            java.lang.Float f6 = currentKeyframe.endFrame;
            com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> lottieValueCallback2 = this.yValueCallback;
            float f7 = currentKeyframe.startFrame;
            f3 = lottieValueCallback2.getValueInternal(f7, f6 == null ? f7 : f6.floatValue(), currentKeyframe.startValue, currentKeyframe.endValue, f, f, interpolatedCurrentKeyframeProgress2);
        }
        if (f2 == null) {
            this.h.set(this.g.x, 0.0f);
        } else {
            this.h.set(f2.floatValue(), 0.0f);
        }
        if (f3 == null) {
            android.graphics.PointF pointF = this.h;
            pointF.set(pointF.x, this.g.y);
        } else {
            android.graphics.PointF pointF2 = this.h;
            pointF2.set(pointF2.x, f3.floatValue());
        }
        return this.h;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f) {
        this.i.setProgress(f);
        this.j.setProgress(f);
        this.g.set(this.i.getValue().floatValue(), this.j.getValue().floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).onValueChanged();
        }
    }

    public void setXValueCallback(@androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> lottieValueCallback) {
        com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> lottieValueCallback2 = this.xValueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.xValueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    public void setYValueCallback(@androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> lottieValueCallback) {
        com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> lottieValueCallback2 = this.yValueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.yValueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }
}
