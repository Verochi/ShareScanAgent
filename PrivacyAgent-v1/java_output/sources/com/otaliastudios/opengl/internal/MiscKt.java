package com.otaliastudios.opengl.internal;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\u0019\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0000\u001a \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0000\u001a0\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0000\u001a(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0000\u001a(\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0000¨\u0006\u001c"}, d2 = {"gluErrorString", "", "value", "", "intToHexString", "loge", "", "tag", "message", "logi", "logv", "logw", "matrixClone", "", "matrix", "matrixMakeIdentity", "matrixMultiply", "result", com.sensorsdata.sf.ui.view.UIProperty.left, com.sensorsdata.sf.ui.view.UIProperty.right, "matrixRotate", "angle", "", "x", "y", com.umeng.analytics.pro.bo.aJ, "matrixScale", "matrixTranslate", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class MiscKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String gluErrorString(int i) {
        java.lang.String gluErrorString = android.opengl.GLU.gluErrorString(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(gluErrorString, "GLU.gluErrorString(value)");
        return gluErrorString;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String intToHexString(int i) {
        java.lang.String hexString = java.lang.Integer.toHexString(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(value)");
        return hexString;
    }

    public static final void loge(@org.jetbrains.annotations.NotNull java.lang.String tag, @org.jetbrains.annotations.NotNull java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tag, "tag");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
    }

    public static final void logi(@org.jetbrains.annotations.NotNull java.lang.String tag, @org.jetbrains.annotations.NotNull java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tag, "tag");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
    }

    public static final void logv(@org.jetbrains.annotations.NotNull java.lang.String tag, @org.jetbrains.annotations.NotNull java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tag, "tag");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
    }

    public static final void logw(@org.jetbrains.annotations.NotNull java.lang.String tag, @org.jetbrains.annotations.NotNull java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tag, "tag");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] matrixClone(@org.jetbrains.annotations.NotNull float[] matrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matrix, "matrix");
        return (float[]) matrix.clone();
    }

    public static final void matrixMakeIdentity(@org.jetbrains.annotations.NotNull float[] matrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matrix, "matrix");
        android.opengl.Matrix.setIdentityM(matrix, 0);
    }

    public static final void matrixMultiply(@org.jetbrains.annotations.NotNull float[] result, @org.jetbrains.annotations.NotNull float[] left, @org.jetbrains.annotations.NotNull float[] right) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(left, "left");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(right, "right");
        android.opengl.Matrix.multiplyMM(result, 0, left, 0, right, 0);
    }

    public static final void matrixRotate(@org.jetbrains.annotations.NotNull float[] matrix, float f, float f2, float f3, float f4) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matrix, "matrix");
        android.opengl.Matrix.rotateM(matrix, 0, f, f2, f3, f4);
    }

    public static final void matrixScale(@org.jetbrains.annotations.NotNull float[] matrix, float f, float f2, float f3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matrix, "matrix");
        android.opengl.Matrix.scaleM(matrix, 0, f, f2, f3);
    }

    public static final void matrixTranslate(@org.jetbrains.annotations.NotNull float[] matrix, float f, float f2, float f3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matrix, "matrix");
        android.opengl.Matrix.translateM(matrix, 0, f, f2, f3);
    }
}
