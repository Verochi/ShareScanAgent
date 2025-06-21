package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class ShapePath implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final int b;
    public final com.airbnb.lottie.model.animatable.AnimatableShapeValue c;
    public final boolean d;

    public ShapePath(java.lang.String str, int i, com.airbnb.lottie.model.animatable.AnimatableShapeValue animatableShapeValue, boolean z) {
        this.a = str;
        this.b = i;
        this.c = animatableShapeValue;
        this.d = z;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableShapeValue getShapePath() {
        return this.c;
    }

    public boolean isHidden() {
        return this.d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.ShapeContent(lottieDrawable, baseLayer, this);
    }

    public java.lang.String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
