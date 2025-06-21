package com.anythink.expressad.video.dynview.i;

/* loaded from: classes12.dex */
public final class a {
    private static android.graphics.PointF a(float f, android.graphics.PointF pointF, android.graphics.PointF pointF2, android.graphics.PointF pointF3) {
        android.graphics.PointF pointF4 = new android.graphics.PointF();
        float f2 = 1.0f - f;
        float f3 = f2 * f2;
        float f4 = 2.0f * f * f2;
        float f5 = f * f;
        pointF4.x = (pointF.x * f3) + (pointF2.x * f4) + (pointF3.x * f5);
        pointF4.y = (f3 * pointF.y) + (f4 * pointF2.y) + (f5 * pointF3.y);
        return pointF4;
    }

    private static android.graphics.PointF a(float f, android.graphics.PointF pointF, android.graphics.PointF pointF2, android.graphics.PointF pointF3, android.graphics.PointF pointF4) {
        android.graphics.PointF pointF5 = new android.graphics.PointF();
        float f2 = 1.0f - f;
        pointF5.x = (pointF.x * f2 * f2 * f2) + (pointF2.x * 3.0f * f * f2 * f2) + (pointF3.x * 3.0f * f * f * f2) + (pointF4.x * f * f * f);
        pointF5.y = (pointF.y * f2 * f2 * f2) + (pointF2.y * 3.0f * f * f2 * f2) + (pointF3.y * 3.0f * f * f * f2) + (pointF4.y * f * f * f);
        return pointF5;
    }
}
