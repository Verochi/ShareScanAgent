package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatableTextFrame extends com.airbnb.lottie.model.animatable.BaseAnimatableValue<com.airbnb.lottie.model.DocumentData, com.airbnb.lottie.model.DocumentData> {
    public AnimatableTextFrame(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.DocumentData>> list) {
        super((java.util.List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation(this.a);
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
