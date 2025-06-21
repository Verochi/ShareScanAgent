package com.otaliastudios.opengl.extensions;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0012\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0000*\u00020\u0000\u001a(\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005\u001a\u0012\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005\u001a\u0012\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005\u001a(\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005\u001a\u0012\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005\u001a\u0012\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005\u001a\u0012\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005\u001a*\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a\u0012\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005\u001a\u0012\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005\u001a\u0012\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005¨\u0006\u0017"}, d2 = {"", "", "a", "makeIdentity", "clear", "", "x", "y", com.umeng.analytics.pro.bo.aJ, "translate", "translation", "translateX", "translateY", "translateZ", "scale", "scaleX", "scaleY", "scaleZ", "angle", "rotate", "rotateX", "rotateY", "rotateZ", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class MatrixKt {
    public static final void a(float[] fArr) {
        if (fArr.length != 16) {
            throw new java.lang.RuntimeException("Need a 16 values matrix.");
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] clear(@org.jetbrains.annotations.NotNull float[] clear) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clear, "$this$clear");
        return makeIdentity(clear);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] makeIdentity(@org.jetbrains.annotations.NotNull float[] makeIdentity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(makeIdentity, "$this$makeIdentity");
        a(makeIdentity);
        com.otaliastudios.opengl.internal.MiscKt.matrixMakeIdentity(makeIdentity);
        return makeIdentity;
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] rotate(@org.jetbrains.annotations.NotNull float[] rotate, float f, float f2, float f3, float f4) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rotate, "$this$rotate");
        a(rotate);
        com.otaliastudios.opengl.internal.MiscKt.matrixRotate(rotate, f, f2, f3, f4);
        return rotate;
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] rotateX(@org.jetbrains.annotations.NotNull float[] rotateX, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rotateX, "$this$rotateX");
        return rotate(rotateX, f, 1.0f, 0.0f, 0.0f);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] rotateY(@org.jetbrains.annotations.NotNull float[] rotateY, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rotateY, "$this$rotateY");
        return rotate(rotateY, f, 0.0f, 1.0f, 0.0f);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] rotateZ(@org.jetbrains.annotations.NotNull float[] rotateZ, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rotateZ, "$this$rotateZ");
        return rotate(rotateZ, f, 0.0f, 0.0f, 1.0f);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] scale(@org.jetbrains.annotations.NotNull float[] scale, float f, float f2, float f3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scale, "$this$scale");
        a(scale);
        com.otaliastudios.opengl.internal.MiscKt.matrixScale(scale, f, f2, f3);
        return scale;
    }

    public static /* synthetic */ float[] scale$default(float[] fArr, float f, float f2, float f3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        return scale(fArr, f, f2, f3);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] scaleX(@org.jetbrains.annotations.NotNull float[] scaleX, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scaleX, "$this$scaleX");
        return scale$default(scaleX, f, 0.0f, 0.0f, 6, null);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] scaleY(@org.jetbrains.annotations.NotNull float[] scaleY, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scaleY, "$this$scaleY");
        return scale$default(scaleY, 0.0f, f, 0.0f, 5, null);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] scaleZ(@org.jetbrains.annotations.NotNull float[] scaleZ, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scaleZ, "$this$scaleZ");
        return scale$default(scaleZ, 0.0f, 0.0f, f, 3, null);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] translate(@org.jetbrains.annotations.NotNull float[] translate, float f, float f2, float f3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(translate, "$this$translate");
        a(translate);
        com.otaliastudios.opengl.internal.MiscKt.matrixTranslate(translate, f, f2, f3);
        return translate;
    }

    public static /* synthetic */ float[] translate$default(float[] fArr, float f, float f2, float f3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        return translate(fArr, f, f2, f3);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] translateX(@org.jetbrains.annotations.NotNull float[] translateX, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(translateX, "$this$translateX");
        return translate$default(translateX, f, 0.0f, 0.0f, 6, null);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] translateY(@org.jetbrains.annotations.NotNull float[] translateY, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(translateY, "$this$translateY");
        return translate$default(translateY, 0.0f, f, 0.0f, 5, null);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] translateZ(@org.jetbrains.annotations.NotNull float[] translateZ, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(translateZ, "$this$translateZ");
        return translate$default(translateZ, 0.0f, 0.0f, f, 3, null);
    }
}
