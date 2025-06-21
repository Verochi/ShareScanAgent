package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class ShapeStroke implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue b;
    public final java.util.List<com.airbnb.lottie.model.animatable.AnimatableFloatValue> c;
    public final com.airbnb.lottie.model.animatable.AnimatableColorValue d;
    public final com.airbnb.lottie.model.animatable.AnimatableIntegerValue e;
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue f;
    public final com.airbnb.lottie.model.content.ShapeStroke.LineCapType g;
    public final com.airbnb.lottie.model.content.ShapeStroke.LineJoinType h;
    public final float i;
    public final boolean j;

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values().length];
            b = iArr;
            try {
                iArr[com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.BEVEL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.MITER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                b[com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.ROUND.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values().length];
            a = iArr2;
            try {
                iArr2[com.airbnb.lottie.model.content.ShapeStroke.LineCapType.BUTT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.airbnb.lottie.model.content.ShapeStroke.LineCapType.ROUND.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.airbnb.lottie.model.content.ShapeStroke.LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public android.graphics.Paint.Cap toPaintCap() {
            int i = com.airbnb.lottie.model.content.ShapeStroke.AnonymousClass1.a[ordinal()];
            return i != 1 ? i != 2 ? android.graphics.Paint.Cap.SQUARE : android.graphics.Paint.Cap.ROUND : android.graphics.Paint.Cap.BUTT;
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public android.graphics.Paint.Join toPaintJoin() {
            int i = com.airbnb.lottie.model.content.ShapeStroke.AnonymousClass1.b[ordinal()];
            if (i == 1) {
                return android.graphics.Paint.Join.BEVEL;
            }
            if (i == 2) {
                return android.graphics.Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return android.graphics.Paint.Join.ROUND;
        }
    }

    public ShapeStroke(java.lang.String str, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, java.util.List<com.airbnb.lottie.model.animatable.AnimatableFloatValue> list, com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue, com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2, com.airbnb.lottie.model.content.ShapeStroke.LineCapType lineCapType, com.airbnb.lottie.model.content.ShapeStroke.LineJoinType lineJoinType, float f, boolean z) {
        this.a = str;
        this.b = animatableFloatValue;
        this.c = list;
        this.d = animatableColorValue;
        this.e = animatableIntegerValue;
        this.f = animatableFloatValue2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f;
        this.j = z;
    }

    public com.airbnb.lottie.model.content.ShapeStroke.LineCapType getCapType() {
        return this.g;
    }

    public com.airbnb.lottie.model.animatable.AnimatableColorValue getColor() {
        return this.d;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getDashOffset() {
        return this.b;
    }

    public com.airbnb.lottie.model.content.ShapeStroke.LineJoinType getJoinType() {
        return this.h;
    }

    public java.util.List<com.airbnb.lottie.model.animatable.AnimatableFloatValue> getLineDashPattern() {
        return this.c;
    }

    public float getMiterLimit() {
        return this.i;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.model.animatable.AnimatableIntegerValue getOpacity() {
        return this.e;
    }

    public com.airbnb.lottie.model.animatable.AnimatableFloatValue getWidth() {
        return this.f;
    }

    public boolean isHidden() {
        return this.j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.StrokeContent(lottieDrawable, baseLayer, this);
    }
}
