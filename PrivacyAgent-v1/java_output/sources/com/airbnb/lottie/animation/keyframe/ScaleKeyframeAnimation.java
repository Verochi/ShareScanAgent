package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<com.airbnb.lottie.value.ScaleXY> {
    public final com.airbnb.lottie.value.ScaleXY g;

    public ScaleKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.value.ScaleXY>> list) {
        super(list);
        this.g = new com.airbnb.lottie.value.ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public com.airbnb.lottie.value.ScaleXY getValue(com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.value.ScaleXY> keyframe, float f) {
        com.airbnb.lottie.value.ScaleXY scaleXY;
        com.airbnb.lottie.value.ScaleXY scaleXY2;
        com.airbnb.lottie.value.ScaleXY scaleXY3 = keyframe.startValue;
        if (scaleXY3 == null || (scaleXY = keyframe.endValue) == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.value.ScaleXY scaleXY4 = scaleXY3;
        com.airbnb.lottie.value.ScaleXY scaleXY5 = scaleXY;
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != 0 && (scaleXY2 = (com.airbnb.lottie.value.ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY4, scaleXY5, f, b(), getProgress())) != null) {
            return scaleXY2;
        }
        this.g.set(com.airbnb.lottie.utils.MiscUtils.lerp(scaleXY4.getScaleX(), scaleXY5.getScaleX(), f), com.airbnb.lottie.utils.MiscUtils.lerp(scaleXY4.getScaleY(), scaleXY5.getScaleY(), f));
        return this.g;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ java.lang.Object getValue(com.airbnb.lottie.value.Keyframe keyframe, float f) {
        return getValue((com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.value.ScaleXY>) keyframe, f);
    }
}
