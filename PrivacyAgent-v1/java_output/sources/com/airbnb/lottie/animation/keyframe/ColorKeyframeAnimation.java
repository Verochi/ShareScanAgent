package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class ColorKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<java.lang.Integer> {
    public ColorKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<java.lang.Integer>> list) {
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
        java.lang.Integer num2 = keyframe.startValue;
        if (num2 == null || keyframe.endValue == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        int intValue = num2.intValue();
        int intValue2 = keyframe.endValue.intValue();
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        return (lottieValueCallback == 0 || (num = (java.lang.Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), java.lang.Integer.valueOf(intValue), java.lang.Integer.valueOf(intValue2), f, b(), getProgress())) == null) ? com.airbnb.lottie.utils.GammaEvaluator.evaluate(com.airbnb.lottie.utils.MiscUtils.clamp(f, 0.0f, 1.0f), intValue, intValue2) : num.intValue();
    }
}
