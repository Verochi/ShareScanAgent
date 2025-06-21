package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatableGradientColorValue extends com.airbnb.lottie.model.animatable.BaseAnimatableValue<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> {
    public AnimatableGradientColorValue(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.content.GradientColor>> list) {
        super((java.util.List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation(this.a);
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ java.util.List getKeyframes() {
        return super.getKeyframes();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }
}
