package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class Repeater implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue b;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue c;
    public final com.airbnb.lottie.model.animatable.AnimatableTransform d;
    public final boolean e;

    public Repeater(java.lang.String str, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2, com.airbnb.lottie.model.animatable.AnimatableTransform animatableTransform, boolean z) {
        this.a = str;
        this.b = animatableFloatValue;
        this.c = animatableFloatValue2;
        this.d = animatableTransform;
        this.e = z;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getCopies() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getOffset() {
        return this.c;
    }

    public com.airbnb.lottie.model.animatable.AnimatableTransform getTransform() {
        return this.d;
    }

    public boolean isHidden() {
        return this.e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.RepeaterContent(lottieDrawable, baseLayer, this);
    }
}
