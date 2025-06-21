package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class CircleShape implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> b;
    public final com.airbnb.lottie.model.animatable.AnimatablePointValue c;
    public final boolean d;
    public final boolean e;

    public CircleShape(java.lang.String str, com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue, com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue, boolean z, boolean z2) {
        this.a = str;
        this.b = animatableValue;
        this.c = animatablePointValue;
        this.d = z;
        this.e = z2;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> getPosition() {
        return this.b;
    }

    public com.airbnb.lottie.model.animatable.AnimatablePointValue getSize() {
        return this.c;
    }

    public boolean isHidden() {
        return this.e;
    }

    public boolean isReversed() {
        return this.d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.EllipseContent(lottieDrawable, baseLayer, this);
    }
}
