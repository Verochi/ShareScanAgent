package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class GradientFill implements com.airbnb.lottie.model.content.ContentModel {
    public final com.airbnb.lottie.model.content.GradientType a;
    public final android.graphics.Path.FillType b;
    public final com.airbnb.lottie.model.animatable.AnimatableGradientColorValue c;
    public final com.airbnb.lottie.model.animatable.AnimatableIntegerValue d;
    public final com.airbnb.lottie.model.animatable.AnimatablePointValue e;
    public final com.airbnb.lottie.model.animatable.AnimatablePointValue f;
    public final java.lang.String g;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue h;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue i;
    public final boolean j;

    public GradientFill(java.lang.String str, com.airbnb.lottie.model.content.GradientType gradientType, android.graphics.Path.FillType fillType, com.airbnb.lottie.model.animatable.AnimatableGradientColorValue animatableGradientColorValue, com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue, com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue, com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue2, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.a = gradientType;
        this.b = fillType;
        this.c = animatableGradientColorValue;
        this.d = animatableIntegerValue;
        this.e = animatablePointValue;
        this.f = animatablePointValue2;
        this.g = str;
        this.h = animatableFloatValue;
        this.i = animatableFloatValue2;
        this.j = z;
    }

    public com.airbnb.lottie.model.animatable.AnimatablePointValue getEndPoint() {
        return this.f;
    }

    public android.graphics.Path.FillType getFillType() {
        return this.b;
    }

    public com.airbnb.lottie.model.animatable.AnimatableGradientColorValue getGradientColor() {
        return this.c;
    }

    public com.airbnb.lottie.model.content.GradientType getGradientType() {
        return this.a;
    }

    public java.lang.String getName() {
        return this.g;
    }

    public com.airbnb.lottie.model.animatable.AnimatableIntegerValue getOpacity() {
        return this.d;
    }

    public com.airbnb.lottie.model.animatable.AnimatablePointValue getStartPoint() {
        return this.e;
    }

    public boolean isHidden() {
        return this.j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.GradientFillContent(lottieDrawable, baseLayer, this);
    }
}
