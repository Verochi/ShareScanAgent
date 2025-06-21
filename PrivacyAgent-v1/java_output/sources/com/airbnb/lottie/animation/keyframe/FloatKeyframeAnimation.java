package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class FloatKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<java.lang.Float> {
    public FloatKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<java.lang.Float>> list) {
        super(list);
    }

    public float e(com.airbnb.lottie.value.Keyframe<java.lang.Float> keyframe, float f) {
        java.lang.Float f2;
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        return (lottieValueCallback == 0 || (f2 = (java.lang.Float) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, b(), getProgress())) == null) ? com.airbnb.lottie.utils.MiscUtils.lerp(keyframe.getStartValueFloat(), keyframe.getEndValueFloat(), f) : f2.floatValue();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public java.lang.Float getValue(com.airbnb.lottie.value.Keyframe<java.lang.Float> keyframe, float f) {
        return java.lang.Float.valueOf(e(keyframe, f));
    }

    public float getFloatValue() {
        return e(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
