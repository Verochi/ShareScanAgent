package com.aliyun.svideosdk.preview.utils;

/* loaded from: classes12.dex */
public class b {
    private static final java.lang.String e = "b";
    private float a;
    private float b;
    private com.aliyun.svideosdk.preview.utils.a c;
    private android.graphics.Rect d = new android.graphics.Rect();

    private int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private android.graphics.Rect a(android.graphics.RectF rectF) {
        return new android.graphics.Rect(java.lang.Math.round(rectF.left), java.lang.Math.round(rectF.top), java.lang.Math.round(rectF.right), java.lang.Math.round(rectF.bottom));
    }

    private android.graphics.RectF a(android.graphics.Rect rect) {
        return new android.graphics.RectF(rect);
    }

    @android.annotation.TargetApi(21)
    private android.hardware.camera2.params.MeteringRectangle a(int i, int i2) {
        this.d.width();
        int i3 = i / 2;
        int i4 = ((int) this.a) - i3;
        android.graphics.Rect rect = this.d;
        int a = a(i4, rect.left, rect.right - i);
        int i5 = ((int) this.b) - i3;
        android.graphics.Rect rect2 = this.d;
        android.graphics.Rect a2 = a(this.c.b(new android.graphics.RectF(a, a(i5, rect2.top, rect2.bottom - i), a + i, r1 + i)));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("calcTapAreaForCamera2, calculate Focus Area, mFocusRect = {");
        sb.append(a2.left);
        sb.append(", ");
        sb.append(a2.top);
        sb.append(", ");
        sb.append(a2.right);
        sb.append(", ");
        sb.append(a2.bottom);
        sb.append(com.alipay.sdk.m.u.i.d);
        return new android.hardware.camera2.params.MeteringRectangle(a2, i2);
    }

    public android.hardware.camera2.params.MeteringRectangle a(float f, float f2, boolean z) {
        this.a = f;
        this.b = f2;
        this.d.width();
        int width = this.d.width();
        return a(z ? width / 5 : width / 4, 1000);
    }

    public void a(int i, int i2, int i3, android.graphics.Rect rect, int i4) {
        android.graphics.Rect rect2 = new android.graphics.Rect(0, 0, i, i2);
        this.d = rect2;
        this.c = new com.aliyun.svideosdk.preview.utils.a(i3, rect, i4, a(rect2));
    }
}
