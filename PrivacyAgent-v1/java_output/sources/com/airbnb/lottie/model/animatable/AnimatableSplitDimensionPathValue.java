package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatableSplitDimensionPathValue implements com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> {
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue a;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue b;

    public AnimatableSplitDimensionPathValue(com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2) {
        this.a = animatableFloatValue;
        this.b = animatableFloatValue2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation(this.a.createAnimation(), this.b.createAnimation());
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public java.util.List<com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> getKeyframes() {
        throw new java.lang.UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.isStatic() && this.b.isStatic();
    }
}
