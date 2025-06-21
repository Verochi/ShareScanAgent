package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class IntegerKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<java.lang.Integer> {
    public IntegerKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<java.lang.Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer getValue(com.airbnb.lottie.value.Keyframe<java.lang.Integer> keyframe, float f) {
        return java.lang.Integer.valueOf(getIntValue(keyframe, f));
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }

    public int getIntValue(com.airbnb.lottie.value.Keyframe<java.lang.Integer> keyframe, float f) {
        java.lang.Integer num;
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        return (lottieValueCallback == 0 || (num = (java.lang.Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, b(), getProgress())) == null) ? com.airbnb.lottie.utils.MiscUtils.lerp(keyframe.getStartValueInt(), keyframe.getEndValueInt(), f) : num.intValue();
    }
}
