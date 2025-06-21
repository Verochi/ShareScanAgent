package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class GradientStroke implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final com.airbnb.lottie.model.content.GradientType b;
    public final com.airbnb.lottie.model.animatable.AnimatableGradientColorValue c;
    public final com.airbnb.lottie.model.animatable.AnimatableIntegerValue d;
    public final com.airbnb.lottie.model.animatable.AnimatablePointValue e;
    public final com.airbnb.lottie.model.animatable.AnimatablePointValue f;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue g;
    public final com.airbnb.lottie.model.content.ShapeStroke.LineCapType h;
    public final com.airbnb.lottie.model.content.ShapeStroke.LineJoinType i;
    public final float j;
    public final java.util.List<com.airbnb.lottie.model.animatable.AnimatableFloatValue> k;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue l;
    public final boolean m;

    public GradientStroke(java.lang.String str, com.airbnb.lottie.model.content.GradientType gradientType, com.airbnb.lottie.model.animatable.AnimatableGradientColorValue animatableGradientColorValue, com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue, com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue, com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue2, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, com.airbnb.lottie.model.content.ShapeStroke.LineCapType lineCapType, com.airbnb.lottie.model.content.ShapeStroke.LineJoinType lineJoinType, float f, java.util.List<com.airbnb.lottie.model.animatable.AnimatableFloatValue> list, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.a = str;
        this.b = gradientType;
        this.c = animatableGradientColorValue;
        this.d = animatableIntegerValue;
        this.e = animatablePointValue;
        this.f = animatablePointValue2;
        this.g = animatableFloatValue;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f;
        this.k = list;
        this.l = animatableFloatValue2;
        this.m = z;
    }

    public com.airbnb.lottie.model.content.ShapeStroke.LineCapType getCapType() {
        return this.h;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getDashOffset() {
        return this.l;
    }

    public com.airbnb.lottie.model.animatable.AnimatablePointValue getEndPoint() {
        return this.f;
    }

    public com.airbnb.lottie.model.animatable.AnimatableGradientColorValue getGradientColor() {
        return this.c;
    }

    public com.airbnb.lottie.model.content.GradientType getGradientType() {
        return this.b;
    }

    public com.airbnb.lottie.model.content.ShapeStroke.LineJoinType getJoinType() {
        return this.i;
    }

    public java.util.List<com.airbnb.lottie.model.animatable.AnimatableFloatValue> getLineDashPattern() {
        return this.k;
    }

    public float getMiterLimit() {
        return this.j;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableIntegerValue getOpacity() {
        return this.d;
    }

    public com.airbnb.lottie.model.animatable.AnimatablePointValue getStartPoint() {
        return this.e;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getWidth() {
        return this.g;
    }

    public boolean isHidden() {
        return this.m;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.GradientStrokeContent(lottieDrawable, baseLayer, this);
    }
}
