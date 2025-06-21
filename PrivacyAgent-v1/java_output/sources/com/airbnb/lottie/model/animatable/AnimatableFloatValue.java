package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatableFloatValue extends com.airbnb.lottie.model.animatable.BaseAnimatableValue<java.lang.Float, java.lang.Float> {
    public AnimatableFloatValue() {
        super(java.lang.Float.valueOf(0.0f));
    }

    public AnimatableFloatValue(java.util.List<com.airbnb.lottie.value.Keyframe<java.lang.Float>> list) {
        super((java.util.List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation(this.a);
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
