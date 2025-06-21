package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class Mask {
    public final com.airbnb.lottie.model.content.Mask.MaskMode a;
    public final com.airbnb.lottie.model.animatable.AnimatableShapeValue b;
    public final com.airbnb.lottie.model.animatable.AnimatableIntegerValue c;
    public final boolean d;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(com.airbnb.lottie.model.content.Mask.MaskMode maskMode, com.airbnb.lottie.model.animatable.AnimatableShapeValue animatableShapeValue, com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue, boolean z) {
        this.a = maskMode;
        this.b = animatableShapeValue;
        this.c = animatableIntegerValue;
        this.d = z;
    }

    public com.airbnb.lottie.model.content.Mask.MaskMode getMaskMode() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableShapeValue getMaskPath() {
        return this.b;
    }

    public com.airbnb.lottie.model.animatable.AnimatableIntegerValue getOpacity() {
        return this.c;
    }

    public boolean isInverted() {
        return this.d;
    }
}
