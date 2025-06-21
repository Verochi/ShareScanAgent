package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class PolystarShape implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final com.airbnb.lottie.model.content.PolystarShape.Type b;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue c;
    public final com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> d;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue e;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue f;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue g;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue h;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue i;
    public final boolean j;

    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static com.airbnb.lottie.model.content.PolystarShape.Type forValue(int i) {
            for (com.airbnb.lottie.model.content.PolystarShape.Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(java.lang.String str, com.airbnb.lottie.model.content.PolystarShape.Type type, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue3, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue4, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue5, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue6, boolean z) {
        this.a = str;
        this.b = type;
        this.c = animatableFloatValue;
        this.d = animatableValue;
        this.e = animatableFloatValue2;
        this.f = animatableFloatValue3;
        this.g = animatableFloatValue4;
        this.h = animatableFloatValue5;
        this.i = animatableFloatValue6;
        this.j = z;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getInnerRadius() {
        return this.f;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getInnerRoundedness() {
        return this.h;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getOuterRadius() {
        return this.g;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getOuterRoundedness() {
        return this.i;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getPoints() {
        return this.c;
    }

    public com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> getPosition() {
        return this.d;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getRotation() {
        return this.e;
    }

    public com.airbnb.lottie.model.content.PolystarShape.Type getType() {
        return this.b;
    }

    public boolean isHidden() {
        return this.j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.PolystarContent(lottieDrawable, baseLayer, this);
    }
}
