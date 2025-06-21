package com.aliyun.svideosdk.preview.utils;

/* loaded from: classes12.dex */
public class a {
    private final java.lang.String a = com.aliyun.svideosdk.preview.utils.a.class.getSimpleName();
    private final android.graphics.Matrix b;
    private android.graphics.RectF c;

    @android.annotation.TargetApi(21)
    public a(int i, android.graphics.Rect rect, int i2, android.graphics.RectF rectF) {
        if (!a(rectF)) {
            throw new java.lang.IllegalArgumentException("previewRect");
        }
        this.c = new android.graphics.RectF(rect);
        android.graphics.Matrix a = a(i2 == 0, i, rectF);
        this.b = a;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("CoordinateTransformer, mDriverRectF = {");
        sb.append(this.c.left);
        sb.append(", ");
        sb.append(this.c.right);
        sb.append(", ");
        sb.append(this.c.top);
        sb.append(", ");
        sb.append(this.c.bottom);
        sb.append(com.alipay.sdk.m.u.i.d);
        a.getValues(new float[16]);
    }

    private android.graphics.Matrix a(boolean z, int i, android.graphics.RectF rectF) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(-i);
        matrix.mapRect(rectF);
        android.graphics.Matrix matrix2 = new android.graphics.Matrix();
        matrix2.setRectToRect(rectF, this.c, android.graphics.Matrix.ScaleToFit.FILL);
        matrix.setConcat(matrix2, matrix);
        return matrix;
    }

    private boolean a(android.graphics.RectF rectF) {
        return (rectF.width() == 0.0f || rectF.height() == 0.0f) ? false : true;
    }

    public android.graphics.RectF b(android.graphics.RectF rectF) {
        android.graphics.RectF rectF2 = new android.graphics.RectF();
        this.b.mapRect(rectF2, rectF);
        return rectF2;
    }
}
