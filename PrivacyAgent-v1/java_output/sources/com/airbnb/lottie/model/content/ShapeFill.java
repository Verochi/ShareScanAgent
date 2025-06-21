package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class ShapeFill implements com.airbnb.lottie.model.content.ContentModel {
    public final boolean a;
    public final android.graphics.Path.FillType b;
    public final java.lang.String c;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableColorValue d;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableIntegerValue e;
    public final boolean f;

    public ShapeFill(java.lang.String str, boolean z, android.graphics.Path.FillType fillType, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = animatableColorValue;
        this.e = animatableIntegerValue;
        this.f = z2;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableColorValue getColor() {
        return this.d;
    }

    public android.graphics.Path.FillType getFillType() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.c;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableIntegerValue getOpacity() {
        return this.e;
    }

    public boolean isHidden() {
        return this.f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.FillContent(lottieDrawable, baseLayer, this);
    }

    public java.lang.String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
