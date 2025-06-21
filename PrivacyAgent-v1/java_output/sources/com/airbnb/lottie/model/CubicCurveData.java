package com.airbnb.lottie.model;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class CubicCurveData {
    public final android.graphics.PointF a;
    public final android.graphics.PointF b;
    public final android.graphics.PointF c;

    public CubicCurveData() {
        this.a = new android.graphics.PointF();
        this.b = new android.graphics.PointF();
        this.c = new android.graphics.PointF();
    }

    public CubicCurveData(android.graphics.PointF pointF, android.graphics.PointF pointF2, android.graphics.PointF pointF3) {
        this.a = pointF;
        this.b = pointF2;
        this.c = pointF3;
    }

    public android.graphics.PointF getControlPoint1() {
        return this.a;
    }

    public android.graphics.PointF getControlPoint2() {
        return this.b;
    }

    public android.graphics.PointF getVertex() {
        return this.c;
    }

    public void setControlPoint1(float f, float f2) {
        this.a.set(f, f2);
    }

    public void setControlPoint2(float f, float f2) {
        this.b.set(f, f2);
    }

    public void setVertex(float f, float f2) {
        this.c.set(f, f2);
    }
}
