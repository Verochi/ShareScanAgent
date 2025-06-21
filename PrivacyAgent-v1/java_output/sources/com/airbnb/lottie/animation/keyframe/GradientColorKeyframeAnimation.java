package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class GradientColorKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.KeyframeAnimation<com.airbnb.lottie.model.content.GradientColor> {
    public final com.airbnb.lottie.model.content.GradientColor g;

    public GradientColorKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.content.GradientColor>> list) {
        super(list);
        com.airbnb.lottie.model.content.GradientColor gradientColor = list.get(0).startValue;
        int size = gradientColor != null ? gradientColor.getSize() : 0;
        this.g = new com.airbnb.lottie.model.content.GradientColor(new float[size], new int[size]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.model.content.GradientColor getValue(com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.content.GradientColor> keyframe, float f) {
        this.g.lerp(keyframe.startValue, keyframe.endValue, f);
        return this.g;
    }
}
