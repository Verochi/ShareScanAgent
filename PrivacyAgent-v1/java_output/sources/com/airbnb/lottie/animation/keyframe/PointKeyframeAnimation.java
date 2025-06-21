package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class PointKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<android.graphics.PointF> {
    public final android.graphics.PointF g;

    public PointKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> list) {
        super(list);
        this.g = new android.graphics.PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public android.graphics.PointF getValue(com.airbnb.lottie.value.Keyframe<android.graphics.PointF> keyframe, float f) {
        return getValue(keyframe, f, f, f);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public android.graphics.PointF getValue(com.airbnb.lottie.value.Keyframe<android.graphics.PointF> keyframe, float f, float f2, float f3) {
        android.graphics.PointF pointF;
        android.graphics.PointF pointF2;
        android.graphics.PointF pointF3 = keyframe.startValue;
        if (pointF3 == null || (pointF = keyframe.endValue) == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        android.graphics.PointF pointF4 = pointF3;
        android.graphics.PointF pointF5 = pointF;
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != 0 && (pointF2 = (android.graphics.PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF4, pointF5, f, b(), getProgress())) != null) {
            return pointF2;
        }
        android.graphics.PointF pointF6 = this.g;
        float f4 = pointF4.x;
        float f5 = f4 + (f2 * (pointF5.x - f4));
        float f6 = pointF4.y;
        pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
        return this.g;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ java.lang.Object getValue(com.airbnb.lottie.value.Keyframe keyframe, float f) {
        return getValue((com.airbnb.lottie.value.Keyframe<android.graphics.PointF>) keyframe, f);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ java.lang.Object getValue(com.airbnb.lottie.value.Keyframe keyframe, float f, float f2, float f3) {
        return getValue((com.airbnb.lottie.value.Keyframe<android.graphics.PointF>) keyframe, f, f2, f3);
    }
}
