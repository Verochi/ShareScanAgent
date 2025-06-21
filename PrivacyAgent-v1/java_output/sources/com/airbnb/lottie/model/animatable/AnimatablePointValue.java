package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatablePointValue extends com.airbnb.lottie.model.animatable.BaseAnimatableValue<android.graphics.PointF, android.graphics.PointF> {
    public AnimatablePointValue(java.util.List<com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> list) {
        super((java.util.List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation(this.a);
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
