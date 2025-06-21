package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatableScaleValue extends com.airbnb.lottie.model.animatable.BaseAnimatableValue<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> {
    public AnimatableScaleValue() {
        this(new com.airbnb.lottie.value.ScaleXY(1.0f, 1.0f));
    }

    public AnimatableScaleValue(com.airbnb.lottie.value.ScaleXY scaleXY) {
        super(scaleXY);
    }

    public AnimatableScaleValue(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.value.ScaleXY>> list) {
        super((java.util.List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.ScaleKeyframeAnimation(this.a);
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
