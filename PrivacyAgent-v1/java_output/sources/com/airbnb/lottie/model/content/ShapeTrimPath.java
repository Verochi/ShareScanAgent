package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class ShapeTrimPath implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final com.airbnb.lottie.model.content.ShapeTrimPath.Type b;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue c;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue d;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue e;
    public final boolean f;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static com.airbnb.lottie.model.content.ShapeTrimPath.Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new java.lang.IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(java.lang.String str, com.airbnb.lottie.model.content.ShapeTrimPath.Type type, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.a = str;
        this.b = type;
        this.c = animatableFloatValue;
        this.d = animatableFloatValue2;
        this.e = animatableFloatValue3;
        this.f = z;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getEnd() {
        return this.d;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getOffset() {
        return this.e;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getStart() {
        return this.c;
    }

    public com.airbnb.lottie.model.content.ShapeTrimPath.Type getType() {
        return this.b;
    }

    public boolean isHidden() {
        return this.f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.TrimPathContent(baseLayer, this);
    }

    public java.lang.String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + com.alipay.sdk.m.u.i.d;
    }
}
