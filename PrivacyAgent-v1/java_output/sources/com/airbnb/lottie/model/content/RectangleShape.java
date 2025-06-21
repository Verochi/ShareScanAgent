package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class RectangleShape implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> b;
    public final com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> c;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue d;
    public final boolean e;

    public RectangleShape(java.lang.String str, com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue, com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue2, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, boolean z) {
        this.a = str;
        this.b = animatableValue;
        this.c = animatableValue2;
        this.d = animatableFloatValue;
        this.e = z;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getCornerRadius() {
        return this.d;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> getPosition() {
        return this.b;
    }

    public com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> getSize() {
        return this.c;
    }

    public boolean isHidden() {
        return this.e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.RectangleContent(lottieDrawable, baseLayer, this);
    }

    public java.lang.String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
