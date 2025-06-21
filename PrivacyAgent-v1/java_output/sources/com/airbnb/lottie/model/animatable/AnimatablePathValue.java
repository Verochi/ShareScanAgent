package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatablePathValue implements com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> {
    public final java.util.List<com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> a;

    public AnimatablePathValue() {
        this.a = java.util.Collections.singletonList(new com.airbnb.lottie.value.Keyframe(new android.graphics.PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(java.util.List<com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation() {
        return this.a.get(0).isStatic() ? new com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation(this.a) : new com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation(this.a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public java.util.List<com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> getKeyframes() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).isStatic();
    }
}
