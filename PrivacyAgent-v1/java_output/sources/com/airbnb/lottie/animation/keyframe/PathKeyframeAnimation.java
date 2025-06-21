package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class PathKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<android.graphics.PointF> {
    public final android.graphics.PointF g;
    public final float[] h;
    public final android.graphics.PathMeasure i;
    public com.airbnb.lottie.animation.keyframe.PathKeyframe j;

    public PathKeyframeAnimation(java.util.List<? extends com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> list) {
        super(list);
        this.g = new android.graphics.PointF();
        this.h = new float[2];
        this.i = new android.graphics.PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public android.graphics.PointF getValue(com.airbnb.lottie.value.Keyframe<android.graphics.PointF> keyframe, float f) {
        android.graphics.PointF pointF;
        com.airbnb.lottie.animation.keyframe.PathKeyframe pathKeyframe = (com.airbnb.lottie.animation.keyframe.PathKeyframe) keyframe;
        android.graphics.Path a = pathKeyframe.a();
        if (a == null) {
            return keyframe.startValue;
        }
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != 0 && (pointF = (android.graphics.PointF) lottieValueCallback.getValueInternal(pathKeyframe.startFrame, pathKeyframe.endFrame.floatValue(), pathKeyframe.startValue, pathKeyframe.endValue, b(), f, getProgress())) != null) {
            return pointF;
        }
        if (this.j != pathKeyframe) {
            this.i.setPath(a, false);
            this.j = pathKeyframe;
        }
        android.graphics.PathMeasure pathMeasure = this.i;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.h, null);
        android.graphics.PointF pointF2 = this.g;
        float[] fArr = this.h;
        pointF2.set(fArr[0], fArr[1]);
        return this.g;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ java.lang.Object getValue(com.airbnb.lottie.value.Keyframe keyframe, float f) {
        return getValue((com.airbnb.lottie.value.Keyframe<android.graphics.PointF>) keyframe, f);
    }
}
