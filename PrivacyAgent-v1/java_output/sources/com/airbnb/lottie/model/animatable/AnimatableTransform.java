package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public class AnimatableTransform implements com.airbnb.lottie.animation.content.ModifierContent, com.airbnb.lottie.model.content.ContentModel {

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatablePathValue a;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> b;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableScaleValue c;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue d;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableIntegerValue e;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue f;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue g;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue h;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue i;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public AnimatableTransform(@androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatablePathValue animatablePathValue, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableScaleValue animatableScaleValue, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue3, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue4, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue5) {
        this.a = animatablePathValue;
        this.b = animatableValue;
        this.c = animatableScaleValue;
        this.d = animatableFloatValue;
        this.e = animatableIntegerValue;
        this.h = animatableFloatValue2;
        this.i = animatableFloatValue3;
        this.f = animatableFloatValue4;
        this.g = animatableFloatValue5;
    }

    public com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation(this);
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatablePathValue getAnchorPoint() {
        return this.a;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getEndOpacity() {
        return this.i;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableIntegerValue getOpacity() {
        return this.e;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> getPosition() {
        return this.b;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getRotation() {
        return this.d;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableScaleValue getScale() {
        return this.c;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getSkew() {
        return this.f;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getSkewAngle() {
        return this.g;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getStartOpacity() {
        return this.h;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return null;
    }
}
