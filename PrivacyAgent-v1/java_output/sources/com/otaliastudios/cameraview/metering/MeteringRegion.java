package com.otaliastudios.cameraview.metering;

/* loaded from: classes19.dex */
class MeteringRegion implements java.lang.Comparable<com.otaliastudios.cameraview.metering.MeteringRegion> {
    public final android.graphics.RectF n;
    public final int t;

    public MeteringRegion(@androidx.annotation.NonNull android.graphics.RectF rectF, int i) {
        this.n = rectF;
        this.t = i;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.metering.MeteringRegion a(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        android.graphics.RectF rectF2 = new android.graphics.RectF();
        rectF2.set(java.lang.Math.max(rectF.left, this.n.left), java.lang.Math.max(rectF.top, this.n.top), java.lang.Math.min(rectF.right, this.n.right), java.lang.Math.min(rectF.bottom, this.n.bottom));
        return new com.otaliastudios.cameraview.metering.MeteringRegion(rectF2, this.t);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.metering.MeteringRegion b(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        return a(new android.graphics.RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()));
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@androidx.annotation.NonNull com.otaliastudios.cameraview.metering.MeteringRegion meteringRegion) {
        return -java.lang.Integer.valueOf(this.t).compareTo(java.lang.Integer.valueOf(meteringRegion.t));
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.metering.MeteringRegion d(@androidx.annotation.NonNull com.otaliastudios.cameraview.metering.MeteringTransform meteringTransform) {
        android.graphics.RectF rectF = new android.graphics.RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
        android.graphics.PointF pointF = new android.graphics.PointF();
        android.graphics.RectF rectF2 = this.n;
        pointF.set(rectF2.left, rectF2.top);
        android.graphics.PointF transformMeteringPoint = meteringTransform.transformMeteringPoint(pointF);
        e(rectF, transformMeteringPoint);
        android.graphics.RectF rectF3 = this.n;
        transformMeteringPoint.set(rectF3.right, rectF3.top);
        android.graphics.PointF transformMeteringPoint2 = meteringTransform.transformMeteringPoint(transformMeteringPoint);
        e(rectF, transformMeteringPoint2);
        android.graphics.RectF rectF4 = this.n;
        transformMeteringPoint2.set(rectF4.right, rectF4.bottom);
        android.graphics.PointF transformMeteringPoint3 = meteringTransform.transformMeteringPoint(transformMeteringPoint2);
        e(rectF, transformMeteringPoint3);
        android.graphics.RectF rectF5 = this.n;
        transformMeteringPoint3.set(rectF5.left, rectF5.bottom);
        e(rectF, meteringTransform.transformMeteringPoint(transformMeteringPoint3));
        return new com.otaliastudios.cameraview.metering.MeteringRegion(rectF, this.t);
    }

    public final void e(@androidx.annotation.NonNull android.graphics.RectF rectF, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        rectF.left = java.lang.Math.min(rectF.left, pointF.x);
        rectF.top = java.lang.Math.min(rectF.top, pointF.y);
        rectF.right = java.lang.Math.max(rectF.right, pointF.x);
        rectF.bottom = java.lang.Math.max(rectF.bottom, pointF.y);
    }
}
