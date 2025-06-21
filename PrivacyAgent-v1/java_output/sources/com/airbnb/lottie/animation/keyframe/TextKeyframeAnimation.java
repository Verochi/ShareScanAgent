package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class TextKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<com.airbnb.lottie.model.DocumentData> {
    public TextKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.DocumentData>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.model.DocumentData getValue(com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.DocumentData> keyframe, float f) {
        com.airbnb.lottie.model.DocumentData documentData;
        return (f != 1.0f || (documentData = keyframe.endValue) == null) ? keyframe.startValue : documentData;
    }
}
